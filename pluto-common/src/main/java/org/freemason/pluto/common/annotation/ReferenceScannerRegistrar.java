package org.freemason.pluto.common.annotation;

import org.freemason.pluto.common.core.proxy.InvocationFactoryBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * 将{@link ClassPathReferenceScanner#doScan(String...)}获取到的所有BeanDefinitionHolder封装为BeanDefinition并注册
 * @author wangran0430@gmail.com
 * @since 1.0
 */
public class ReferenceScannerRegistrar implements ImportBeanDefinitionRegistrar {
    private static final String BASE_PACKAGES = "basePackages";
    private ApplicationContext applicationContext;
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotationAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ReferenceScan.class.getName()));
        ClassPathReferenceScanner scanner = new ClassPathReferenceScanner(registry);
        String[] basePackages = annotationAttrs.getStringArray(BASE_PACKAGES);
        Set<BeanDefinitionHolder> beanDefinitionHolders = scanner.doScan(basePackages);
        if (!beanDefinitionHolders.isEmpty()){
            processBeanDefinitions(beanDefinitionHolders);
        }
    }
    //  加工扫描到的bean
    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions){
        beanDefinitions.forEach(holder -> {
            GenericBeanDefinition definition = (GenericBeanDefinition)holder.getBeanDefinition();
            String originalClassName = definition.getBeanClassName();
            /**
             * 调用{@link ProxyFactoryBean#ProxyFactoryBean(Class)}
             * ProxyFactoryBean “必须” 提供 含参构造函数
             * spring可以将 （String）beanOriginalClassName 转化为对应的Class
             *
             * 如果用属性值则 对应属性必须提供set方法
             * definition.getPropertyValues().add("referencedInterface", beanOriginalClassName);
             */
            //definition.getConstructorArgumentValues().addGenericArgumentValue(originalClassName);
            definition.getPropertyValues().add("referencedInterface", originalClassName);
            definition.setBeanClass(InvocationFactoryBean.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        });
    }

}

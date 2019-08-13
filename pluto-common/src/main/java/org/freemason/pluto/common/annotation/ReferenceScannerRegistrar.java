package org.freemason.pluto.common.annotation;

import org.freemason.pluto.common.core.ProxyFactoryBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
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
    private static final String BASE_PACKAGE = "basePackages";
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotationAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ReferenceScan.class.getName()));
        ClassPathReferenceScanner scanner = new ClassPathReferenceScanner(registry);
        String[] basePackages = annotationAttrs.getStringArray(BASE_PACKAGE);
        Set<BeanDefinitionHolder> beanDefinitionHolders = scanner.doScan(basePackages);
        if (!beanDefinitionHolders.isEmpty()){
            processBeanDefinitions(beanDefinitionHolders, registry);
        }
    }
    //  注册扫描到的bean
    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions, BeanDefinitionRegistry registry){
        beanDefinitions.forEach(holder -> {
            //  被代理的接口名为definition的
            String beanOriginalClassName = holder.getBeanDefinition().getBeanClassName();
            //BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanOriginalClassName);
            //GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
            GenericBeanDefinition definition = (GenericBeanDefinition)holder.getBeanDefinition();
            definition.getConstructorArgumentValues().addGenericArgumentValue(beanOriginalClassName);
            definition.setBeanClass(ProxyFactoryBean.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
            registry.registerBeanDefinition(holder.getBeanName(), definition);
        });
    }

}

package org.freemason.pluto.pluto.common.annotation;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.util.Set;

public class ReferenceScannerRegistrar implements ImportBeanDefinitionRegistrar,ResourceLoaderAware {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ReferenceScan.class.getName()));

        ClassPathReferenceScanner scanner = new ClassPathReferenceScanner(registry);

        scanner.addIncludeFilter((MetadataReader var1, MetadataReaderFactory var2) -> {

            System.out.println(var1.getClassMetadata().getEnclosingClassName());
            return var1.getClassMetadata().isInterface();
        });

        String[] pkgs = annoAttrs.getStringArray("basePackages");


        Set<BeanDefinitionHolder> ss = scanner.doScan(pkgs);

        System.out.println(ss);
        /*AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ReferenceScan.class.getName()));
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return metadataReader.getClassMetadata().isInterface();
            }
        });
        //scanner.scan()
        String[] pkg = annoAttrs.getStringArray("basePackages");
        System.out.println(scanner.scan(pkg));
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClazz);
        GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
        definition.setBeanClass(InterfaceFactoryBean.class);
        definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
        registry.registerBeanDefinition(beanClazz.getSimpleName(), definition);

        System.out.println(123);*/


    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        //System.out.println(resourceLoader);


    }
}

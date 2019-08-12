package org.freemason.pluto.pluto.common.annotation;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Set;
/**
 * 扫描{@link ReferenceScan#basePackages()}下的所有包含{@link Reference}并且是接口的class
 * @author wangran
 * @since 1.0
 */
public class ClassPathReferenceScanner extends ClassPathBeanDefinitionScanner {
    private static final String REFERENCE_ANNOTATION_CLASS_NAME = Reference.class.getName();

    public ClassPathReferenceScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
        //扫描过滤器过滤规则为指定base package下的 包含Reference注解 并且是 接口的class
        addIncludeFilter((MetadataReader reader, MetadataReaderFactory var2) ->
                reader.getAnnotationMetadata().hasAnnotation(REFERENCE_ANNOTATION_CLASS_NAME) && reader.getClassMetadata().isInterface()
        );
    }

    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }

}
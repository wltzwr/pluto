package org.freemason.pluto.common.core.proxy;

import org.freemason.pluto.common.annotation.PlutoService;
import org.freemason.pluto.common.core.HandlerMetaData;
import org.freemason.pluto.common.transmission.RequestBody;
import org.freemason.pluto.common.utils.ClassUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 保存所有提供rpc服务的bean 以及bean所有public方法 和 请求参数映射，便于用请求参数快速找到对应的method
 * @author wangran0430@gmail.com
 * @since 1.0
 */
@Component
public class InvocationMappingHandlerMapping implements ApplicationContextAware, InitializingBean {
    private boolean init = false;

    private ApplicationContext applicationContext;

    private Map<RequestBody, HandlerMetaData> invocationHandlerMethodMapping = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet(){
        if (!init){
            Map<String, Object> plutoServiceBeans = this.applicationContext.getBeansWithAnnotation(PlutoService.class);
            plutoServiceBeans.forEach((beanName, bean) ->
                    ClassUtils.getPublicInstanceMethod(bean.getClass()).forEach(method ->
                            invocationHandlerMethodMapping.put(new RequestBody(method), new HandlerMetaData(bean, method)))
            );
            init = true;
        }
    }

    public HandlerMetaData getHandlerMethod(RequestBody body){
        return invocationHandlerMethodMapping.get(body);
    }
}

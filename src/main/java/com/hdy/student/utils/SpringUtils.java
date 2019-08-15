package com.hdy.student.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author m760384371
 * @date 2019/8/14
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplication() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getApplication().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplication().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplication().getBean(name, clazz);
    }
}

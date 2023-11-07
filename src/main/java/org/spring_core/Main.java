package org.spring_core;

import org.spring_core.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        DataInitializer dataInitializer =
                context.getBean("dataInitializer",DataInitializer.class);
        dataInitializer.init();


    }
}

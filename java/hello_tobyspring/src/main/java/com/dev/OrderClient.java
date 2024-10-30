package com.dev;

import com.dev.order.Order;
import com.dev.order.OrderServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class OrderClient {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(OrderConfig.class);
        OrderServiceImpl service = beanFactory.getBean(OrderServiceImpl.class);

        Order order = service.createOrder("0100", BigDecimal.TEN);
        System.out.println(order);


    }
}

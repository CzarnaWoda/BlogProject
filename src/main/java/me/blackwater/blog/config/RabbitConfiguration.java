package me.blackwater.blog.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class RabbitConfiguration {

    static final String POSTS_Q = "posts";

    @Bean
    Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(POSTS_Q).noargs();
    }
    @Bean
    Exchange exchange() {
        return ExchangeBuilder.directExchange(POSTS_Q).build();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable(POSTS_Q).build();
    }
}

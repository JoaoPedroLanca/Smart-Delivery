package com.SmarDelivery.infra.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String PEDIDO_EXCHANGE = "pedido.exchange";

    public static final String PEDIDO_CRIADO_QUEUE = "pedido.criado.queue";

    public static final String PEDIDO_CRIADO_ROUTING_KEY = "pedido.criado";

    @Bean
    public TopicExchange pedidoExchange() {
        return new TopicExchange(PEDIDO_EXCHANGE);
    }

    @Bean
    public Queue pedidoCriadoQueue() {
        return QueueBuilder
                .durable(PEDIDO_CRIADO_QUEUE)
                .build();
    }

    @Bean
    public Binding pedidoCriadoBinding() {
        return BindingBuilder
                .bind(pedidoCriadoQueue())
                .to(pedidoExchange())
                .with(PEDIDO_CRIADO_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}

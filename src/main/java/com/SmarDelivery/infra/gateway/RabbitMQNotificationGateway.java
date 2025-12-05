package com.SmarDelivery.infra.gateway;

import com.SmarDelivery.domain.entities.Pedido;
import com.SmarDelivery.domain.events.PedidoEvent;
import com.SmarDelivery.domain.gateway.NotificationGateway;
import com.SmarDelivery.infra.config.rabbitmq.RabbitMQConfiguration;
import com.SmarDelivery.infra.dtos.events.PedidoEventDto;
import com.SmarDelivery.infra.mappers.PedidoEventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitMQNotificationGateway implements NotificationGateway {

    private final RabbitTemplate rabbitTemplate;
    private final PedidoEventMapper pedidoEventMapper;

    @Override
    public void notificarPedidoCriado(Pedido pedido) {
        try {
            PedidoEvent evento = criarEventoPedidoCriado(pedido);
            PedidoEventDto eventoDto = pedidoEventMapper.toDto(evento);

            rabbitTemplate.convertAndSend(
                    RabbitMQConfiguration.PEDIDO_EXCHANGE,
                    RabbitMQConfiguration.PEDIDO_CRIADO_ROUTING_KEY,
                    eventoDto
            );

            log.info("Notificação de pedido criado enviada: Pedido ID {}", pedido.pedidoId());
        } catch (Exception e) {
            log.error("Erro ao enviar notificação de pedido criado: {}", e.getMessage(), e);
        }
    }

    private PedidoEvent criarEventoPedidoCriado(Pedido pedido) {
        return new PedidoEvent(
                pedido.pedidoId(),
                pedido.clienteId(),
                pedido.restauranteId(),
                pedido.entregadorId(),
                pedido.statusPedido(),
                "PEDIDO_CRIADO",
                LocalDateTime.now()
        );
    }
}

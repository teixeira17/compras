package com.teixeira.mscompras.service.rabbitmq;

import com.teixeira.mscompras.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @PostMapping
    public void enviarPedido(@Payload String payload){
        rabbitTemplate.convertAndSend(queue.getName(), payload);
    }
}

package com.teixeira.mscompras.service.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teixeira.mscompras.model.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper mapper;

    @SneakyThrows
    @PostMapping
    public void enviarPedido(Pedido pedido){
        rabbitTemplate.convertAndSend(queue.getName(), pedido);
        rabbitTemplate.convertAndSend(queue.getName(), mapper.writeValueAsString(pedido));
    }
}

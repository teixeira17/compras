package com.teixeira.mscompras.service;

import com.teixeira.mscompras.model.Pedido;
import com.teixeira.mscompras.repository.PedidoRepository;
import com.teixeira.mscompras.service.rabbitmq.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final Producer producer;

    public Pedido salvar(Pedido pedido) {
        pedido = pedidoRepository.save(pedido);
        producer.enviarPedido(pedido);
        return pedido;
    }
}

package com.SmarDelivery.infra.presentation;

import com.SmarDelivery.domain.usecases.pedido.CriarPedidoUsecase;
import com.SmarDelivery.infra.dtos.requests.PedidoRequestDto;
import com.SmarDelivery.infra.mappers.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final CriarPedidoUsecase criarPedidoUsecase;
    private final PedidoMapper pedidoMapper;

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarPedido(@RequestBody PedidoRequestDto requestDto) {
        criarPedidoUsecase.execute(pedidoMapper.toDomain(requestDto));
        Map<String, Object> resposta = new LinkedHashMap<>();
        resposta.put("Mensagem: ", "Novo pedido cadastrado no sistema com sucesso!");
        resposta.put("Dados do pedido: ", pedidoMapper.toDomain(requestDto));

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}

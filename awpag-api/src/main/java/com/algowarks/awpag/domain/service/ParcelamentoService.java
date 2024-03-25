package com.algowarks.awpag.domain.service;

import com.algowarks.awpag.domain.exception.NegocioException;
import com.algowarks.awpag.domain.model.Cliente;
import com.algowarks.awpag.domain.model.Parcelamento;
import com.algowarks.awpag.domain.repository.ClienteRepository;
import com.algowarks.awpag.domain.repository.ParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class ParcelamentoService {

    private final ParcelamentoRepository parcelamentoRepository;
    private final CadastroClienteService cadastroClienteService;

    @Transactional
    public  Parcelamento cadastrar (Parcelamento novoParcelamento){
        if(novoParcelamento.getId() != null){
            throw new NegocioException("Parcelamento a ser criado não deve possuir um código");
        }

        Cliente cliente = cadastroClienteService.buscar(novoParcelamento.getCliente().getId());

        novoParcelamento.setCliente(cliente);
        novoParcelamento.setDataCriacao(OffsetDateTime.now());
        return  parcelamentoRepository.save(novoParcelamento);
    }

}

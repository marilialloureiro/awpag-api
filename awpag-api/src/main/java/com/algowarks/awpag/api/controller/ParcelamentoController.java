package com.algowarks.awpag.api.controller;

import com.algowarks.awpag.domain.exception.NegocioException;
import com.algowarks.awpag.domain.model.Parcelamento;
import com.algowarks.awpag.domain.repository.ParcelamentoRepository;
import com.algowarks.awpag.domain.service.ParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping ("/parcelamentos")
@RestController
public class ParcelamentoController {

    private ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoService parcelamentoService;

    @GetMapping
    public List<Parcelamento> listar(){
        return parcelamentoRepository.findAll();
    }

    @GetMapping("/{parcelamentosId}")
    public ResponseEntity<Parcelamento> buscar(@PathVariable Long parcelamentoId){
        return parcelamentoRepository.findById(parcelamentoId)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcelamento cadastrar(@Valid @RequestBody Parcelamento parcelamento){
        return parcelamentoService.cadastrar(parcelamento);
    }



}

package com.algowarks.awpag.domain.model;

import com.algowarks.awpag.domain.validation.ValidationGroup;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroup.ClienteId.class)
    @ManyToOne
    @NotNull
    private Cliente cliente;

    @NotBlank
    @Size(max = 20)
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal valorTotal;

    @Max(12)
    @NotNull
    @Positive
    private Integer quantidadeParcelas;

    private OffsetDateTime dataCriacao;
}

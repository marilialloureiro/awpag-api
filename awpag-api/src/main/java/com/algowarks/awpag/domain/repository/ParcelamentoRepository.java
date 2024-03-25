package com.algowarks.awpag.domain.repository;

import com.algowarks.awpag.domain.model.Parcelamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelamentoRepository extends JpaRepository <Parcelamento, Long> {
}

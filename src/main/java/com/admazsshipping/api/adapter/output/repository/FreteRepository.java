package com.admazsshipping.api.adapter.output.repository;

import com.admazsshipping.api.adapter.output.entity.FreteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<FreteEntity, Long> {

    @Query("SELECT f FROM FreteEntity f " +
            "WHERE LOWER(f.descricao) LIKE LOWER(CONCAT('%', :termo, '%')) " +
            "OR LOWER(f.cliente.nome) LIKE LOWER(CONCAT('%', :termo, '%')) ")
    Page<FreteEntity> buscarPorTermo(@Param("termo") String termo, Pageable pageable);
}

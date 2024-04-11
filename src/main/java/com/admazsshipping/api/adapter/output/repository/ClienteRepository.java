package com.admazsshipping.api.adapter.output.repository;

import com.admazsshipping.api.adapter.output.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}

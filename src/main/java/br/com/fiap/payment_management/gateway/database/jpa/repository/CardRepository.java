package br.com.fiap.payment_management.gateway.database.jpa.repository;

import br.com.fiap.payment_management.gateway.database.jpa.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

}

package br.com.barberporto.barberporto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.barberporto.barberporto.domain.Barbeiro;

public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {
}

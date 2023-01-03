package kalo.kaloAdmin_kalo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kalo.kaloAdmin_kalo.domain.Ledgers;

public interface LedgersRepository extends JpaRepository<Ledgers, String>, LedgersRepositoryCustom {
    List<Ledgers> findByUsersIdOrderByCreatedAtDesc(String userId);
}

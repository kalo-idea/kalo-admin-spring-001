package kalo.kaloAdmin_kalo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kalo.kaloAdmin_kalo.domain.Ledgers;

public interface LedgersRepository extends JpaRepository<Ledgers, String> {
    List<Ledgers> findByUsersId(String userId);
}

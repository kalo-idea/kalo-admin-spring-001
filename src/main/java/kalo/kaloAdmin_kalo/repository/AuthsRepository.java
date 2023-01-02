package kalo.kaloAdmin_kalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kalo.kaloAdmin_kalo.domain.Auths;

public interface AuthsRepository extends JpaRepository<Auths, String> {
    
}

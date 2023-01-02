package kalo.kaloAdmin_kalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kalo.kaloAdmin_kalo.domain.Users;

public interface UsersRepository extends JpaRepository<Users, String>, UsersRepositoryCustom {
}

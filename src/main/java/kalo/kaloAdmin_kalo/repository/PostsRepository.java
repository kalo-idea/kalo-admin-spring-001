package kalo.kaloAdmin_kalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kalo.kaloAdmin_kalo.domain.Posts;

public interface PostsRepository extends JpaRepository<Posts, String> {
    
}

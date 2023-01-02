package kalo.kaloAdmin_kalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kalo.kaloAdmin_kalo.domain.DislikePosts;

public interface DislikePostsRepository extends JpaRepository<DislikePosts, String> {
    
}

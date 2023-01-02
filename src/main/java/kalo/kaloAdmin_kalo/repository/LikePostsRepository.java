package kalo.kaloAdmin_kalo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kalo.kaloAdmin_kalo.domain.LikePosts;

public interface LikePostsRepository extends JpaRepository<LikePosts, String> {
    
}

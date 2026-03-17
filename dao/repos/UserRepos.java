package com.example.user.dao.repos;

import com.example.user.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepos extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
}

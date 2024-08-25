package com.example.email.repository;


import com.example.email.domain.UserValid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserValidRepository extends JpaRepository<UserValid,Long> {
    Optional<UserValid> findByUuid(UUID uuid);
}

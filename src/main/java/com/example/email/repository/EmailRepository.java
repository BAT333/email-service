package com.example.email.repository;


import com.example.email.domain.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmailRepository extends JpaRepository<EmailEntity,Long> {
}

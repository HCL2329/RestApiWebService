package com.lti.webservices.webservices.repository;

import com.lti.webservices.webservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User,Integer> {
}

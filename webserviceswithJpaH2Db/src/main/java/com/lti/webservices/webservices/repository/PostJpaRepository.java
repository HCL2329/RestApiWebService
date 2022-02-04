package com.lti.webservices.webservices.repository;

import com.lti.webservices.webservices.model.Post;
import com.lti.webservices.webservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post,Integer> {
}

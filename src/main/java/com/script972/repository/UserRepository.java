package com.script972.repository;

import com.script972.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by script972
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String username );

    User findById(Long id);

    User findByFacebookid(String id);

}


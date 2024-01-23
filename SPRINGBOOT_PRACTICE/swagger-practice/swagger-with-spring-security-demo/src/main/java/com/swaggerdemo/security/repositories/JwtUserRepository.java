package com.swaggerdemo.security.repositories;


import com.swaggerdemo.security.models.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JwtUserRepository extends JpaRepository<JwtUser,Integer> {
    Optional<JwtUser> findByEmail(String email);
}

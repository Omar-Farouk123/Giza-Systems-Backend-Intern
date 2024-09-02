package com.STC.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iUsersRepo extends JpaRepository<Users,String> {
    Optional<Users> findByUsername(String username);
    Users findByusername(String username);
    Optional<Users> findByMail(String mail);
}

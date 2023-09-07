package com.project.projectbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.projectbook.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

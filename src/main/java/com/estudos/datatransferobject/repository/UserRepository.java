package com.estudos.datatransferobject.repository;

import com.estudos.datatransferobject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

package com.agilmetric.repositories;

import com.agilmetric.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    List<UserModel> findByNameContainsIgnoreCase(String name); // Pesquisa por nome
}

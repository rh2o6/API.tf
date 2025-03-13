package com.example.springapi.api.repository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springapi.api.model.Weapon;

import java.util.Optional;


public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
    // You can define custom queries if needed

    Optional<Weapon> findByName(String name);

    boolean existsByName(String name);

    @Transactional
    void deleteByName(String name);
}
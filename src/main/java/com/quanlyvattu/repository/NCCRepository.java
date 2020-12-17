package com.quanlyvattu.repository;

import com.quanlyvattu.model.NCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NCCRepository extends JpaRepository<NCC, Integer> {
}

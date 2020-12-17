package com.quanlyvattu.repository;

import com.quanlyvattu.model.VatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VatTuRepository extends JpaRepository<VatTu, String> {
}

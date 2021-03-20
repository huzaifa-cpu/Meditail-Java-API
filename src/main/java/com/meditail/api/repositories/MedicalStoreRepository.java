package com.meditail.api.repositories;

import com.meditail.api.models.MedicalStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalStoreRepository extends JpaRepository<MedicalStore, Long> {
}

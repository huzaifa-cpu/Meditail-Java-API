package com.meditail.api.repositories;

import com.meditail.api.models.ItemExpiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemExpiryRepository extends JpaRepository<ItemExpiry, Long> {
}

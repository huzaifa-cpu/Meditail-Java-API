package com.meditail.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meditail.api.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}

package com.shaping.shaping.repository;

import com.shaping.shaping.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

package com.polytech.lostandfound.repository;

import com.polytech.lostandfound.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

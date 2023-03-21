package com.example.RestaurantAPI.repo;

import com.example.RestaurantAPI.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface MenuRepo extends JpaRepository<Menu, Long> {
}

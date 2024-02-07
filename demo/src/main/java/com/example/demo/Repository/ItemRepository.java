package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.*;
import com.example.demo.Entities.*;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByTitle(String title);

    List<Item> findByDescription(String description);

    List<Item> findAll();

    Optional<Item> findById(Long id);

}

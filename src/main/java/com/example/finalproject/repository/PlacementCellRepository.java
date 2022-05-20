package com.example.finalproject.repository;

import com.example.finalproject.models.PlacementCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementCellRepository extends JpaRepository<PlacementCell, Long> {
}

package com.example.finalproject.service;

import com.example.finalproject.models.PlacementCell;

import java.util.List;
import java.util.Optional;

public interface IPlacementCellService {
    
    Optional<PlacementCell> findOne(Long id);

    List<PlacementCell> findAll();

    PlacementCell save(PlacementCell entity);

    PlacementCell update(Long id, PlacementCell entity);

    void deleteAll();

    void deleteById(Long id);
}

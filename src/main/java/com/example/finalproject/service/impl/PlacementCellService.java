package com.example.finalproject.service.impl;

import com.example.finalproject.models.PlacementCell;
import com.example.finalproject.repository.PlacementCellRepository;
import com.example.finalproject.service.IPlacementCellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementCellService implements IPlacementCellService {

    @Autowired
    private PlacementCellRepository placementCellRepository;

    @Override
    public Optional<PlacementCell> findOne(Long id) {
        return placementCellRepository.findById(id);
    }

    @Override
    public List<PlacementCell> findAll() {
        return placementCellRepository.findAll();
    }

    @Override
    public PlacementCell save(PlacementCell placementCell) {
        return placementCellRepository.save(placementCell);
    }

    @Override
    public PlacementCell update(Long id, PlacementCell entity) {
        Optional<PlacementCell> placementCell = placementCellRepository.findById(id);
        if(placementCell.isPresent()){
            PlacementCell placementCell1 = placementCell.get();
            placementCell1.setName(entity.getName());
            placementCell1.setVacancies(entity.getVacancies());
            return placementCellRepository.save(placementCell1);
        }
        return null;
    }

    @Override
    public void deleteAll() {
        placementCellRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        placementCellRepository.deleteById(id);
    }
}

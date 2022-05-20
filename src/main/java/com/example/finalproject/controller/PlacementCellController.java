package com.example.finalproject.controller;

import com.example.finalproject.models.PlacementCell;
import com.example.finalproject.service.impl.PlacementCellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/placement-cell")
public class PlacementCellController {

    @Autowired
    private PlacementCellService placementCellService;

    @GetMapping
    public ResponseEntity<List<PlacementCell>> findAll(){
        List<PlacementCell> placementCellList = placementCellService.findAll();
        if(placementCellList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(placementCellList, HttpStatus.OK);
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlacementCell> findById(@PathVariable("id") Long id){
        Optional<PlacementCell> placementCell = placementCellService.findOne(id);
        if(placementCell.isPresent()){
            return new ResponseEntity<>(placementCell.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<PlacementCell> save(@RequestBody PlacementCell placementCell){
        try{
            placementCellService.save(placementCell);
            return new ResponseEntity<>(placementCell, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlacementCell> update(@PathVariable("id") Long id, @RequestBody PlacementCell placementCell){
        try{
            PlacementCell updated = placementCellService.update(id, placementCell);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id){
        try{
            placementCellService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll(){
        try{
            placementCellService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

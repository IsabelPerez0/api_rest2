package edu.uptc.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.uptc.apirest.entities.Matter;
import edu.uptc.apirest.services.MatterService;



@RestController
@RequestMapping("/matters")
public class MatterController {

    @Autowired
    MatterService matterService;

    public MatterController(MatterService matterService) {
        this.matterService = matterService;
    }

    @GetMapping
    public Iterable <Matter> get(){
        return matterService.getMatters();
    }

    @GetMapping("/{id}")
    public Matter findById(@PathVariable String code){
        return matterService.findById(code);
    }

    @PostMapping
    public Matter save(@RequestBody Matter matter){

        return matterService.save(matter);
    }

    @PutMapping("/{id}")
    public Matter update(@RequestBody Matter matter, @PathVariable String id){
        return matterService.update(matter);
    }

    @DeleteMapping("/{id}")
    public Matter delete(@PathVariable("id") String id){
        return matterService.delete(id);
    }
    
}

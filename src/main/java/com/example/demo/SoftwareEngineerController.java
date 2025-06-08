package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("/{id}")
    public SoftwareEngineer getEngineer(@PathVariable int id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }


    @PostMapping
    public void addNewSoftwareengineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("/{id}")
    public void deleteSoftwareEngineer(@PathVariable int id) {
        softwareEngineerService.deleteSoftwareEngineerById(id);
    }

    @PutMapping("/{id}")
    public void updateSoftwareEngineer(@PathVariable Integer id,
                                       @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.updateSoftwareEngineer(id, softwareEngineer);
    }









}

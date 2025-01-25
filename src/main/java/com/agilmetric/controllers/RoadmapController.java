package com.agilmetric.controllers;

import com.agilmetric.dto.RoadmapRequest;
import com.agilmetric.models.RoadmapModel;
import com.agilmetric.services.RoadmapService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roadmaps")
public class RoadmapController {

    final RoadmapService roadmapService;

    public RoadmapController(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
    }

    @GetMapping
    public List<RoadmapModel> findAll() {
        return roadmapService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoadmapModel> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(roadmapService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RoadmapModel> save(@Valid @RequestBody RoadmapRequest request) {
        return ResponseEntity.ok(roadmapService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoadmapModel> update(@PathVariable UUID id, @Valid @RequestBody RoadmapRequest request) {
        return ResponseEntity.ok(roadmapService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        roadmapService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
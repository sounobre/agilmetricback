package com.agilmetric.services.impl;

import com.agilmetric.dto.RoadmapRequest;
import com.agilmetric.models.RoadmapModel;
import com.agilmetric.models.UserModel;
import com.agilmetric.repositories.RoadmapRepository;
import com.agilmetric.repositories.UserRepository;
import com.agilmetric.services.RoadmapService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RoadmapServiceImpl implements RoadmapService {

    final RoadmapRepository roadmapRepository;
    final UserRepository userRepository;

    public RoadmapServiceImpl(RoadmapRepository roadmapRepository, UserRepository userRepository) {
        this.roadmapRepository = roadmapRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<RoadmapModel> findAll() {
        return roadmapRepository.findAll();
    }

    @Override
    public RoadmapModel findById(UUID id) {
        return roadmapRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Roadmap não encontrado com o ID: " + id));
    }

    @Override
    @Transactional
    public RoadmapModel save(RoadmapRequest request) {
        RoadmapModel roadmap = new RoadmapModel();
        roadmap.setTitle(request.title());
        roadmap.setDescription(request.description());

        List<UserModel> team = userRepository.findAllById(request.teamIds());
        roadmap.setTeam(team);

        return roadmapRepository.save(roadmap);
    }

    @Override
    @Transactional
    public RoadmapModel update(UUID id, RoadmapRequest request) {
        RoadmapModel roadmap = findById(id);
        roadmap.setTitle(request.title());
        roadmap.setDescription(request.description());

        List<UserModel> team = userRepository.findAllById(request.teamIds());
        roadmap.setTeam(team);

        return roadmapRepository.save(roadmap);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        roadmapRepository.deleteById(id);
    }
}

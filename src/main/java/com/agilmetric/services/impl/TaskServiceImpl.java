package com.agilmetric.services.impl;

import com.agilmetric.dto.TaskRequest;
import com.agilmetric.models.RoadmapModel;
import com.agilmetric.models.TaskModel;
import com.agilmetric.models.UserModel;
import com.agilmetric.repositories.RoadmapRepository;
import com.agilmetric.repositories.TaskRepository;
import com.agilmetric.repositories.UserRepository;
import com.agilmetric.services.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    final TaskRepository taskRepository;
    final UserRepository userRepository;
    final RoadmapRepository roadmapRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository, RoadmapRepository roadmapRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.roadmapRepository = roadmapRepository;
    }

    @Override
    public List<TaskModel> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskModel findById(UUID id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com o ID: " + id));
    }

    @Override
    @Transactional
    public TaskModel save(TaskRequest request) {
        TaskModel task = new TaskModel();
        task.setName(request.name());
        task.setEstimatedHours(request.estimatedHours());

        UserModel developer = userRepository.findById(request.developerId())
                .orElseThrow(() -> new RuntimeException("Desenvolvedor não encontrado com o ID: " + request.developerId()));
        task.setDeveloper(developer);

        RoadmapModel roadmap = roadmapRepository.findById(request.roadmapId())
                .orElseThrow(() -> new RuntimeException("Roadmap não encontrado com o ID: " + request.roadmapId()));
        task.setRoadmap(roadmap);



        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public TaskModel update(UUID id, TaskRequest request) {
        TaskModel task = findById(id);
        task.setName(request.name());
        task.setEstimatedHours(request.estimatedHours());

        UserModel developer = userRepository.findById(request.developerId())
                .orElseThrow(() -> new RuntimeException("Desenvolvedor não encontrado com o ID: " + request.developerId()));
        task.setDeveloper(developer);

        RoadmapModel roadmap = roadmapRepository.findById(request.roadmapId())
                .orElseThrow(() -> new RuntimeException("Roadmap não encontrado com o ID: " + request.roadmapId()));
        task.setRoadmap(roadmap);

        if (request.dependencyId() != null) {
            TaskModel dependency = taskRepository.findById(request.dependencyId())
                    .orElseThrow(() -> new RuntimeException("Tarefa dependente não encontrada com o ID: " + request.dependencyId()));
        } else {

        }

        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }
}

package com.agilmetric.services;

import com.agilmetric.dto.TaskRequest;
import com.agilmetric.models.TaskModel;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<TaskModel> findAll();
    TaskModel findById(UUID id);
    TaskModel save(TaskRequest request);
    TaskModel update(UUID id, TaskRequest request);
    void delete(UUID id);
}

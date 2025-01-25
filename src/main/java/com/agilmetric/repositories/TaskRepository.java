package com.agilmetric.repositories;

import com.agilmetric.models.RoadmapModel;
import com.agilmetric.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, UUID> {
}

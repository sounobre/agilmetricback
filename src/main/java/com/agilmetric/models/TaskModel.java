package com.agilmetric.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "O nome da tarefa é obrigatório")
    private String name;

    @NotNull(message = "Horas estimadas são obrigatórias")
    private Integer estimatedHours;

    @ManyToOne
    @JoinColumn(name = "developer_id", nullable = false)
    private UserModel developer; // Desenvolvedor responsável

    @ManyToOne
    @JoinColumn(name = "roadmap_id", nullable = false)
    private RoadmapModel roadmap; // Pertence a um Roadmap

    @ManyToOne
    @JoinColumn(name = "dependency_id")
    private TaskModel dependency; // Tarefa que serve como dependência (opcional)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public UserModel getDeveloper() {
        return developer;
    }

    public void setDeveloper(UserModel developer) {
        this.developer = developer;
    }

    public RoadmapModel getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(RoadmapModel roadmap) {
        this.roadmap = roadmap;
    }
}

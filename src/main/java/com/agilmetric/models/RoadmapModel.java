package com.agilmetric.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "roadmaps")
public class RoadmapModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    private String title;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "roadmap_users",
            joinColumns = @JoinColumn(name = "roadmap_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserModel> team; // Lista de usuários envolvidos

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserModel> getTeam() {
        return team;
    }

    public void setTeam(List<UserModel> team) {
        this.team = team;
    }
}
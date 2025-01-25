package com.agilmetric.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
import java.util.UUID;

public record RoadmapRequest(
       // @NotBlank(message = "O")
        String title,
        String description,
        List<UUID> teamIds // IDs dos desenvolvedores no roadmap
) {}

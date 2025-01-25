package com.agilmetric.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TaskRequest(
        @NotBlank(message = "O nome da tarefa é obrigatório")
        String name,

        @NotNull(message = "Horas estimadas são obrigatórias")
        Integer estimatedHours,

        @NotNull(message = "O desenvolvedor é obrigatório")
        UUID developerId,

        @NotNull(message = "O roadmap é obrigatório")
        UUID roadmapId,

        UUID dependencyId // ID da tarefa dependente (opcional)
) {}

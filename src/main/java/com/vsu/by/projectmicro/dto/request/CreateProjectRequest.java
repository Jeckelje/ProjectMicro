package com.vsu.by.projectmicro.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Schema(description = "Create Project Request DTO")
public record CreateProjectRequest
        (

                @NotNull(message = "{project.project_name.notnull}")
                @Size(max = 100, message = "{project.project_name.size}")
                @Schema(description = "Project name", example = "SecureCloud")
                String projectName,

                @NotNull(message = "{project.project_customer_name.notnull}")
                @Size(max = 100, message = "{project.project_customer_name.size}")
                @Schema(description = "Project Customer Name", example = "Tech Solutions Inc.")
                String projectCustomerName,

                @NotNull(message = "{project.start_date.notnull}")
                @Schema(description = "Project start date", example = "2023-10-28")
                Date startDate,

                @NotNull(message = "{project.planned_completion_date.notnull}")
                @Schema(description = "Project planned completion date", example = "2025-01-10")
                Date plannedCompletionDate,

                @Schema(description = "Project actual completion date", example = "2024-12-24")
                Date actualCompletionDate,

                @NotNull(message = "{project.project_manager_name.notnull}")
                @Schema(description = "Project manager name", example = "J.R. Smith")
                String projectManagerName,

                @Schema(description = "Is project completed successfully", example = "true")
                Boolean isCompletedSuccessfully
        ) {
    public CreateProjectRequest {
        if (plannedCompletionDate != null && startDate != null && plannedCompletionDate.compareTo(startDate) < 0) {
            throw new IllegalArgumentException("Planned completion date cannot be earlier than the start date.");
        }
    }
}

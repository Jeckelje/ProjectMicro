package com.vsu.by.projectmicro.domain;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "projects")
@Schema(description = "Project entity info")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "3")
    private Long id;

    @Column(nullable = false, name = "project_name", length = 100)
    @Schema(description = "Project name", example = "Программа для оптимизации рабочего процесса")
    private String projectName;

    @Column(nullable = false, name = "project_customer_name", length = 100)
    @Schema(description = "Project customer name", example = "ООО Минская скотобойня")
    private String projectCustomerName;

    @Column(nullable = false, name = "start_date")
    @Schema(description = "Project start date", example = "2023-10-28")
    private Date startDate;

    @Column(nullable = false, name = "planned_completion_date")
    @Schema(description = "Project planned completion date", example = "2025-01-10")
    private Date plannedCompletionDate;

    @Column(name = "actual_completion_date")
    @Schema(description = "Project actual completion date", example = "2024-12-24")
    private Date actualCompletionDate;

    @Column(nullable = false, name = "project_manager_name", length = 100)
    @Schema(description = "Project manager name", example = "Putin V.V.")
    private String projectManagerName;

    @Column(name = "is_completed_succesfully")
    @Schema(description = "Is project completed successfully", example = "true")
    private Boolean isCompletedSuccessfully;
}


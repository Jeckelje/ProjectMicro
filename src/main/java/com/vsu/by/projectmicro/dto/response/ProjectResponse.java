package com.vsu.by.projectmicro.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Project Response DTO")
public record ProjectResponse
        (
                @Schema(description = "ID of the project")
                Long id,

                @Schema(description = "Project name")
                String projectName,

                @Schema(description = "Project's customer name")
                String projectCustomerName,

                @Schema(description = "Date of the project start")
                Date startDate,

                @Schema(description = "Planned completion date of the project")
                Date plannedCompletionDate,

                @Schema(description = "Actual completion date of the project")
                Date actualCompletionDate,

                @Schema(description = "Project's manager name")
                String projectManagerName,

                @Schema(description = "Is project completed successfully")
                Boolean isCompletedSuccessfully
        ) {
}

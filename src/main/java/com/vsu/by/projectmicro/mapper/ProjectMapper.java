package com.vsu.by.projectmicro.mapper;

import com.vsu.by.projectmicro.domain.Project;
import com.vsu.by.projectmicro.dto.request.CreateProjectRequest;
import com.vsu.by.projectmicro.dto.request.UpdateProjectRequest;
import com.vsu.by.projectmicro.dto.response.ProjectResponse;
import org.mapstruct.*;

import java.net.CacheRequest;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    Project toProject(ProjectResponse projectResponse);

    Project toProject(CreateProjectRequest createProjectRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project toProject(UpdateProjectRequest updateProjectRequest);

    @Mapping(target = "id", ignore = true)
    void updateProjectFromRequest(UpdateProjectRequest updateProjectRequest, @MappingTarget Project project);

}

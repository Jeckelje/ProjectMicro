package com.vsu.by.projectmicro.service;

import com.vsu.by.projectmicro.dto.request.CreateProjectRequest;
import com.vsu.by.projectmicro.dto.request.UpdateProjectRequest;
import com.vsu.by.projectmicro.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(CreateProjectRequest createProjectRequest);

    ProjectResponse updateProject(Long id, UpdateProjectRequest updateProjectRequest);

    void deleteProject(Long id);

    ProjectResponse getProjectById(Long id);

    List<ProjectResponse> getAllProjects();

    List<ProjectResponse> getByProjectCustomerName(String projectCustomerName);

}

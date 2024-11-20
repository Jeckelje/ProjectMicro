package com.vsu.by.projectmicro.service.Impl;

import com.vsu.by.projectmicro.domain.Project;
import com.vsu.by.projectmicro.dto.request.CreateProjectRequest;
import com.vsu.by.projectmicro.dto.request.UpdateProjectRequest;
import com.vsu.by.projectmicro.dto.response.ProjectResponse;
import com.vsu.by.projectmicro.error.ErrorMessages;
import com.vsu.by.projectmicro.exception.DuplicateResourceException;
import com.vsu.by.projectmicro.exception.ResourceNotFoundException;
import com.vsu.by.projectmicro.mapper.ProjectMapper;
import com.vsu.by.projectmicro.repository.ProjectRepository;
import com.vsu.by.projectmicro.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(CreateProjectRequest createProjectRequest) {
        checkProjectExistence(createProjectRequest.projectName());

        Project project = projectMapper.toProject(createProjectRequest);
        return projectMapper.toProjectResponse(projectRepository.save(project));
    }

    @Override
    public ProjectResponse updateProject(Long id, UpdateProjectRequest updateProjectRequest) {
        Project existingProject = findProjectByIdOrThrow(id);
        projectMapper.updateProjectFromRequest(updateProjectRequest, existingProject);

        Project updatedProject = projectRepository.save(existingProject);
        return projectMapper.toProjectResponse(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = findProjectByIdOrThrow(id);
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        Project project = findProjectByIdOrThrow(id);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toProjectResponse)
                .toList();
    }

    @Override
    public List<ProjectResponse> getByProjectCustomerName(String projectCustomerName) {
        List<Project> projects = findProjectsByProjectCustomerNameOrThrow(projectCustomerName);
        return projects.stream()
                .map(projectMapper::toProjectResponse)
                .toList();
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    private Project findProjectByIdOrThrow(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(ErrorMessages.RESOURCE_NOT_FOUND_BY_ID_MESSAGE, "Project", id)));
    }

    private void checkProjectExistence(String projectName) {
        if (projectRepository.existsByProjectName(projectName)) {
            throw new DuplicateResourceException(
                    String.format(ErrorMessages.DUPLICATE_RESOURCE_MESSAGE, "Project", "project name"));
        }
    }

    private List<Project> findProjectsByProjectCustomerNameOrThrow(String projectCustomerName) {
        List<Project> projects = projectRepository.findByProjectCustomerName(projectCustomerName);
        if (projects.isEmpty()) {
            throw new ResourceNotFoundException(
                    String.format(ErrorMessages.RESOURCE_NOT_FOUND_BY_CUSTOMER_NAME_MESSAGE, "Projects for Customer", projectCustomerName)
            );
        }
        return projects;
    }

}

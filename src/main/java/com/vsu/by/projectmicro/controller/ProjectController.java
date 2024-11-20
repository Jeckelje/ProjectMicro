package com.vsu.by.projectmicro.controller;

import com.vsu.by.projectmicro.dto.request.CreateProjectRequest;
import com.vsu.by.projectmicro.dto.request.UpdateProjectRequest;
import com.vsu.by.projectmicro.dto.response.ProjectResponse;
import com.vsu.by.projectmicro.service.ProjectService;
import com.vsu.by.projectmicro.swagger.ProjectApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/project")
public class ProjectController implements ProjectApi {
    private final ProjectService projectService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ProjectResponse createProject(@RequestBody @Valid CreateProjectRequest createProjectRequest) {
        return projectService.createProject(createProjectRequest);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ProjectResponse updateProject(
            @PathVariable Long id,
            @RequestBody @Valid UpdateProjectRequest updateCustomerRequest) {
        return projectService.updateProject(id, updateCustomerRequest);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ProjectResponse getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/get-by-project-customer-name/{projectCustomerName}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public List<ProjectResponse> getByProjectCustomerName(@PathVariable String projectCustomerName) {
        return projectService.getByProjectCustomerName(projectCustomerName);
    }
}

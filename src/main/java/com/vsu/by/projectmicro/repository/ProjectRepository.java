package com.vsu.by.projectmicro.repository;

import com.sun.jdi.event.StepEvent;
import com.vsu.by.projectmicro.domain.Project;
import com.vsu.by.projectmicro.dto.response.ProjectResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByProjectName(String projectName);
    List<ProjectResponse> getByProjectCustomerName(String projectCustomerName);
    List<Project> findByProjectCustomerName(String projectCustomerName);
}

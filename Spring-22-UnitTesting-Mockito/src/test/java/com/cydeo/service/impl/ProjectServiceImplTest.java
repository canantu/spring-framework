package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
    @Mock
    ProjectRepository projectRepositoryMock;
    @Mock
    ProjectMapper projectMapperMock;
    @InjectMocks
    ProjectServiceImpl projectService;
    @Test
    void getProjectCode_test(){
        // Given
        Project project = new Project();
        ProjectDTO projectDTO = new ProjectDTO();

        when(projectRepositoryMock.findByProjectCode(anyString())).thenReturn(project);
        when(projectMapperMock.convertToDto(project)).thenReturn(projectDTO);
        // when
        ProjectDTO dto = projectService.getByProjectCode(anyString());
        // then
        verify(projectRepositoryMock).findByProjectCode(anyString());
        verify(projectMapperMock).convertToDto(any(Project.class));

        assertNotNull(dto);
    }

    @Test
    void getByProjectCode_exception_test(){
        // let mock throw exception

        when(projectRepositoryMock.findByProjectCode("")).thenThrow(new RuntimeException("Project not found"));

        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode(""));
        verify(projectRepositoryMock).findByProjectCode(anyString());
        assertEquals("Project not found", exception.getMessage() );
    }

    @Test
    void save_test(){
        ProjectDTO projectDTO = new ProjectDTO();;
        Project project = new Project();

        when(projectMapperMock.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepositoryMock.save(project)).thenReturn(project);

        projectService.save(projectDTO);

        verify(projectRepositoryMock).save(project);
        verify(projectMapperMock).convertToEntity(projectDTO);
    }

}
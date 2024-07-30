package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @Mock
    TaskRepository taskRepositoryMock;
    @Mock
    TaskMapper taskMapperMock;
    @InjectMocks
    TaskServiceImpl taskService;
    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, -5L})
    void findById_test(Long id){
        Task task = new Task();

        when(taskRepositoryMock.findById(id)).thenReturn(Optional.of(task));
        when(taskMapperMock.convertToDTO(task)).thenReturn(new TaskDTO());

        taskService.findById(id);

        verify(taskRepositoryMock).findById(id);
        // verify(taskRepositoryMock).findById(anyLong());
        verify(taskMapperMock).convertToDTO(any(Task.class));
        //verify(taskMapperMock).convertToDTO(task);

        verify(taskRepositoryMock, never()).findById(-5L);
    }

    @Test
    void findById_bdd_test(){
        //given
        Task task = new Task();
        given(taskRepositoryMock.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapperMock.convertToDTO(task)).willReturn(new TaskDTO());

        // when
        taskService.findById(anyLong());

        // then
        then(taskRepositoryMock).should().findById(anyLong());
        then(taskRepositoryMock).should(never()).findById(-5L);


    }

}
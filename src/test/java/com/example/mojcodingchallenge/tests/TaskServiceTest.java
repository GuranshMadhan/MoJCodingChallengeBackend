package com.example.mojcodingchallenge.tests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.mojcodingchallenge.entities.Task;
import com.example.mojcodingchallenge.repositories.TaskRepository;
import com.example.mojcodingchallenge.services.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void whenCreateTask_shouldReturnSavedTask() {
        Task task = new Task();
        task.setTitle("Test Task");
        when(repository.save(any(Task.class))).thenReturn(task);

        Task created = service.createTask(task);

        assertNotNull(created);
        assertEquals("Test Task", created.getTitle());
        verify(repository, times(1)).save(task);
    }
}

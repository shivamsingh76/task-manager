package com.shivam.task_manager.service;

import com.shivam.task_manager.dto.TaskDTO;
import com.shivam.task_manager.model.Task;
import jakarta.validation.Valid;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks(long userId);

    Task createTask(@Valid TaskDTO taskDTO);

    Task updateTask(long taskId, @Valid TaskDTO taskDTO);

    void deleteTask(long taskId);
}

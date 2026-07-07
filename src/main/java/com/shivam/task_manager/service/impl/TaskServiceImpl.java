package com.shivam.task_manager.service.impl;

import com.shivam.task_manager.dto.TaskDTO;
import com.shivam.task_manager.model.Task;
import com.shivam.task_manager.model.Users;
import com.shivam.task_manager.repository.TaskRepository;
import com.shivam.task_manager.service.TaskService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final EntityManager entityManager; // Used to safely get user reference

    @Override
    public List<Task> getAllTasks(long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {
        // Creates a lazy proxy reference without executing a SQL SELECT query
        Users userProxy = entityManager.getReference(Users.class, taskDTO.getUserId());
        Task task = new Task();
        task.setCompleted(false);
        task.setDescription(taskDTO.getDescription());
        task.setUser(userProxy);

        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task updateTask(long taskId, TaskDTO taskDTO) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));

        if (taskDTO.getDescription() != null)
            task.setDescription(taskDTO.getDescription());
        if (taskDTO.getIsCompleted() != null)
            task.setCompleted(taskDTO.getIsCompleted());

        return task;
    }

    @Override
    public void deleteTask(long taskId) {
        taskRepository.deleteById(taskId);
    }
}

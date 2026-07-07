package com.shivam.task_manager.controller;

import com.shivam.task_manager.dto.TaskDTO;
import com.shivam.task_manager.model.Task;
import com.shivam.task_manager.response.ResponseHandler;
import com.shivam.task_manager.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{userId}")
    ResponseEntity<Object> getAllTasks(@PathVariable("userId") long userId) {
        return ResponseHandler.handleResponse(HttpStatus.OK, "Fetched all tasks.", taskService.getAllTasks(userId));
    }

    @PostMapping
    ResponseEntity<Object> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        Task createdTask = taskService.createTask(taskDTO);
        return ResponseHandler.handleResponse(HttpStatus.CREATED, "Task added successfully.", createdTask);
    }

    @PatchMapping("/{taskId}")
    ResponseEntity<Object> updateTask(@PathVariable("taskId") long taskId ,@Valid @RequestBody TaskDTO taskDTO) {
        Task updatedTask = taskService.updateTask(taskId, taskDTO);
        return ResponseHandler.handleResponse(HttpStatus.OK, "Task updated successfully.", updatedTask);
    }

    @DeleteMapping("/{taskId}")
    ResponseEntity<Object> deleteTask(@PathVariable("taskId") long taskId) {
        taskService.deleteTask(taskId);
        return ResponseHandler.handleResponse(HttpStatus.OK, "Task deleted successfully.", null);
    }
}

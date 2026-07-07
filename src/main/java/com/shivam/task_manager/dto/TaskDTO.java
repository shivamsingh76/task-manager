package com.shivam.task_manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO {
//    @NotBlank(message = "Task description cannot be empty.")
    private String description;

    @JsonProperty("isCompleted")
    private Boolean isCompleted;

//    @NotNull(message = "User not found.")
    private Long userId;
}

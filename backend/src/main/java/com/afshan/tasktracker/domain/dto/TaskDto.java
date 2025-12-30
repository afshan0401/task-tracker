package com.afshan.tasktracker.domain.dto;

import com.afshan.tasktracker.domain.entity.TaskPriority;
import com.afshan.tasktracker.domain.entity.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;


//JAVA automatically provides with constructor, getters(no setters coz records are immutable), hashCode, equals, toString and immutability.
public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {


}

package com.afshan.tasktracker.domain.dto;

import java.util.List;
import java.util.UUID;

public record TaskListDto(
        UUID id,
        String title,
        String description,
        //no of tasks in a tasklist
        Integer count,
        Double progress,
        List<TaskDto> tasks

) {
}

package com.afshan.tasktracker.mappers;

import com.afshan.tasktracker.domain.dto.TaskDto;
import com.afshan.tasktracker.domain.entity.Task;

//A mapper converts one object type into another.
//DB ←→ Entity ←→ Mapper ←→ DTO ←→ Controller ←→ Client
public interface TaskMapper{



//“Take a TaskDto and convert it into a Task entity”
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}

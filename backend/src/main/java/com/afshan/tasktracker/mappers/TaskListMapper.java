package com.afshan.tasktracker.mappers;

import com.afshan.tasktracker.domain.dto.TaskListDto;
import com.afshan.tasktracker.domain.entity.TaskList;
//A mapper converts one object type into another.
public interface TaskListMapper {


    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}

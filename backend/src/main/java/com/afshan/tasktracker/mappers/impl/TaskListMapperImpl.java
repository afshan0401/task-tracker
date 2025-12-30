package com.afshan.tasktracker.mappers.impl;

import com.afshan.tasktracker.domain.dto.TaskListDto;
import com.afshan.tasktracker.domain.entity.Task;
import com.afshan.tasktracker.domain.entity.TaskList;
import com.afshan.tasktracker.domain.entity.TaskStatus;
import com.afshan.tasktracker.mappers.TaskListMapper;
import com.afshan.tasktracker.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    //  this holds TaskMapperImpl object
    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
        //spring does -> this.taskMapper = new TaskMapperImpl();
    }

    /*
    When this line runs:
    taskMapper.fromDto(...)
    Java executes:
        TaskMapperImpl.fromDto(...)
        (Dynamic dispatch.)
    */



    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        /*
        Optional → container that may or may not hold value
        ofNullable(...) →
            if tasks is null → Optional.empty
            if not null → Optional(value)
        This prevents NullPointerException.
        */
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream().map(taskMapper::fromDto)
                                .toList()
                        ).orElse(null),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                //gets count
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream().map(taskMapper::toDto).toList())
                        .orElse(null)
        );
    }


    private Double calculateTaskListProgress(List<Task> tasks) {
        if (null == tasks) {
            return null;
        }

        long closedTaskCount = tasks.stream().filter(task -> TaskStatus.CLOSED == task.getStatus())
                .count();
        //calculate -  completed / total
        return (double) closedTaskCount / tasks.size();
    }
}

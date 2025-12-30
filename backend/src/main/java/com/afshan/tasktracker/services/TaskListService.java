package com.afshan.tasktracker.services;

import com.afshan.tasktracker.domain.entity.Task;
import com.afshan.tasktracker.domain.entity.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {

    //Get all task lists
    List<TaskList> listTaskLists();

    //Create a new task list and return it
    TaskList createTaskList(TaskList taskList);

    //Find a specific task list by ID or return null
    Optional<TaskList> getTaskList(UUID id);


    TaskList updateTaskList(UUID taskListId, TaskList taskList);


    void deleteTaskList(UUID taskListId);
}

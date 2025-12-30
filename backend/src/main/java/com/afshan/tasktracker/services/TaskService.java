package com.afshan.tasktracker.services;

import com.afshan.tasktracker.domain.entity.Task;
import com.afshan.tasktracker.domain.entity.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    // Get all tasks belonging to a specific task list
    List<Task> listTasks(UUID taskListId);

    //Add a new task to a specific task list using the taskListID and also return it
    Task createTask(UUID taskListId, Task task);

    //Find one specific task within a specific list may or may not find so used Optional
    Optional<Task> getTask(UUID taskListId, UUID taskId);


    Task updateTask(UUID taskListId, UUID taskId, Task task);


    void deleteTask(UUID taskListId, UUID taskId);

}

/*

getTask(UUID taskListId, UUID taskId)
        ↑                  ↑
       Parent ID         Child ID
```

This represents the relationship:

TaskList (Parent)
  └─ Task (Child)


**REST API would look like:**
GET /tasklists/{taskListId}/tasks/{taskId}

 */
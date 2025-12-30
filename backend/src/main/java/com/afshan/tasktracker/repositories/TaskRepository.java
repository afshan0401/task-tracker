package com.afshan.tasktracker.repositories;

import com.afshan.tasktracker.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    //Get all tasks belonging to a specific task list
    //spring auto generates sql : SELECT * FROM task WHERE task_list_id = ?
    List<Task> findByTaskListId(UUID taskListId);


    //Optional<Task>: May return a Task or empty (null-safe)
    //SELECT * FROM task WHERE task_list_id = ? AND id = ?
    Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID id);


    //DELETE FROM task WHERE task_list_id = ? AND id = ?
    void deleteByTaskListIdAndId(UUID taskListId, UUID id);
}

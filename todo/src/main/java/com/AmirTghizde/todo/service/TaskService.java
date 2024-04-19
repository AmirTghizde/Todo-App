package com.AmirTghizde.todo.service;

import com.AmirTghizde.todo.entity.Task;

import java.util.List;

public interface TaskService {
    Task viewTask(Long id);

    void addTask(String taskName);

    void addTask(String taskName, String description);

    void deleteTask(Long id);

    void editTask(Long id,String name);
    void editTask(Long id,String name,String description);

    void CompleteTask(Long id);

    void incompleteTask(Long id);

    List<Task> viewAll();
}

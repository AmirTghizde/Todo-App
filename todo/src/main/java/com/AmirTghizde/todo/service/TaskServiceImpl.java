package com.AmirTghizde.todo.service;

import com.AmirTghizde.todo.entity.Status;
import com.AmirTghizde.todo.entity.Task;
import com.AmirTghizde.todo.exceptions.TaskException;
import com.AmirTghizde.todo.repository.TaskRepository;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task viewTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskException("We are unable to find that task"));
    }

    @Override
    public void addTask(String taskName) {
        Task task = Task.builder()
                .name(taskName)
                .status(Status.UNFINISHED).build();

        try {
            taskRepository.save(task);
        } catch (PersistenceException e) {
            log.error("Task saving went wrong");
        }
    }

    @Override
    public void addTask(String taskName, String description) {
        Task task = Task.builder()
                .name(taskName)
                .description(description)
                .status(Status.UNFINISHED).build();

        try {
            taskRepository.save(task);
        } catch (PersistenceException e) {
            log.error("Task saving went wrong");
        }
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void editTask(Long id, String name) {
        Task task = viewTask(id);
        task.setName(name);

        try {
            taskRepository.save(task);
        } catch (PersistenceException e) {
            log.error("Task saving went wrong");
        }
    }

    @Override
    public void editTask(Long id, String name, String description) {
        Task task = viewTask(id);
        task.setName(name);
        task.setDescription(description);

        try {
            taskRepository.save(task);
        } catch (PersistenceException e) {
            log.error("Task saving went wrong");
        }
    }


    @Override
    public void CompleteTask(Long id) {
        Task task = viewTask(id);
        task.setStatus(Status.FINISHED);

        try {
            taskRepository.save(task);
        } catch (PersistenceException e) {
            log.error("Task saving went wrong");
        }
    }

    @Override
    public void incompleteTask(Long id) {
        Task task = viewTask(id);
        task.setStatus(Status.UNFINISHED);

        try {
            taskRepository.save(task);
        } catch (PersistenceException e) {
            log.error("Task saving went wrong");
        }
    }

    @Override
    public List<Task> viewAll() {
        return taskRepository.findAll();
    }
}

package com.AmirTghizde.todo.repository;

import com.AmirTghizde.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

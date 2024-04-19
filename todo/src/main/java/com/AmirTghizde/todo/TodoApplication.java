package com.AmirTghizde.todo;

import com.AmirTghizde.todo.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(TodoApplication.class, args);
		TaskService taskService = context.getBean(TaskService.class);

		taskService.CompleteTask(1L);


	}

}

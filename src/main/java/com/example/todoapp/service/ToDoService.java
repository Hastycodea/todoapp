package com.example.todoapp.service;

import com.example.todoapp.model.ToDo;
import com.example.todoapp.repo.ToDoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepo repo;

    public ToDoService(ToDoRepo repo) {
        this.repo = repo;
    }

    public List<ToDo> getAllTasks() {
        return repo.findAll();
    }

    public ToDo getTaskById(long id) {
        return repo.findById(id).orElse(null);
    }

    public ToDo addTask(ToDo toDo) {
        return repo.save(toDo);
    }

    public ToDo updateTask(ToDo toDo, long id) {
        ToDo updatedTask = repo.findById(id).orElse(null);

        if(updatedTask != null) {
            return repo.save(toDo);
        } else {
            return  null;
        }
    }

    public void deleteTask(long id) {
        repo.deleteById(id);
    }
}


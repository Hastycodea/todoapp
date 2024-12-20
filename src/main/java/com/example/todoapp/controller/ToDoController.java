package com.example.todoapp.controller;

import com.example.todoapp.model.ToDo;
import com.example.todoapp.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    private final ToDoService service;

    public ToDoController(ToDoService service) {
        this.service = service;
    }

    //CRUD
//    create => post
//    read => get
//    update => put
//    delete => delete


    @GetMapping("/home")
    public String test() {
        return "Welcome Home";
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<ToDo>> getAllTasks() {
        return new ResponseEntity(service.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<ToDo> getTaskById(@PathVariable int id) {
        ToDo task = service.getTaskById(id);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/tasks")
    public ResponseEntity<ToDo> addTask(@RequestBody ToDo toDo) {
        if (toDo != null) {
            return new ResponseEntity<>(service.addTask(toDo), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<ToDo> updateTask(@PathVariable long id, @RequestBody ToDo toDo) {
        ToDo newTask = null;
        newTask = service.updateTask(toDo, id);

        if (newTask != null) {
            return new ResponseEntity<>(toDo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        ToDo task =  getTaskById(id).getBody();

        if(task != null) {
            service.deleteTask(id);
            return  new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } else {
            return  new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
        }
    }
}

package com.example.todoapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "todos")
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long taskId;
    public String title;
    public String description;
    public Date dueDate;
    public String status;

}

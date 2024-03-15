package com.Bhuvaneswar.TaskManager_Spring_Java.Controllers;

import com.Bhuvaneswar.TaskManager_Spring_Java.Services.TaskServices;
import com.Bhuvaneswar.TaskManager_Spring_Java.dtos.TaskDTO;
import com.Bhuvaneswar.TaskManager_Spring_Java.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController
{
    private TaskServices taskServices;
    public TaskController(TaskServices taskServices)
    {
        this.taskServices=taskServices;
    }

    @GetMapping("/allTasks")
    public ResponseEntity<List<Task>> getAllTasks()
    {
        ResponseEntity<List<Task>> response=new ResponseEntity<>(
                taskServices.getAllTasks(), HttpStatus.OK
        );
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") int id)
    {
        ResponseEntity<Task> response=new ResponseEntity<>(
                taskServices.getTaskById(id), HttpStatus.OK
        );
        if(taskServices.getTaskById(id).equals(null))
        {
            return ResponseEntity.notFound().build();
        }
        return response;
    }

    @PostMapping("/addTask")
    public ResponseEntity<Task> addTask(@RequestBody TaskDTO taskDTO)
    {
        ResponseEntity<Task> response=new ResponseEntity<>(
                taskServices.addTask(taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getDeadline()), HttpStatus.OK
        );
        return response;
    }

}

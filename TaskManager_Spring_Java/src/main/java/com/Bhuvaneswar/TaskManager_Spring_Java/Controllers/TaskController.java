package com.Bhuvaneswar.TaskManager_Spring_Java.Controllers;

import com.Bhuvaneswar.TaskManager_Spring_Java.Services.TaskServices;
import com.Bhuvaneswar.TaskManager_Spring_Java.dtos.ErrorResponseDTO;
import com.Bhuvaneswar.TaskManager_Spring_Java.dtos.TaskDTO;
import com.Bhuvaneswar.TaskManager_Spring_Java.dtos.UpdateTaskDto;
import com.Bhuvaneswar.TaskManager_Spring_Java.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public ResponseEntity<Task> addTask(@RequestBody TaskDTO taskDTO) throws ParseException {
        ResponseEntity<Task> response=new ResponseEntity<>(
                taskServices.addTask(taskDTO.getTitle(), taskDTO.getDescription(), taskDTO.getDeadline()), HttpStatus.OK
        );
        return response;
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDto updateTaskDto) throws ParseException {
        ResponseEntity<Task> response=new ResponseEntity<>(
                taskServices.UpdateTask(id, updateTaskDto.getDescription(), updateTaskDto.getDeadline(), updateTaskDto.getStatusOfTask()),HttpStatus.OK
        );
        if(taskServices.getTaskById(id).equals(null))
        {
            return ResponseEntity.notFound().build();
        }
        return response;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e)
    {
        if(e instanceof ParseException)
        {
            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal server error"));
    }


}

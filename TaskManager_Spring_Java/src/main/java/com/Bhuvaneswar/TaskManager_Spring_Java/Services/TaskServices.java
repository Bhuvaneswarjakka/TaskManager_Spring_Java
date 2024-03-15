package com.Bhuvaneswar.TaskManager_Spring_Java.Services;

import com.Bhuvaneswar.TaskManager_Spring_Java.dtos.UpdateTaskDto;
import com.Bhuvaneswar.TaskManager_Spring_Java.models.Task;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServices
{
    private List<Task> tasks=new ArrayList<>();
    private int id=1;

    private SimpleDateFormat deadlineFormatter=new SimpleDateFormat("yyyy-MM-dd");

    public List<Task> getAllTasks()
    {
        return tasks;
    }

    public Task getTaskById(int id)
    {
        for(Task task:tasks)
        {
            if(task.getId()==id)
            {
                return task;
            }
        }
        return null;
    }

    public Task addTask(String title, String description, String deadline) throws ParseException {
        Task task=new Task();
        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatusOfTask(false);
        task.setDeadline(deadlineFormatter.parse(deadline));
        tasks.add(task);
        id++;
        return task;
    }

    public Task UpdateTask(int id, String description, String deadline, Boolean StatusOfWork) throws ParseException {
        Task task=getTaskById(id);
        if(task==null)
        {
            return null;
        }
        if(description!=null)
        {
            task.setDescription(description);
        }
        if(deadline!=null)
        {
            task.setDeadline(deadlineFormatter.parse(deadline));
        }
        if(StatusOfWork!=null)
        {
            task.setStatusOfTask(StatusOfWork);
        }
        return task;
    }
}

package com.Bhuvaneswar.TaskManager_Spring_Java.Services;

import com.Bhuvaneswar.TaskManager_Spring_Java.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskServices
{
    private List<Task> tasks=new ArrayList<>();
    private int id=1;

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

    public Task addTask(String title, String description, Date deadline)
    {
        Task task=new Task();
        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatusOfTask(false);
        task.setDeadline(deadline);
        tasks.add(task);
        id++;
        return task;
    }
}

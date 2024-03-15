package com.Bhuvaneswar.TaskManager_Spring_Java.Services;

import com.Bhuvaneswar.TaskManager_Spring_Java.models.Notes;
import com.Bhuvaneswar.TaskManager_Spring_Java.models.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService
{
    private TaskServices taskServices;
    HashMap<Integer, TaskNotesHolder> taskNotesHolder=new HashMap<>();
    public NotesService(TaskServices taskServices)
    {
        this.taskServices=taskServices;
    }
    class TaskNotesHolder
    {
        protected int noteId=1;
        protected ArrayList<Notes> notes=new ArrayList<>();
    }

    public List<Notes> getNotesForTask(int taskId)
    {
        Task task=taskServices.getTaskById(taskId);
        if(task==null)
        {
            return null;
        }
        if(taskNotesHolder.get(taskId)==null)
        {
            taskNotesHolder.put(taskId, new TaskNotesHolder());
        }
        return taskNotesHolder.get(taskId).notes;
    }
    public Notes addNoteForTask(int taskId, String title, String body)
    {
        Task task=taskServices.getTaskById(taskId);
        if(task==null)
        {
            return null;
        }
        if(taskNotesHolder.get(taskId)==null)
        {
            taskNotesHolder.put(taskId, new TaskNotesHolder());
        }
        TaskNotesHolder taskNotesHolder1=taskNotesHolder.get(taskId);
        Notes notes=new Notes();
        notes.setId(taskNotesHolder1.noteId);
        notes.setTitle(title);
        notes.setBody(body);
        taskNotesHolder1.notes.add(notes);
        taskNotesHolder1.noteId++;
        return notes;
    }

}

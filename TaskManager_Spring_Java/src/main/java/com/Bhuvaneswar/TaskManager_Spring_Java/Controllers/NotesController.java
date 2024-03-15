package com.Bhuvaneswar.TaskManager_Spring_Java.Controllers;

import com.Bhuvaneswar.TaskManager_Spring_Java.Services.NotesService;
import com.Bhuvaneswar.TaskManager_Spring_Java.dtos.AddNotesForTaskDTO;
import com.Bhuvaneswar.TaskManager_Spring_Java.dtos.CreateNoteResponseDTO;
import com.Bhuvaneswar.TaskManager_Spring_Java.models.Notes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController
{
    private NotesService notesService;
    public NotesController(NotesService notesService)
    {
        this.notesService=notesService;
    }
    @GetMapping("")
    public ResponseEntity<List<Notes>> getNotes(@PathVariable("taskId") Integer taskId)
    {
        var notes=notesService.getNotesForTask(taskId);

        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNotes(@PathVariable("taskId") Integer taskId,
                                                          @RequestBody AddNotesForTaskDTO body)
    {
        var note=notesService.addNoteForTask(taskId, body.getTitle(), body.getBody());
        return ResponseEntity.ok(new CreateNoteResponseDTO(note, taskId));
    }
}

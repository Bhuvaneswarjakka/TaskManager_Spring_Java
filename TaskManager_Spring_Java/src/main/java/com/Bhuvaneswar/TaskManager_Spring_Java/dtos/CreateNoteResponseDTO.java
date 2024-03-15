package com.Bhuvaneswar.TaskManager_Spring_Java.dtos;

import com.Bhuvaneswar.TaskManager_Spring_Java.models.Notes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteResponseDTO
{
    private Notes notes;
    private Integer taskId;
}

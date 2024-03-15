package com.Bhuvaneswar.TaskManager_Spring_Java.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddNotesForTaskDTO
{
    private String title;
    private String body;

}

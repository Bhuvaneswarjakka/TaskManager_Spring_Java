package com.Bhuvaneswar.TaskManager_Spring_Java.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateTaskDto
{
    private String description;
    private String deadline;
    private Boolean statusOfTask;
}

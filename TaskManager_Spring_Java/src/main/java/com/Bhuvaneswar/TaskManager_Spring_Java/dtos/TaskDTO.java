package com.Bhuvaneswar.TaskManager_Spring_Java.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDTO
{
    private String title;
    private String description;
    private Date deadline;
}

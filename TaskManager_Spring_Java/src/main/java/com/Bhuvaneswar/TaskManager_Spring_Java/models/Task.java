package com.Bhuvaneswar.TaskManager_Spring_Java.models;

import lombok.Data;

import java.util.Date;

@Data
public class Task
{
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean statusOfTask;
}

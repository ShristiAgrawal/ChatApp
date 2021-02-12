package com.shristi.myapplication.todo;

public class todomodel {
    private String creator,task,deadline;
    public todomodel(String creator, String task,String deadline) {
        this.creator = creator;
        this.task = task;
        this.deadline=deadline;
    }
    public todomodel() {
    }



    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}

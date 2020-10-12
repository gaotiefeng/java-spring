package com.example.model;

public class ArticleClassModel {

    private int id;
    private String class_name;
    private int pid;
    private int sort;

    public int getId()
    {
        return id;
    }

    public String getClassName()
    {
        return class_name;
    }

    public int getSort()
    {
        return this.sort;
    }

    public int getPid()
    {
        return this.pid;
    }

    public void setPid(int pid)
    {
        this.pid = pid;
    }


    public void setId(int id)
    {
        this.id = id;
    }

    public void setClassName(String class_name)
    {
        this.class_name = class_name;
    }

    public void setSort(int sort)
    {
        this.sort = sort;
    }
}

package com.felight.javengers;

public class Comment {
    private long _id;
    private String name;
    private String email;

    public Comment(){}

    public  Comment(String name, String email)
    {
        this.name= name;
        this.email= email;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String comment) {
        this.name = comment;
    }

    public void setEmail(String email)
    {
        this.email= email;
    }
    public String getEmail()
    {
        return email;
    }

    @Override
    public String toString() {
        return name +" "+  email ;
    }
}
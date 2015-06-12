package com.github.yingzhuo.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String id;
    private String name;
    private Date dob;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}

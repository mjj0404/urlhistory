package com.example.urlhistory.model.wrapper;


import java.io.Serializable;
import java.util.List;

public class UserSetWrapper implements Serializable {
    private List<String> users = null;
    private final static long serialVersionUID = -4706223670114309226L;

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}

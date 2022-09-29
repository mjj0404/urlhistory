package com.example.urlhistory.model.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWrapper implements Serializable {

    private String user;
    private final static long serialVersionUID = -470622367011430922L;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

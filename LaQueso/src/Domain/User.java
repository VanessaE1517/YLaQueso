/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import Logic.LinkedStack;
import Logic.Stack;
import java.util.ArrayList;

/**
 *
 * @author vanes
 */
public class User {
    private String usserName;
    private String password;
    private String friends;
    private String request;
    private LinkedStack post;

    public User() {
    }

    public User(String usserName, String password, String friends, String request, LinkedStack post) {
        this.usserName = usserName;
        this.password = password;
        this.friends = friends;
        this.request = request;
        this.post = post;
    }

    
    public String getUsserName() {
        return usserName;
    }

    public void setUsserName(String usserName) {
        this.usserName = usserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public LinkedStack getPost() {
        return post;
    }

    public void setPost(LinkedStack post) {
        this.post = post;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "Usser{" + "usserName=" + usserName + ", password=" + password + ", friends=" + friends + ", request=" + request + ", post=" + post + '}';
    }

    
}
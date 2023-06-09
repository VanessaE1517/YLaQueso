/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import Logic.Stack;
import java.util.ArrayList;

/**
 *
 * @author vanes
 */
public class Usser {
    private String usserName;
    private String password;
    private ArrayList<String> friends;
    private ArrayList<String> request;
    private Stack post;

    public Usser() {
    }

    public Usser(String usserName, String password, ArrayList<String> friends, ArrayList<String> request, Stack post) {
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

    public ArrayList<String> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<String> friends) {
        this.friends = friends;
    }

    public Stack getPost() {
        return post;
    }

    public void setPost(Stack post) {
        this.post = post;
    }

    public ArrayList<String> getRequest() {
        return request;
    }

    public void setRequest(ArrayList<String> request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "Usser{" + "usserName=" + usserName + ", password=" + password + ", friends=" + friends + ", request=" + request + ", post=" + post + '}';
    }

    
}

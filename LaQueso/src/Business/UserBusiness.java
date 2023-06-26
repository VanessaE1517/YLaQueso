/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.UserData;
import Domain.User;
import Logic.CircularDoubleLinkedList;
import Logic.LinkedStack;
import java.io.IOException;
import org.jdom.JDOMException;

/**
 *
 * @author vanes
 */
public class UserBusiness {
    UserData userData;

    public UserBusiness(String routh) throws JDOMException, IOException {
        userData = new UserData(routh);
    }
    
    public void logUsser(User usser) throws IOException{
        this.userData.LogUsser(usser);
    }
    
    public boolean verifyUsser(String usser, String password) {
        return this.userData.verifyUsser(usser, password);
    }
     
    public void addThoughts(CircularDoubleLinkedList list, String us) throws IOException{
        this.userData.addThoughts(list, us);
    }
    
    public CircularDoubleLinkedList getThoughts(String us){
        return this.userData.getThoughts(us);
    }
    
    public boolean searchUser(String us){
        return this.userData.searchUser(us);
    }
    
    public void addFriends(String us, String friend) throws IOException{
         this.userData.addFriends(us, friend);
    }
            
            
}

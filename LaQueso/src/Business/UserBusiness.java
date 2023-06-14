/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.UserData;
import Domain.User;
import java.io.IOException;
import org.jdom.JDOMException;

/**
 *
 * @author vanes
 */
public class UserBusiness {
    UserData usserData;

    public UserBusiness(String routh) throws JDOMException, IOException {
        usserData = new UserData(routh);
    }
    
    public void logUsser(User usser) throws IOException{
        this.usserData.LogUsser(usser);
    }
    
    public boolean verifyUsser(String usser, String password) {
        return this.usserData.verifyUsser(usser, password);
    }
     
    
            
            
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Data.UsserData;
import Domain.Usser;
import java.io.IOException;
import org.jdom.JDOMException;

/**
 *
 * @author vanes
 */
public class UsserBusiness {
    UsserData usserData;

    public UsserBusiness(String routh) throws JDOMException, IOException {
        usserData = new UsserData(routh);
    }
    
    public void logUsser(Usser usser) throws IOException{
        this.usserData.LogUsser(usser);
    }
    
    public boolean verifyUsser(String usser, String password) {
        return this.usserData.verifyUsser(usser, password);
    }
     
    
            
            
}

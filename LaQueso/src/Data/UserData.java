/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Domain.User;
import Logic.CircularDoubleLinkedList;
import Logic.LinkedStack;
import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
/**
 *
 * @author vanes
 */
public class UserData {
    private Document document;
    private Element element;
    private String routh;

    public UserData(String routh) throws JDOMException, IOException {
        this.routh=routh; 
        
        File file=new File(this.routh);
        if(file.exists()){
            SAXBuilder saxBuilder=new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            
            this.document=saxBuilder.build(this.routh);
            this.element=this.document.getRootElement();
        }else{
            this.element=new Element("Users");
            this.document=new Document(this.element);
            saveXML();
        }
    }

    private void saveXML() throws FileNotFoundException, IOException {
        XMLOutputter xmlOutputter =new XMLOutputter();
        xmlOutputter.output(this.document, new PrintWriter(this.routh));
    }
    
    public void LogUsser(User user) throws IOException{
        Element eUser=new Element("User");
        eUser.setAttribute("Usser", user.getUsserName());
        eUser.setAttribute("Password", user.getPassword());

        Element eFriend=new Element("Friends");
        eFriend.addContent(user.getFriends());

        Element ePosts=new Element("Posts");
        LinkedStack linkedStack=user.getPost();
        for (int i = 0; i < linkedStack.getsize(); i++) {
            CircularDoubleLinkedList circularDoubleLinkedList=(CircularDoubleLinkedList)linkedStack.pop();
            Element ePost = new Element("Post");
           // ePost.setAttribute("Title", circularDoubleLinkedList.getTitle());
        }
        
        Element eRequest=new Element("Requests");
        eRequest.addContent(user.getRequest());
        
        eUser.addContent(eFriend);
        eUser.addContent(ePosts);
        eUser.addContent(eRequest);
        
        this.element.addContent(eUser);
        this.saveXML();
    }
    
    public boolean verifyUsser(String us, String password) {
        User user=new User();
        List elementList = this.element.getChildren();
        for (Object object : elementList) {
            Element eUsser=(Element)object;
            if(eUsser.getAttributeValue("Usser").equals(us)&& 
                   eUsser.getAttributeValue("Password").equals(password)){
                
                return true;
            } 
        }
        return false;
    }
}
    
//    public boolean searchUser(String carnet) {
//        Estudiante estudiante=new Estudiante();
//        List elementList = this.raiz.getChildren();
//        for (Object object : elementList) {
//            Element eEstudianteActual=(Element)object;
//            if(String.valueOf(eEstudianteActual.getAttributeValue("Carnet")).equalsIgnoreCase(carnet)){
//                estudiante=new Estudiante(eEstudianteActual.getAttributeValue("Carnet"),//el nombre tiene que ser igual porque sino tira que esta vacio
//                           eEstudianteActual.getChild("Nombre").getValue(),//el nombre tiene que ser igual porque sino da error
//                           eEstudianteActual.getChild("Apellido").getValue(),
//                           Integer.parseInt(eEstudianteActual.getChild("NotaAdmision").getValue()));   
//            } 
//        }
//        return estudiante;
//    }
//    
// }

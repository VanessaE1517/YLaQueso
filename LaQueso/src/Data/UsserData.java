/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Domain.Usser;
import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class UsserData {
    private Document document;
    private Element element;
    private String routh;

    public UsserData(String routh) throws JDOMException, IOException {
        this.routh=routh; 
        
        File file=new File(this.routh);
        if(file.exists()){
            SAXBuilder saxBuilder=new SAXBuilder();
            saxBuilder.setIgnoringElementContentWhitespace(true);
            
            this.document=saxBuilder.build(this.routh);
            this.element=this.document.getRootElement();
        }else{
            this.element=new Element("Ussers");
            this.document=new Document(this.element);
            saveXML();
        }
    }

    private void saveXML() throws FileNotFoundException, IOException {
        XMLOutputter xmlOutputter =new XMLOutputter();
        xmlOutputter.output(this.document, new PrintWriter(this.routh));
    }
    
    public void LogUsser(Usser usser) throws IOException{
        Element eUsser=new Element("Ussers");
        eUsser.setAttribute("Usser", usser.getUsserName());
        
        Element ePassword=new Element("Password");
        ePassword.addContent(usser.getPassword());
        
        Element eFriend=new Element("Friends");
        eFriend.addContent(usser.getFriends());
        
        Element ePosts=new Element("Posts");
        ePosts.addContent((Content) usser.getPost());
        
        Element eRequest=new Element("Requests");
        eRequest.addContent(usser.getRequest());
        
        eUsser.addContent(eFriend);
        eUsser.addContent(ePosts);
        eUsser.addContent(eRequest);
        
        this.element.addContent(eUsser);
        this.saveXML();
    }
    
    public boolean verifyUsser(String uss, String password) {
        Usser usser=new Usser();
        List elementList = this.element.getChildren();
        for (Object object : elementList) {
            Element eUsser=(Element)object;
            if(eUsser.getAttributeValue("Usser").equals(uss)&& 
                    String.valueOf(eUsser.getChild("Password").getValue()).equals(password)){
                
                return true;
            } 
        }
        return false;
    }
    
 }

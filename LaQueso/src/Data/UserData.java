/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Domain.User;
import Logic.AdjacenceList;
import Logic.CircularDoubleLinkedList;
import Logic.LinkedQueue;
import Logic.LinkedStack;
import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jdom.Attribute;
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
        

        Element ePost = new Element("Post");

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
            if(eUsser.getAttributeValue("Usser").equals(us)||(eUsser.getAttributeValue("Usser").equals(us)&& 
                   eUsser.getAttributeValue("Password").equals(password))){
                
                return true;
            } 
        }
        return false;
    }
    
    public void addThoughts(CircularDoubleLinkedList list, String us) throws IOException{
        User user=new User();
        List elementList = this.element.getChildren();
        for (Object object : elementList) {
            Element eUsser=(Element)object;
            if (eUsser.getAttributeValue("Usser").equals(us)) {
                CircularDoubleLinkedList circularDoubleLinkedList = list;
                Element ePost = new Element("Post");
                for (int j = 1; j < circularDoubleLinkedList.getSize()+1; j++) {
                    ePost.addContent((String) circularDoubleLinkedList.getByPosition(j));
                }
                eUsser.getChild("Posts").addContent(ePost);
                this.saveXML();
                
            }
        }    
    }
    
    public void addRequest(String us, String friend, String date) throws IOException{
        User user=new User();
        List elementList = this.element.getChildren();
        for (Object object : elementList) {
            Element eUser=(Element)object;
            if(eUser.getAttributeValue("Usser").equals(friend)){
                eUser.getChild("Requests").addContent(date+""+us+".");
            }
        }
        this.saveXML();
    }
    
    public void acceptRequest(String us, String request) throws IOException{
        User user=new User();
        List elementList = this.element.getChildren();
        for (Object object : elementList) {
            Element eUser=(Element)object;
            if(eUser.getAttributeValue("Usser").equals(us)){
                eUser.getChild("Friends").addContent(request+" ");
            }
            if(eUser.getAttributeValue("Usser").equals(request)){
                eUser.getChild("Friends").addContent(us+" ");
            }
        }
        this.saveXML();   
    }
    
    public LinkedQueue getRequest(String us){
        User user=new User();
        List elementList = this.element.getChildren();
        LinkedQueue  queue = new LinkedQueue();
        for (Object object : elementList) {
            Element eUser=(Element)object;
            if(eUser.getAttributeValue("Usser").equals(us)){    
                String[] request = eUser.getChild("Requests").getValue().split("\\.");
                for (int i = 0; i < request.length; i++) {
                    queue.insert(request[i]);
                }
                return queue;
            }
        }
        return queue;  
    }
    
    public CircularDoubleLinkedList getThoughts(String us){
        User user=new User();
        List elementList = this.element.getChildren();
        CircularDoubleLinkedList circularDoubleLinkedList = new CircularDoubleLinkedList();
        for (Object object : elementList) {
            Element eUsser=(Element)object;
            if(eUsser.getAttributeValue("Usser").equals(us)){
                    circularDoubleLinkedList.addEnd(eUsser.getChild("Posts").getChild("Post").getValue()+".");
                    System.out.println(eUsser.getChild("Posts").getChild("Post").getValue());
                    return circularDoubleLinkedList;
                
            }    
        }
        return circularDoubleLinkedList;
    }
    
    public ArrayList getFriends(String us){
        User user=new User();
        List elementList = this.element.getChildren();
        ArrayList<String> friend = new ArrayList<>();
        for (Object object : elementList) {
            Element eUser=(Element)object;       
            if(eUser.getAttributeValue("Usser").equals(us)){
                String[] friends = eUser.getChild("Friends").getValue().split(" ");
                for (int i = 0; i < friends.length; i++) {
                    friend.add(friends[i]);
                }
                return friend;
            }
        }
        return friend;
    }
    
    public boolean searchUser(String us){
        User user=new User();
        List elementList = this.element.getChildren();
        for (Object object : elementList) {
            Element eUser=(Element)object;
            if(eUser.getAttributeValue("Usser").equals(us)){
                return true;
            }
        }
        return false;
    }
    
//    public int friendsCommon(){
//        
//    }
    
    private AdjacenceList graph(){ 
        AdjacenceList graph;
        int count =0;
        User user=new User();
        List elementList = this.element.getChildren();
        for (Object object : elementList) {
            Element eUser=(Element)object;
            count++;
        }
        graph = new AdjacenceList(count);
        for (Object object : elementList) {
            Element eUser=(Element)object;
            graph.addVertex(eUser.getAttributeValue("Usser"));
        }
        return graph;
    }
    
    public AdjacenceList fillGraph(){
        AdjacenceList graph = graph();
        User user=new User();
        List elementList = this.element.getChildren();
        for (Object object : elementList) {
            Element eUser=(Element)object;
            if(graph.showVertex(eUser.getAttributeValue("Usser"))){
                String[] friends = eUser.getChild("Friends").getValue().split(" ");
                for (int i = 0; i < friends.length; i++) {
                    if(!graph.existEdge(eUser.getAttributeValue("Usser"),friends[i])){
                        graph.addEdge(eUser.getAttributeValue("Usser"),friends[i] );
                    }
                }
            }
        }
        return graph;
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

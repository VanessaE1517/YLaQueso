/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Logic.CircularDoubleLinkedList;
import Logic.CircularDoubleLinkedList;

/**
 *
 * @author Yoselin Porras Reyes
 */
public class Vertex {
    
     Object element;
     CircularDoubleLinkedList listEdge;
     CircularDoubleLinkedList listWeight;
     boolean visited;

    public Vertex(Object element) {
        this.element = element;
        this.visited=false;
        this.listEdge=new CircularDoubleLinkedList();
        this.listWeight=new CircularDoubleLinkedList();
    }
    
    
    
}

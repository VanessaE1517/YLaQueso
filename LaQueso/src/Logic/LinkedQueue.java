/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Logic.Node;
import Logic.Queue;

/**
 *
 * @author Yoselin Porras Reyes
 */
public class LinkedQueue implements Queue{
    
    private Node start;
    private Node end;

    public LinkedQueue() {
        this.start=this.end=null;
    }
    
    @Override
    public int getSize() {
        if(isEmpty()){
          return 0;
        }
        int counter=0;
        Node aux=this.start;
        while(aux!=this.end){
            counter++; 
            aux=aux.next;        
        }
        
        return counter+1;
    }

    @Override
    public boolean isEmpty() {
        return this.start==null;
    }

    @Override
    public void cancel() {
        this.start=this.end=null;
    }

    @Override
    public void insert(Object element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            start = newNode;
            end = newNode;
            start.next = end.previous;
            end.previous = start.next;
        } else {
            end.next = newNode;
            newNode.previous = end.next;
            end = end.next;
        }
    }
    
    @Override
    public Object delete() {
        Node aux = start;
        start = start.next;
        return aux.element;
    }

    @Override
    public Object firstElement() {
        if(isEmpty()){
            return -1;
        }
        return this.start.element;
    }
    
    @Override
    public String toString(){
        if(isEmpty()){
            throw new Exception("the queue is empty");
        }
        String result="";
        Node aux=this.start;
        while(aux!=this.end){
            result+=aux.element+" ";
            aux=aux.next;
        }
        return result+this.end.element;
    }
    
}

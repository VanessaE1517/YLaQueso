/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Logic.ExceptionStack;
import Logic.Node;
import java.util.List;

/**
 *
 * @author vanes
 */
public class LinkedStack implements Stack{

    public Node top;
    public int count;

    public LinkedStack() {
        this.top = null;
        this.count = 0;
    }
    
    @Override
    public int getsize() {
        return count;
    }
    
    @Override
    public int getsizeByList() {
        Node aux = this.top;
        int count2=1;
        if(isEmpty()){
            return 0;
        }else{
            while(aux.next != null){
                count2++;
                aux = aux.next;
            }
           return count;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count==0;
    }

    @Override
    public void cancel() {
        count =0;
    }

    @Override
    public Object top() {
        return top.element;
    }

    @Override
    public void push(Object element) {
       Node newNode = new Node(element);
       if(isEmpty()){
           top = newNode;
           count++;
       }else{
           newNode.next = top;
           top = newNode;
           count++;
       }
       
    }

    @Override
    public Object pop() {
        Node aux = this.top;
        if(isEmpty()){
            throw new ExceptionStack("Is empty");
        }else{
            this.top = top.next;
            this.count--;
        }
       return aux.element;
    }

    @Override
    public String tooString() {
        String result = "";
	Node aux = top;
	while(aux!=null) {
            result+=" "+aux.element;
            aux = aux.next;		
	}
	return result;
    } 
    
}

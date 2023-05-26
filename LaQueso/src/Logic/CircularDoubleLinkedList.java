/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author vanes
 */
public class CircularDoubleLinkedList implements ListC{
    public Node start;
    public Node end;
    
    public CircularDoubleLinkedList() {
        this.start=null;
        this.end=null;
    }

    @Override
    public void cancel() {
        this.start=null;
        this.end=null;
    }

    @Override
    public int getSize() {
        if (isEmpty()) {
            return 0;
        } else {
            int count = 1;
            Node aux = this.start;
            while (aux != this.end) {
                aux = aux.next;
                count++;
            }
            return count;
        }     
    }

    @Override
    public boolean isEmpty() {
        return this.start==null;
    }

    @Override
    public boolean exists(Object element) {
        Node aux = this.start;
        if (isEmpty()) {
            throw new ExceptionList("¿is empty");
        } else if(this.end.element==element){
            return true;
        }else{
            while (aux != this.end) {
                if (aux.element == element) {
                    return true;
                }
                aux = aux.next;
            }
        }
        return false;
    }

    @Override
    public void addHead(Object element) {
        Node newNode=new Node(element);
        if(isEmpty()){
            this.start=newNode;
            this.end=newNode;
        }else{
           newNode.next=this.start;
           this.start.previous=newNode;
           this.start=newNode;
           this.start.previous=this.end;
           this.end.next=this.start;
        }
    }

    @Override
    public void addEnd(Object element) {
        Node newNode=new Node(element);
        if(isEmpty()){
            this.start=newNode;
            this.end=newNode;
        }else{
            newNode.previous=this.end;
            this.end.next=newNode;
            this.end=newNode;
            this.end.next=this.start;
            this.start.previous=this.end;    
        }
    }
 
    @Override
    public Object getByPosition(int pos) {
        Node aux = this.start;
        int count = 1;
        if (isEmpty()) {
            throw new ExceptionList("is empty");
        } else {
            if (getSize() == pos) {
                return this.end.element;
            } else {
                while (aux != this.end) {
                    if (count == pos) {
                        return aux.element;
                    }
                    aux = aux.next;
                    count++;
                }
            }
        }
        return null;
    }

    @Override
    public void deleteByElement(Object element) {
        Node aux = this.start;
        Node previous = null;
        if (isEmpty()) {
            throw new ExceptionList("Is empty");
        } else {
            if (this.start.element == element) {
                this.start = this.start.next;
                this.end.next = this.start; 
            }else if (this.end.element == element) {
                while (aux.next != this.end) {
                    aux = aux.next;
                }
                aux.next = this.start;
                this.end = aux;
            } else {
                  while (aux != this.end) {
                    if (aux.element == element) {
                        previous.next = aux.next;
                        aux.previous = previous;
                    }
                    previous = aux;
                    aux = aux.next;
                }
            }
        }
    }

    @Override
    public Object firstInList() {
        if(isEmpty())
            throw new ExceptionList("Is empty");
        return this.start.element;
    }

    @Override
    public Object lastInFirst() {
        if(isEmpty())
            throw new ExceptionList("Is empty");
        return this.end.element;
    }
    
     public String toString() {
        if(isEmpty()){
            throw new ExceptionList("Is empty");
        } 
        String result = " ";
        Node aux = this.start;
        while (aux != this.end) {
            result += aux.element + " ";
            aux = aux.next;
        }
        return result + this.end.element;
    }

}

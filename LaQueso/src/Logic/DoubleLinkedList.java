/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author vanes
 */
public class DoubleLinkedList implements List{
    
    public Node start;

    public DoubleLinkedList() {
        this.start = null;
    }
     
    @Override
    public void cancel() {
       this.start = null;
    }

    @Override
    public int getSize() {
        if(isEmpty()){
            return 0;
        }else{
            int counter =0;
            Node aux = this.start;
            while(aux != null){
                aux = aux.next;
                counter++;
            }
            return counter;
        }
    }

    @Override
    public boolean isEmpty() {
       return this.start == null;
    }

    @Override
    public boolean exist(Object element) {
        Node aux = this.start;
        while(aux != null){
            if(aux.element == element){
                return true;
            }
                aux = aux.next;
        }
        return false;
    }

    @Override
    public void addHead(Object element) {
      
        Node newNode = new Node(element);
        
        if(isEmpty()){
            this.start = newNode;     
        }else{

            this.start.previous = newNode;
            newNode.next = this.start;
            this.start = newNode;
            
        }
    }

    @Override
    public void addEnd(Object element) {
     Node aux = start;
       Node newNode = new Node(element);
       
       if(isEmpty()){
           start = newNode;
       }else{
           while(aux.next!= null){
               aux = aux.next;    
           }
            aux.next = newNode;
       }
    }

    @Override
    public void deleteByElement(Object element) {
        Node aux = start;
        Node previus = null;
        if(isEmpty()){
            System.out.println("is empty");
        }else{
            while(aux.next!=null){
                if(aux.element == element){
                      previus.next = aux.next;
                    }
                previus = aux;
                aux = aux.next;
                
            }
        }
    }

    @Override
    public Object getByPosition(int pos) {
    Node aux = this.start;
    int count = 1;
    
        if (isEmpty()) {
            throw new ExceptionList("The list is empty");
        } else {
            if (count == pos) {
                return this.start.element;
            } else {
                while (aux != null) {
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
    public Object firstInList() {
        return this.start.element;
    }

    @Override
    public Object lastInList() {
        Node aux = start;
        while(aux.next!= null){
            aux = aux.next;    
           }
        return aux.element;
    }
 
    @Override
    public String toString(){
        String result = "";
	Node aux = start;
	while(aux!=null) {
            result+=" "+aux.element;
            aux = aux.next;		
	}
	return result;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author vanes
 */
public class Node {
    
    public Object element;
    public Node previous;
    public Node next;

    public Node(Object element) {
        this.element = element;
        this.previous = null;
        this.next = null;
    }
}

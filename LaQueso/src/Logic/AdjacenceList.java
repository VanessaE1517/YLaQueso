/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Logic.Exception;
import Logic.Exception;
import Logic.Graph;
import Logic.LinkedQueue;
import Logic.LinkedStack;
import Logic.Vertex;
import java.nio.file.Files;

/**
 *
 * @author Yoselin Porras Reyes
 */
public class AdjacenceList implements Graph{
    
    private Vertex[] vertexes;
    private int count;
    private int n;
    private int peso;

    LinkedStack stack;
    LinkedQueue queue;

    public AdjacenceList(int n) {
        if (n <= 0) {
            System.exit(0);
        }
        this.n = n;
        vertexes = new Vertex[n];
        this.count = 0;
        stack = new LinkedStack();
        queue = new LinkedQueue();
    }

    @Override
    public boolean isEmpty() {
        return this.count==0;
    }

    @Override
    public int getSize() {
        if (isEmpty()) {
            throw new Exception("The graph does not exist");
        }
        return this.count;
    }

    @Override
    public boolean existEdge(Object v1, Object v2) {
        if (isEmpty()) {
            throw new Exception("The graph does not exist");
        }
        if (vertexes[getPosition(v1)].listEdge.exists(v2)&&vertexes[getPosition(v2)].listEdge.exists(v1)) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean existVertex(Object element) {
        if (isEmpty()) {
            throw new Exception("The graph does not exist");
        }
        for (int i = 0; i < count; i++) {
            if (vertexes[i].element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addVertex(Object element) {
        if (count >= vertexes.length) {
            throw new Exception("filled graph");
        }
        vertexes[count++] = new Vertex(element);
    }

    @Override
    public void addEdge(Object v1, Object v2) {
        if (existVertex(v1) && existVertex(v2)) {
            vertexes[getPosition(v1)].listEdge.addEnd(v2);
            vertexes[getPosition(v2)].listEdge.addEnd(v1);
        }
    }

//    @Override
//    public void addWeight(Object v1, Object v2, int weigth) {
//        if (existVertex(v1) && existVertex(v2)&&existEdge(v1, v2)) {
//            if(!vertexes[getPosition(v1)].listWeight.isEmpty()){
//                vertexes[getPosition(v2)].listWeight.addEnd(weigth);
//            }else if(!vertexes[getPosition(v2)].listWeight.isEmpty()) {
//                vertexes[getPosition(v1)].listWeight.addEnd(weigth);
//            }else{
//                vertexes[getPosition(v2)].listWeight.addEnd(weigth);
//            }
//          
//        }
//    }
     @Override
    public void addWeight(Object v1, Object v2, int weigth) {
        if (existVertex(v1) && existVertex(v2)&&existEdge(v1, v2)) {
           
            vertexes[getPosition(v1)].listWeight.addEnd(weigth);
            
            vertexes[getPosition(v2)].listWeight.addEnd(weigth);
        }
    }

    @Override
    public String bfs() {       
         if (isEmpty()) {
            throw new Exception("BFS: Graph does not exist");
        } else {
            //se inicializa un string y se añade a la cola la posicion del primer elemento del vector
            String info = "";
            this.queue.insert(getPosition(this.vertexes[0].element));
            //se marca el visitado del primer elemento como verdadero y se añade el elemento al string
            this.vertexes[0].visited = true;
            info += this.vertexes[0].element + " ";
            //se inicializa un aux para ir moviendo las posiciones 
            int aux = 0;
            //creamos un ciclo while que se recorra mientras la cola no este vacia
            while (!this.queue.isEmpty()) {
                //creamos un for que se recorra hasta el contador
                for (int j = 0; j < this.count; j++) {
                    /*y vamos verificando con el metodo de si existe la arista,
                teniendo en cuenta que usamos el aux como la posicion del primer 
                elemento y la j del for como la posicion del segundo elemento*/
                    if (existEdge(this.vertexes[aux].element, this.vertexes[j].element)) {
                        /*si la arista existe, preguntamos si el elemento 
                        en la posicion j no ha sido visitado*/
                        if (this.vertexes[j].visited == false) {
                            //si es asi, insertamos en la cola la j que representa la posicion del elemento
                            this.queue.insert(j);
                            //marcamos el elemento como visitado
                            this.vertexes[j].visited = true;
                            //lo añadimos al string e inicializamos la j
                            info += this.vertexes[j].element + " ";
                        }
                    }
                }
                //una vez terminada el ciclo del for, se elimina el primer elemento en la cola 
                this.queue.delete();
                //le asignamos a aux el valor que tenga el primer elemento en la cola
                aux = (int) this.queue.firstElement();
            }
            //una vez terminado todo el recorrido, llamamos al metodo visited, para poner
            //todos los visitados en falso y retornamos el string
            resetVisited();
            return info;
         }    
    }

    @Override
    public String dfs() {
        if (isEmpty()) {
            throw new Exception("DFS: Graph does not exist");
        } else {
            //se inicializa un string y se añade a la pila la posicion del primer elemento del vector
            String info = "";
            this.stack.push(getPosition(this.vertexes[0].element));
            //se marca el visitado del primer elemento como verdadero y se añade el elemento al string
            this.vertexes[0].visited = true;
            info += this.vertexes[0].element + " ";
            //se inicializa un aux para ir moviendo las posiciones 
            int aux = 0;
            //creamos un ciclo while que se recorra mientras la pila no este vacia
            while (!this.stack.isEmpty()) {
                //creamos un for que se recorra hasta el contador
                for (int j = 0; j < this.count; j++) {
                    /*y vamos verificando con el metodo de si existe la arista,
                teniendo en cuenta que usamos el aux como la posicion del primer 
                elemento y la j del for como la posicion del segundo elemento*/
                    if (existEdge(this.vertexes[aux].element, this.vertexes[j].element)) {
                        /*si la arista existe, preguntamos si el elemento 
                    en la posicion j no ha sido visitado*/
                        if (this.vertexes[j].visited == false) {
                            //si es asi le asignamos a aux el valor de j
                            aux = j;
                            //luego añadimos a la pila esa posicion
                            this.stack.push(j);
                            /*por ultimo marcamos el elemento como visitado,
                        agregamos al string el elemento y reinciamos el valor de j*/
                            this.vertexes[j].visited = true;
                            info += this.vertexes[aux].element + " ";
                            j = 0;
                        }
                    }
                }
                //una vez recorrido todo el for, empezamos a sacar elementos de la pila
                this.stack.pop();
                //y asiganamos a aux el valor que tenga el top de la pila
                aux = (int) this.stack.top();
            }
            //una vez terminado todo el recorrido, llamamos al metodo visited, para poner
            //todos los visitados en falso y retornamos el string
            resetVisited();
            return info;
        }
    }
    
    public String toString() {
        String salida = " ";
        for (int i = 0; i < count; i++) {
            salida += vertexes[i].element+" ";
        }
        for (int i = 0; i < count; i++) {
            if (!vertexes[i].listEdge.isEmpty()) {
                salida += "\nThe vertex: " + i + " is: " + vertexes[i].element + " edges with " + vertexes[i].listEdge.toString() + "\n";
            }
            if (!vertexes[i].listWeight.isEmpty()) {
                salida += "weight of " + vertexes[i].listWeight.toString() + "\n";
            }
        }
        return salida;
    }
    
    public String friends(Object us){
        String salida = "";
        
        for (int i = 0; i < count; i++) {
            if(vertexes[i].element.equals(us)){
                salida += vertexes[i].listEdge.toString();
                return salida;
            }
        }

        return null;
    }
    
    public boolean verify(Object us){
         for (int i = 0; i < count; i++) {
             if(vertexes[i].element.equals(us)){
                if (!(vertexes[i].listEdge.toString().equals(""))) {
                    return true;
                }
             }
         }
         return false;
    }
    
    public String suggestion(Object us){
        String salida = "";
        
        for (int i = 0; i < count; i++) {
            if(vertexes[i].element.equals(us)){
                for (int j = 0; j < count; j++) {
                    vertexes[i].listEdge.exists(vertexes[j].listEdge);
                }
               
                return salida;
            }
        }

        return null;
    }
    
     public String mayores(Object element){
        String result = ": ";
        if (isEmpty()) {
            throw new Exception("The graph does not exist");
        }
        for (int i = 0; i < count; i++) {
            if ((int) vertexes[i].element > (int) element) {
                result +=  vertexes[i].element+", ";
            }
        }
        return result;
    }
     
      public String menores(Object element){
        String result = ":";
        if (isEmpty()) {
            throw new Exception("The graph does not exist");
        }
        for (int i = 0; i < count; i++) {
            if ((int) vertexes[i].element < (int) element) {
                result +=  vertexes[i].element+", ";
            }
        }
        return result;
    }
      
      public boolean esPar(Object element){
          if (isEmpty()) {
            throw new Exception("The graph does not exist");
        }
        for (int i = 0; i < count; i++) {
            if (vertexes[i].element.equals(element)) {
                if((int)element%2==0){
                    return true;
                }
            }
        }
        return false;
      }

      public int sumaPesos(){
          int result=0;
          if (isEmpty()) {
            throw new Exception("The graph does not exist");
        }
        for (int i = 0; i < count; i++) {
           result += Integer.parseInt(vertexes[i].listWeight.toString());
            System.out.println("tt"+vertexes[i].listWeight.toString());
        }
        return result;
      }
      
    public boolean showVertex(Object ver){
        for (int i = 0; i < count; i++) {
            if (vertexes[i].element.equals(ver)) {
                return true;
            }
        }
        return false;
    } 
    //privados
    private int getPosition(Object element) {
        for (int i = 0; i < count; i++) {
            if (vertexes[i].element.equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    public int sumaVertices() {
        int result = 0;
        if (isEmpty()) {
            throw new Exception("The graph does not exist");
        }
        for (int i = 0; i < count; i++) {
            result += (int) vertexes[i].element;
        }
        return result;
    }
    
    
    private Object showVertex(int position) {
        if (position < 0 || position == count) {
            throw new Exception("there is no vertex");
        }
        return vertexes[position].element.toString();
    }
    
    private void resetVisited() {
         for (int i = 0; i < this.count; i++) {
            this.vertexes[i].visited = false;
        }
    }
}

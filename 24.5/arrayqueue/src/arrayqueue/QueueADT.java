/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayqueue; 
public interface QueueADT<T> {
    
    public void enqueue(T element);

    public T dequeue() throws EmptyCollectionException;

    public T first() throws EmptyCollectionException;
   
    public boolean isEmpty();

    public int size();

    public String toString();
}


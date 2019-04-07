/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayqueue;  

import java.util.ArrayList;

public class ArrayQueue<T> implements QueueADT<T> {
    
   private T[] data;
   private int start;
   private int end; 
   private static int count = 0;
   private static String msg="queue";

   public ArrayQueue(int size) { 
       data = (T[]) new Object[size + 1];
       start = 0;
       end = size;
    }    
    
    public void enqueue(T element){
        if (start == ((end + 2) % data.length)) {  // space is full
            	T[] temp = data;
		int temp_size = temp.length;

		data = (T[]) new Object[2 * temp_size];

		for (int i = 0; i < temp_size - 1; i++) {
			data[i] = temp[start];
			start = (start + 1) % temp_size;
		}  
		start = 0;
		end = temp_size - 2;
        }
        end = (end + 1) % data.length;
        data[end] = element;
        count++;
    }

    public T dequeue() throws EmptyCollectionException{
        T first = null;        
        if(!isEmpty()){
            first = data[start];
            data[start] = null;
            start = (start + 1) % data.length;
            count--; 
            return first;
        } 
        throw new EmptyCollectionException("queue") ; 
    }

    public T first() throws EmptyCollectionException{
        T first = null;
        if(!isEmpty()){
            first = data[start];
            return first;
        }
        
        throw new EmptyCollectionException("queue") ; 
    }
   
    @Override
    public boolean isEmpty(){
        return start == ((end + 1) % data.length);
    }
    
    @Override
    public int size(){
        return count;
    }

    @Override
    public String toString()  {
       if(isEmpty()) {
           return "empty."; 
       }     
       String result = "Queue is: ";
       for (int i = start; i <= end; i++) {
           if (i == start) {
               result = result + data[i];
           }
           else {
                result = result + ", " + data[i];
           } 
       }
        return result;
    }
        
}

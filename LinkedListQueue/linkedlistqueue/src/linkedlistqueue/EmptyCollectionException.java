/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistqueue;
public class EmptyCollectionException extends RuntimeException {
    
    public EmptyCollectionException(String collection)
    {
        super("The " + collection + " is empty.");
    }
}

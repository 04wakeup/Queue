 
package linkedlistqueue; 
public class LinkedQueue<T> implements QueueADT<T> {
    private Node firstNode;  
    private Node lastNode;
    private Node currNode;
    
    private static int count=0;
    public LinkedQueue()
        {
                firstNode = null;
                lastNode = null;
        }
    
    @Override
    public void enqueue(T element) { 
		Node newNode = new Node(element, null); 
		if (isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode); 
		lastNode = newNode;
                count++; 
    }

    @Override
    public T dequeue() throws EmptyCollectionException {        
		T front = null;		
		if (!isEmpty())
		{
                        front = firstNode.getData();
			firstNode = firstNode.getNextNode();			
			if (firstNode == null)
				lastNode = null;                        
                        count--;
                        return front;
		} // end if 
                throw new EmptyCollectionException("queue") ; 
    }

    @Override
    public T first() throws EmptyCollectionException {
       T front = null;
        if (!isEmpty()){
           front = firstNode.getData(); 
           return front;
       }
       throw new EmptyCollectionException("queue") ; 
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public int size() {
       return count;
    }
    
    public String toString()  {
       if(isEmpty()) {
           return "empty."; 
       }     
        String result = "Queue is: "; 
        currNode = firstNode;
        result = result + currNode.getData();

         while (currNode.getNextNode() != null) {
                 currNode = currNode.getNextNode();
                 result = result + ", " + currNode.getData();
         }
         return result;
    }
private class Node implements java.io.Serializable
	{
		private T    data; // entry in queue
		private Node next; // link to next node 
		private Node(T dataPortion)
		{
			data = dataPortion;
			next = null;	
		} // end constructor
		
		private Node(T dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;	
		} // end constructor

		private T getData()
		{
			return data;
		} // end getData

		private void setData(T newData)
		{
			data = newData;
		} // end setData

		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node  
}
 

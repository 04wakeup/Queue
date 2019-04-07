
public class CustomLinkedList {
   public static void main (String[] args) {
      IntNode headObj; // Create IntNode objects
      IntNode currObj;
      IntNode lastObj;
      IntNode minObj;
      int i;           // Loop index
      
      headObj = new IntNode(-1); // Front of nodes list
      lastObj = headObj;
      
      
      for (i = 0; i < 20; ++i) { // Append 20 rand nums
         int rand = (int)(Math.random() * 100000); // random int (0-99999)
         currObj = new IntNode(rand);
         
         lastObj.insertAfter(currObj); // Append curr
         lastObj = currObj;
      }
       
      currObj = headObj; // Print the list
      minObj = currObj.getNext();
      while (currObj != null) {
         currObj.printNodeData();
         if (currObj != lastObj) {
               if (minObj.getValue() > currObj.getNext().getValue()) {
                   minObj = currObj;
                  }
            }
         
         currObj = currObj.getNext();
      }
      minObj.printNodeData();
   }
}

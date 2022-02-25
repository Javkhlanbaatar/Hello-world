public class StackAsLinkedList {
 
    SNode top;
 
    static class SNode {
        int data;
        SNode next;
 
        SNode(int data) { this.data = data; }
    }
 
    public boolean isEmpty()
    {
        return top == null;        
    }
    public boolean isFull() {
    	return false;
    }
 
    public void push(int data)
    {
        SNode newNode = new SNode(data);
 
        if (top == null) {
            top = newNode;
        }
        else {
            SNode temp = top;
            top = newNode;
            newNode.next = temp;
        }
      System.out.println(data + " pushed to stack");
    }
 
    public int pop()
    {
        int popped = Integer.MIN_VALUE;
        if (top == null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped = top.data;
            top = top.next;
        }
        return popped;
    }
 
    public int peek()
    {
        if (top == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        else {
            return top.data;
        }
    }
    public static void main(String[] args)
    {
 
        StackAsLinkedList sll = new StackAsLinkedList();
 
        sll.push(10);
        sll.push(20);
        sll.push(30);
 
        System.out.println(sll.pop() + " popped from stack");
 
        System.out.println("Top element is " + sll.peek());
    }
}
public class LLimplementation {
    public static class Node{
        int val;
        Node next;
        Node(){};
        Node(int val){
            this.val = val;
        }
    }
    public static class LLStack{
        private Node head = null;
        private int size = 0;
        void push(int x){
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size++;
        }
        void displayR(){
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
        void displayRecursion(Node h){
            if(h==null) return;
            displayRecursion(h.next);
            System.out.print(h.val +" ");
        }
        void display(){
            displayRecursion(head);
            System.out.println();
        }
        int size(){
            return size;
        }
        int pop(){
            if(head == null) {
                System.out.println("empty");
                return -1;
            }
            int x = head.val;
            head = head.next;
            return x;
        }
        int peek(){
            if(head == null) {
                System.out.println("empty");
                return -1;
            }
            return head.val;
        }
        boolean isEmpty(){
            return (size == 0);
        }
    }
    static void main(String[] args) {
        LLStack s = new LLStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.display();
        s.pop();
        s.display();
    }
}

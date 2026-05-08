import java.util.Stack;

public class Main {
    static Stack<Integer> copyStack(Stack<Integer> s){
        Stack<Integer> r = new Stack<>();
        while(!s.isEmpty()){
            r.push(s.pop());
        }
        Stack<Integer> t = new Stack<>();
        while(!r.isEmpty()){
            t.push(s.pop());
        }
        return t;
    }
    static Stack<Integer> insertAtIndex(Stack<Integer> s, int idx, int ele){
        Stack<Integer> temp = new Stack<>();
        while(s.size() > idx){
            temp.push(s.pop());
        }
        s.push(ele);
        while (!temp.isEmpty()){
            s.push(temp.pop());
        }
        return s;
    }
    static void insertAtEnd(Stack<Integer> s, int ele){
        if(s.isEmpty()) {
            s.push(ele);
            return;
        }
        int top = s.pop();
        insertAtEnd(s, ele);
        s.push(top);
    }
    static void printStack(Stack<Integer> s){
        int n = s.size();
        int[] arr = new int[n];
        for (int i = n-1; i >= 0; i--) {
            arr[i] = s.pop();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +" ");
            s.push(arr[i]);
        }
    }
    static void printStackRevR(Stack<Integer> s){
        if(s.isEmpty()) return;
        int top = s.pop();
        System.out.print(top +" ");
        printStackRevR(s);
        s.push(top);
    }
    static void printStackR(Stack<Integer> s){
        if(s.isEmpty()) return;
        int top = s.pop();
        printStackR(s);
        System.out.print(top +" ");
        s.push(top);
    }
    static void reverseStackR(Stack<Integer> s){
        if (s.size() == 1) return;
        int top = s.pop();
        reverseStackR(s);
        insertAtEnd(s,top);
    }

    static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
          s.push(1);
          s.push(2);
          s.push(3);
          s.push(4);
          s.push(5);
        printStackR(s);

    }
}
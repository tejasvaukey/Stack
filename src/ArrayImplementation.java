public class ArrayImplementation {
    public static class Stack{
        private int[] arr = new int[5];
        int idx = 0;
        void push(int x){
            if(isFull()){
                System.out.println("overflow");
                return;
            }
            arr[idx++] = x;
        }
        int pop(){
            if(idx == 0) return -1;
            int a = arr[idx];
            arr[idx-1] = 0;
            idx--;
            return a;
        }
        int peek(){
            if(idx == 0) return -1;
            return arr[idx-1];
        }
        void display(){
            for (int i = 0; i < idx; i++) {
                System.out.print(arr[i] +" ");
            }
            System.out.println();
        }
        int size() {
            return idx;
        }
        boolean isEmpty(){

            return size() == 0;
        }
        boolean isFull(){return size() == arr.length-1;
        }
        int capacity(){
            return arr.length;}
    }
    static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.display();
        s.pop();
        s.display();
    }
}

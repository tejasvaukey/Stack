import java.util.Stack;

public class Questions {
    static boolean isBalanced(String s){
        Stack<Character> a = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') a.push(s.charAt(i));
            if(a.peek() == '(') return false;
            else {
                if(a.isEmpty()) return false;
                if(ch == ')') a.pop();
            }
        }
        return a.isEmpty();
    }
    static int toBalance(String s){
        int open = 0, closed = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                open++;
            }
            else {
                if(ch == ')') {
                    closed++;
                }
            }
        }
        if(closed > open) {
            System.out.println(closed - open + " closed brackets need to be removed");
            return closed - open;
        } else {
            System.out.println(open - closed + " open brackets need to be removed");
            return open - closed;
        }
    }
    static int[] removeConsecutiveSubsequences(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(st.isEmpty() || st.peek() != arr[i]){
                st.push(arr[i]);
            }
            else if(arr[i] == st.peek()){
                if(i == n-1 || arr[i] != arr[i+1]){
                    st.pop();
                }
            }
        }
        int[] res = new int[st.size()];
        int m = res.length;
        for (int i = m-1; i >=0 ; i--) {
            res[i] = st.pop();
        }
        return res;
    }
    static int[] nextGreaterElement(int[] arr){
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] =  -1;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[i]){
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }
    static int[] nextGreaterElement2(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        res[n-1] = -1;
        st.push(arr[n-1]);
        for (int i = n-2; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() < arr[i]) st.pop();
            if(st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();
            st.push(arr[i]);
        }
        return res;
    }
    public int[] calculateSpans(int[] prices){
        int[] spans = new int[prices.length];
        spans[0] = 1; //Span of first element is always 1
        Stack<Integer> indexStack = new Stack<>();

        // push the index of element
        indexStack.push(0);
        for (int i = 1; i < prices.length; i++) {
            while(!indexStack.isEmpty() && prices[indexStack.peek()] <= prices[i]) indexStack.pop();

            // if index stack is empty, the price at index i is greater than all previous values
            if(indexStack.isEmpty()) spans[i] = i+1;
            else spans[i] = i - indexStack.peek();

            indexStack.push(i);
        }
        return spans;
    }



    static void main(String[] args) {
        String a = "((((ab(bc(d))))";
//        System.out.println(toBalance(a));
//        int[] arr= {1,2,2,3,10,10,10,4,4,4,5,7,7,2};
//        int[] res = removeConsecutiveSubsequences(arr);
        int[] arr2 = {1,3,2,1,8,6,3,4};
        int[] res2 = nextGreaterElement2(arr2);
        for (int re : res2) {
            System.out.print(re + " ");
        }
    }
}

import java.util.Stack;

public class Questions2 {
    public static void infix(String str){
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch; // 0 -> 48, 9 -> 57
            if(ascii >= 48 && ascii <= 57)
                val.push(ascii - 48); // -48 to push number
            else if(op.isEmpty() || ch == '(' || op.peek()=='(')
                op.push(ch);
            else if(ch==')'){
                while (op.peek() != '('){
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek() == '-') val.push(v1-v2);
                    if(op.peek() == '+') val.push(v1+v2);
                    if(op.peek() == '*') val.push(v1*v2);
                    if(op.peek() == '/') val.push(v1/v2);
                    op.pop();
                }
                op.pop(); // '(' hata diya
            }
            else {
                if(ch == '+' || ch == '-'){
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek() == '-') val.push(v1-v2);
                    if(op.peek() == '+') val.push(v1+v2);
                    if(op.peek() == '*') val.push(v1*v2);
                    if(op.peek() == '/') val.push(v1/v2);
                    op.pop();
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek()=='/'){
                        // work
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if(op.peek() == '*') val.push(v1*v2);
                        if(op.peek() == '/') val.push(v1/v2);
                        op.pop();
                        //push
                        op.push(ch);
                    }
                    else op.push(ch);
                }
            }
        }
        // val stack size - 1
        while (val.size()>1){
            int v2 = val.pop();
            int v1 = val.pop();
            if(op.peek() == '-') val.push(v1-v2);
            if(op.peek() == '+') val.push(v1+v2);
            if(op.peek() == '*') val.push(v1*v2);
            if(op.peek() == '/') val.push(v1/v2);
            op.pop();
        }
        System.out.println(val.peek());
    }
    public static void infixToPrefix(String infix){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            int ascii = (int)ch; // 0 -> 48, 9 -> 57
            if(ascii >= 48 && ascii <= 57){
                String s = "" + ch;
                val.push(s);
            }
            else if(op.isEmpty() || ch == '(' || op.peek()=='(')
                op.push(ch);
            else if(ch==')'){
                while (op.peek() != '('){
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);
                }
                op.pop(); // '(' hata diya
            }
            else {
                if(ch == '+' || ch == '-'){
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek()=='/'){
                        // work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = o + v1 + v2;
                        val.push(t);
                        //push
                        op.push(ch);
                    }
                    else op.push(ch);
                }
            }
        }
        while (val.size()>1){
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = o + v1 + v2;
            val.push(t);
        }
        String prefix = val.pop();
        System.out.println(prefix);
    }
    public static void infixToPostfix(String infix){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            int ascii = (int)ch; // 0 -> 48, 9 -> 57
            if(ascii >= 48 && ascii <= 57){
                String s = "" + ch;
                val.push(s);
            }
            else if(op.isEmpty() || ch == '(' || op.peek()=='(')
                op.push(ch);
            else if(ch==')'){
                while (op.peek() != '('){
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    val.push(t);
                }
                op.pop(); // '(' hata diya
            }
            else {
                if(ch == '+' || ch == '-'){
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    val.push(t);
                    op.push(ch);
                }
                if(ch == '*' || ch == '/'){
                    if(op.peek() == '*' || op.peek()=='/'){
                        // work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = v1 + v2 + o;
                        val.push(t);
                        //push
                        op.push(ch);
                    }
                    else op.push(ch);
                }
            }
        }
        while (val.size()>1){
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = v1 + v2 + o;
            val.push(t);
        }
        String prefix = val.pop();
        System.out.println(prefix);
    }
    public static void postfixEvaluation(String str){
        Stack<Integer> val = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57) val.push(ascii-48);
            else {
                int v2 = val.pop();
                int v1 = val.pop();
                if(ch == '-') val.push(v1-v2);
                if(ch == '+') val.push(v1+v2);
                if(ch == '*') val.push(v1*v2);
                if(ch == '/') val.push(v1/v2);
            }
        }
        System.out.println(val.peek());
    }
    public static void prefixEvaluation(String str){
        Stack<Integer> val = new Stack<>();
        for (int i = str.length()-1; i >= 0 ; i--) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57) val.push(ascii-48);
            else {
                int v1 = val.pop();
                int v2 = val.pop();
                if(ch == '-') val.push(v1-v2);
                if(ch == '+') val.push(v1+v2);
                if(ch == '*') val.push(v1*v2);
                if(ch == '/') val.push(v1/v2);
            }
        }
        System.out.println(val.peek());
    }
    public static void prefixTOpostfix(String str){
        Stack<String> val = new Stack<>();
        for (int i = str.length()-1; i >= 0 ; i--) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57) val.push(ch+"");
            else {
                String v1 = val.pop();
                String v2 = val.pop();
                char op = ch;
                String t = v1 + v2 + op;
                val.push(t);
            }
        }
        System.out.println(val.peek());
    }
    public static void postfixTOinfix(String str){
        Stack<String> val = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii >= 48 && ascii <= 57) val.push(ch+"");
            else {
                String v2 = val.pop();
                String v1 = val.pop();
                char op = ch;

                String t = "(" + v1 + op + v2 + ")";
                val.push(t);
            }
        }
        System.out.println(val.peek());
    }


    static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        infixToPostfix(str);
        postfixEvaluation("953+4*6/-");
        prefixEvaluation("-9/*+5346");


    }
}

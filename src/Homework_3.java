import java.util.Scanner;
public class Homework_3 {

    public static int stackPriority(String s){
        switch(s){
            case "(": return 3;
            case "*","/": return 2;
            case "+","-": return 1;
            case ")": return 0;
            default: return 0;
        }
    }

    public static boolean isOperator(String s){
        switch(s){
            case "+","-","*","/","(",")","#": return true;
            default: return false;
        }
    }

    public static void infixToPostfix(String expression){
        QueueADT infix = new QueueADT();
        StackADT operator = new StackADT();
        QueueADT postfix = new QueueADT();

        System.out.print("Infix Queue: ");
        for(String current : expression.split(" ")){
            System.out.print(current+" ");
            infix.enqueue(current);
        }
        System.out.println();

        operator.push("#");
        String token = infix.dequeue();
        while(!token.equals("#")){
            if(isOperator(token)){
                if(token.equals(")")){
                    while(!operator.empty()){
                        if(operator.ontop().equals("("))
                            break;
                        postfix.enqueue(operator.pop());
                    }
                    operator.pop();
                }
                else{
                    if(stackPriority(operator.ontop()) >= stackPriority(token)){
                        if(!operator.ontop().equals("("))
                            postfix.enqueue(operator.pop());
                        operator.push(token);
                    }
                    else{
                        operator.push(token);
                    }
                }
            }
            else{
                postfix.enqueue(token);
            }
            token = infix.dequeue();
        }
        while(!operator.empty())
            postfix.enqueue(operator.pop());

        postfixEvaluation(postfix);
    }

    public static void postfixEvaluation(QueueADT postfix){
        System.out.print("Postfix Queue: ");
        StackADT valueStack = new StackADT();
        while(!postfix.front().equals("#")){
            System.out.print(postfix.front()+" ");
            if(isOperator(postfix.front())){
                if(postfix.front().equals("*")){
                    postfix.dequeue();
                    int num1 = Integer.parseInt(valueStack.pop());
                    int num2 = Integer.parseInt(valueStack.pop());
                    valueStack.push(String.valueOf(num2 * num1));
                }
                else if(postfix.front().equals("/")){
                    postfix.dequeue();
                    int num1 = Integer.parseInt(valueStack.pop());
                    int num2 = Integer.parseInt(valueStack.pop());
                    valueStack.push(String.valueOf(num2 / num1));
                }
                else if(postfix.front().equals("+")){
                    postfix.dequeue();
                    int num1 = Integer.parseInt(valueStack.pop());
                    int num2 = Integer.parseInt(valueStack.pop());
                    valueStack.push(String.valueOf(num2 + num1));
                }
                else if(postfix.front().equals("-")){
                    postfix.dequeue();
                    int num1 = Integer.parseInt(valueStack.pop());
                    int num2 = Integer.parseInt(valueStack.pop());
                    valueStack.push(String.valueOf(num2 - num1));
                }
            }
            else{
                valueStack.push(postfix.dequeue());
            }
        }
        System.out.print(postfix.front());
        System.out.println();

        System.out.print("Value Stack Solution: ");
        while(!valueStack.empty()){
            System.out.print(valueStack.pop()+" ");
        }
    }

    public static void main(String[] args) {

        Scanner k = new Scanner(System.in);
        System.out.println("Enter arithmetic expression with each component separated by spaces:");
        String expression = k.nextLine();

        infixToPostfix(expression);

    }
}

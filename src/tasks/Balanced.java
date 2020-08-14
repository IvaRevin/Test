package tasks;

import java.util.*;

public class Balanced {
    static boolean areParanthesisBalanced(String expr)
    {
        // создаем очередь
        Deque<Character> stack = new ArrayDeque<Character>();

        // проходим по строке
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' ) {
                // кладем элемент в очередь удовлетворяющий условию
                stack.push(x);
                continue;
            }

            //Если скобка открывается, то она должна закрыться
            if (stack.isEmpty())
                return false;

            switch (x) {
                case ')':
                    stack.pop();
                    if (x == '[')
                        return false;
                    break;

                case ']':
                    stack.pop();
                    if (x == '(')
                        return false;
                    break;
            }
        }


        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        if(areParanthesisBalanced(str)){
            System.out.println("Правильно");
        }else{
            System.out.println("Неправильно");
        }
    }
}

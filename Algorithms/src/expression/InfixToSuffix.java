package expression;

import java.util.Stack;

/**
 * Created by LeeAutumn on 18/12/2016.
 * blog: leeautumn.net
 */
public class InfixToSuffix {

    public static String[] transer(String infixExpress){
        StringBuilder stringBuilder = new StringBuilder("");

        Stack<String> stack = new Stack<String>();

        String[] strs  = splitExpress(infixExpress.replaceAll(" ",""));

        int t = 0;
        String topOfStack = "";

        for(int i=0;i<strs.length;i++){
            t = isOperator(strs[i]);
            if(!stack.empty())
                topOfStack = stack.peek();

            if(t == 0){
                stringBuilder.append(strs[i]+",");
            }else{
                if(!stack.empty()){

                    if(lt(strs[i],topOfStack)){

                        boolean isRight = strs[i].equals(")");

                        //如果不是右括号,则是把所有的优先级小于的符号都pop出来
                        //如果是右括号,则pop到左括号位置
                        while(!stack.empty() && lt(strs[i],stack.peek())){

                            if(!stack.peek().equals("(")) {
                                stringBuilder.append(stack.pop()+",");
                            }else{
                                if(isRight){
                                    stack.pop();
                                }
                                break;
                            }

                        }

//                        if(!stack.empty() && !isRight){
//                            stringBuilder.append(stack.pop());
//                        }

                        if(!isRight) {
                            stack.push(strs[i]);
                        }

                    }else{
                        stack.push(strs[i]);
                    }
                }else{
                    stack.push(strs[i]);
                }
            }
        }

        //pop all the left operators to the suffix expression
        while(!stack.empty()){
            stringBuilder.append(stack.pop()+",");
        }

        String res = stringBuilder.toString();
        return res.substring(0,res.length()-1).split(",");
    }


    /**
     * inspect the char is the operator & return the priority of the operator
     * @param c
     * @return 0    isNumber
     *         !0   the priority of the operator
     */
    private static int isOperator(String c){
        if(c.length() == 1 && c.charAt(0) >= 40 && c.charAt(0) <= 47 ){
            return 1;
        }
        return 0;
    }


    /**
     * according to the ascii table to judge the next character is number or operator.
     * @param expression
     * @return
     */
    private static String[] splitExpress(String expression){
        int offset = 0;
        StringBuilder stringBuilder = new StringBuilder("");

        char[] chars = expression.toCharArray();

        for(int i=0;i<chars.length;i++){
            if(chars[i] < 48 ){
                if(offset != i) {
                    stringBuilder.append(expression.substring(offset, i));
                    stringBuilder.append(" ");
                }
                stringBuilder.append(chars[i]);
                stringBuilder.append(" ");
                offset = i+1;
            }

        }

        if(offset != chars.length){
            stringBuilder.append(expression.substring(offset,chars.length));
        }

        return stringBuilder.toString().trim().split(" ");
    }

    /**
     * greter equal than  -- priority  s1 < s2
     * @param s1
     * @param s2
     * @return
     */
    private static boolean lt(String s1,String s2){
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        if(c1 == '/'){
            c1 -= 5;
        }

        if(c1 == ')'){
            return true;
        }
        if(c1 == '(' ){
            return false;
        }

        if(c1 == '*'){
            return c2 < 42;
        }

        if(c1 == '+' || c1 == '-'){
            return true;
        }

        return false;
    }
}

import java.util.Stack;

public class AutomataPila {
    
    private void S0(Stack<String> stack){
        stack.push("B");
    }

    private int S1(String input, int index, Stack<String> stack) throws Exception{

        while (index < input.length()) {

            String lookahead = "" + input.charAt(index);

            switch (lookahead) {
                case "(":{
                    String topStack = stack.peek();
                    
                    if (topStack.equals("B")){
                        stack.pop();
                        stack.push("B");
                        stack.push("R");
                        stack.push("(");
                    } else if (topStack.equals("(")){
                        index++;
                        stack.pop(); //Extraer el parentesis y no insertar nada
                    } else if (topStack.equals("R")){
                        stack.pop();
                        stack.push("R");
                        stack.push("R");
                        stack.push("(");
                    } else {
                        throw new Exception("No hay transición con " + topStack + " y " + lookahead);
                    }
                    
                }break;
            
                case ")":{
                    String topStack = stack.peek();
                    
                    if (topStack.equals("R")){
                        stack.pop();
                        stack.push(")");
                    } else if (topStack.equals(")")){
                        index++;
                        stack.pop();
                    } else {
                        throw new Exception("No hay transición con " + topStack + " y " + lookahead);
                    }

                }break;

                default:
                    throw new Exception("El simbolo: " + lookahead + " No pertenece al alfabeto");

            }
            
        } //Fin del while

        if (stack.peek().equals("B") && stack.size() == 1){
            stack.pop();
        }

        return index;
    }

    private void S2(String input, int index, Stack<String> stack) throws Exception{

        if (index != input.length()){ //No llego al final
            throw new Exception("Simbolos pendientes de consumir cadena no aceptada");
        }

        if (!stack.isEmpty()){
            throw new Exception("Simbolos pendientes de procesar cadena no aceptada");
        }
    }


    public boolean esAceptada(String input){

        boolean cadenaAceptada = false;
        int index = 0;
        Stack<String> stack = new Stack<String>();

        try {
            S0(stack);
            index = S1(input, index, stack);
            S2(input, index, stack);
            cadenaAceptada = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return cadenaAceptada;
    }

}

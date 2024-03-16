public class ScannerAFD3 {
    private int[] estadosAceptacion = { 3 };

    private int Estado0(char letra) throws Exception{
        if (letra == 'a'){
            return 1;
        } else if (letra == 'b'){
            return 0;
        } else {
            throw new Exception("Letra " + letra + " no reconocida en el estado 0");
        }

    }


    private int Estado1(char letra) throws Exception{
        if (letra == 'a'){
            return 1;
        } else if (letra == 'b'){
            return 2;
        } else {
            throw new Exception("Letra " + letra + " no reconocida en el estado 1");
        }

    }

    private int Estado2(char letra) throws Exception{
        if (letra == 'a'){
            return 1;
        } else if (letra == 'b'){
            return 3;
        } else {
            throw new Exception("Letra " + letra + " no reconocida en el estado 2");
        }
    }

    private int Estado3(char letra) throws Exception{
        if (letra == 'a'){
            return 1;
        } else if (letra == 'b'){
            return 0;
        } else {
            throw new Exception("Letra " + letra + " no reconocida en el estado 3");
        }
    }

    private boolean esEstadoAceptacion(int estado){
        for (int i: estadosAceptacion){
            if (i == estado){
                return true;
            }
        }
        return false;
    }

    public boolean esAceptada(String input) throws Exception{

        int estadoActual = 0;
        for (char letra: input.toCharArray()){
            
            if (estadoActual == 0){
                estadoActual = Estado0(letra);
            } else if (estadoActual == 1){
                estadoActual = Estado1(letra);
            } else if (estadoActual == 2){
                estadoActual = Estado2(letra);
            } else if (estadoActual == 3){
                estadoActual = Estado3(letra);
            }

        }

        return esEstadoAceptacion(estadoActual);
    }

}

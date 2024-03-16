public class ScannerAFD2 {
    private int[] estadosAceptacion = { 0, 1 };

    private int Estado0(char letra) throws Exception{
        if (letra == '0'){
            return 1;
        }else if (letra == '1'){
            return 0;
        } else {
            throw new Exception("Letra " + letra + " no reconocida en el estado 0");
        }
    }

    private int Estado1(char letra) throws Exception{
        if (letra == '0'){
            return 1;
        }else if (letra == '1'){
            return 1;
        } else {
            throw new Exception("Letra " + letra + " no reconocida en el estado 1");
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
            } 

        }

        return esEstadoAceptacion(estadoActual);
    }


}

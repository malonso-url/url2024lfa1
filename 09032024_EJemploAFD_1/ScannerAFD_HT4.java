public class ScannerAFD_HT4 {

        public static final int d_binario = 1;
        public static final int BIN = 2;
        public static final int d_decimal = 3;
        public static final int DEC = 4;
        public static final int letra = 5;
        public static final int blank_space = 6;
        public static final int NAME = 7;
        public static final int simbolo = 8;
        public static final int PSW = 9;

        private int estado0(char _letra) throws Exception{
           int setPerteneciente = getSet("" + _letra);

           switch (setPerteneciente) {
            case d_binario: return 1;
            case d_decimal: return 2;
            case letra: return 3;
            case simbolo: return 4;
           
            default:
                throw new Exception("El caracter: " + _letra + " No tiene transición en el estado 0");
           }

        }

        private int estado1(char _letra) throws Exception{
            int setPerteneciente = getSet("" + _letra);
 
            switch (setPerteneciente) {
             case d_binario: return 1;
            
             default:
                 throw new Exception("El caracter: " + _letra + " No tiene transición en el estado 1");
            }
         }

         private int estado2(char _letra) throws Exception{
            int setPerteneciente = getSet("" + _letra);
 
            switch (setPerteneciente) {

             case d_decimal: return 2;
             case letra: return 4;
             case simbolo: return 4;
            
             default:
                 throw new Exception("El caracter: " + _letra + " No tiene transición en el estado 2");
            }
 
         }

         private int estado3(char _letra) throws Exception{
            int setPerteneciente = getSet("" + _letra);
 
            switch (setPerteneciente) {

             case d_decimal: return 4;
             case letra: return 3;
             case blank_space: return 6;
             case simbolo: return 4;
            
             default:
                 throw new Exception("El caracter: " + _letra + " No tiene transición en el estado 3");
            }
 
         }

         private int estado4(char _letra) throws Exception{
            int setPerteneciente = getSet("" + _letra);
 
            switch (setPerteneciente) {

             case d_decimal: return 4;
             case letra: return 4;
             case simbolo: return 4;
            
             default:
                 throw new Exception("El caracter: " + _letra + " No tiene transición en el estado 4");
            }
 
         }

         private int estado6(char _letra) throws Exception{
            int setPerteneciente = getSet("" + _letra);
 
            switch (setPerteneciente) {

             case letra: return 8;

            
             default:
                 throw new Exception("El caracter: " + _letra + " No tiene transición en el estado 6");
            }
 
         }

         private int estado8(char _letra) throws Exception{
            int setPerteneciente = getSet("" + _letra);
 
            switch (setPerteneciente) {

             case letra: return 8;

            
             default:
                 throw new Exception("El caracter: " + _letra + " No tiene transición en el estado 8");
            }
 
         }

         public String getToken(String input) throws Exception{

            int estadoActual = 0;
            for (char letra: input.toCharArray()){
                if (estadoActual == 0){
                    estadoActual = estado0(letra);
                } else if (estadoActual == 1){
                    estadoActual = estado1(letra);
                } else if (estadoActual == 2){
                    estadoActual = estado2(letra);
                } else if (estadoActual == 3){
                    estadoActual = estado3(letra);
                } else if (estadoActual == 4){
                    estadoActual = estado4(letra);
                } else if (estadoActual == 6){
                    estadoActual = estado6(letra);
                } else if (estadoActual == 8){
                    estadoActual = estado8(letra);
                }
            }
    
            switch (estadoActual) {
                case 1:
                    return "NUMERO BINARIO";
            
                case 2:
                    return "NUMERO DECIMAL";

                case 5:
                    return "NOMBRE PROPIO";

                case 8:
                    return "NOMBRE PROPIO";

                case 3: 
                    return "PASSWORD";

                case 4:
                    return "PASSWORD";

                default:
                    return "NO CUMPLE CON EL LENGUAJE";
            }
        }

        private int getSet(String caracter){
            if ("01".contains(caracter)){
                return d_binario;
            } else if ("0123456789".contains(caracter)){
                return d_decimal;
            } else if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(caracter)){
                return letra;
            } else if ("$@!.-_".contains(caracter)){
                return simbolo;
            } else if (" ".equals(caracter)){
                return blank_space;
            } else {
                return -1;
            }
        }

}

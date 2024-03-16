import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //ScannerAFD2 afd = new ScannerAFD2();
        ScannerAFD_HT4 afd = new ScannerAFD_HT4();

        try {
            //System.out.println("Ingrese una cadena para verificar si pertenece a: ab+");
            //System.out.println("Ingrese una cadena para verificar si pertenece a: (a|b)*abb");
            //System.out.println("Ingrese una cadena para verificar si pertenece a: (0|1*)+0?|1+");
            System.out.println("Ingrese una cadena para identificarla");
            
            String comando = in.nextLine();

            /*if (afd.esAceptada(comando)){
                System.out.println("Cadena aceptada");
            } else {
                System.out.println("Cadena NO aceptada");    
            }*/
            System.out.println(afd.getToken(comando));
        } catch(Exception e){
            System.out.println(e.getMessage());
        } finally{
            in.close();
        }

    }
    
}

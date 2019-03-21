import java.util.ArrayList;
public class Programa{

    public static void main(String[] args) {

        try {
            Data inicioAulas1s2019 = new Data(28, 3, 2019);
            System.out.println(inicioAulas1s2019);
            inicioAulas1s2019.setDia(80);
            System.out.println(inicioAulas1s2019);
            
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
            //System.err.println("Sua mensagem de erro"); TAMBEM PODE FAZER ASSIM
        }
        try {
            Data fimDasAulas1s2019 = new Data(30, 6, 2019);
            System.out.println(fimDasAulas1s2019);
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
            //System.err.println("Sua mensagem de erro"); TAMBEM PODE FAZER ASSIM
        }
        try {
            Data inicioAulas1s2019 = new Data(29, 2, 2016);
            System.out.println(inicioAulas1s2019);
            /*System.out.println(inicioAulas1s2019.toString());//pode por ou não o toString()*/
            Data dSeg = inicioAulas1s2019.diaSeguinte();
            System.out.println(dSeg);
            Data outro = new Data(1, 3, 2016);
            System.out.println(outro);
            if (dSeg.equals(outro)) {
                System.out.println("igual");
            }else{
                System.out.println("diferentes");
            }
            
            ArrayList<Data> arr = new ArrayList<Data>();
            arr.add(dSeg);
            if (arr.contains(outro)){ 
                System.out.println("contem");
            }

        } catch (Exception erro) {
            System.err.println(erro.getMessage());
            //System.err.println("Sua mensagem de erro"); TAMBEM PODE FAZER ASSIM
        }

    }

}
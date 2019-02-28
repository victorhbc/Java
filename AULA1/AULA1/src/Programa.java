public class Programa{

    public static void main(String[] args) {

        try {
            Data inicioAulas1s2019 = new Data(28, 2, 2019);
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
        
    }

}
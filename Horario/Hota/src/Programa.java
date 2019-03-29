public class Programa{
    
    public static void main(String[] args) {
        try {
            Hora h1 = new Hora(12, 15, 30);
            System.out.println(h1);
            Hora prox = h1.adiante(72400);
            System.out.println(prox);
            
        } catch (Exception erro) {
            System.err.println(erro.getMessage());
        }
    }

}
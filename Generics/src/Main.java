public class Main {
    public static void main(String[] args){
        try {
            Conjunto<Integer> vetor = new Conjunto<Integer>(10);
            Conjunto<Integer> vetor2 = new Conjunto<>(10);

            Conjunto<Integer> vetorTest = new Conjunto<>(vetor);

           for(int i = 0; i<10; i++){
               vetor.inclua(i);
           }

            System.out.println(vetor);
            System.out.println(vetorTest);

            Conjunto<Integer> vetorClone = (Conjunto<Integer>) vetor.clone();
            System.out.println(vetorClone);



           for(int i = 0; i < 10; i++){
               vetor2.inclua(i);
           }

            System.out.println(vetor.equals(vetor2));
            System.out.println(vetor.hashCode());
            System.out.println(vetor2.hashCode());
            System.out.println(vetor);
            System.out.println(vetor2);

            System.out.println(vetor.uniao(vetor2));
            System.out.println(vetor.menos(vetor2));
            System.out.println(vetor.intersecao(vetor2));


            vetor.exclua(4);

            System.out.println(vetor);
        }catch(Exception erro){
            System.err.println(erro.getMessage());
        }
    }
}

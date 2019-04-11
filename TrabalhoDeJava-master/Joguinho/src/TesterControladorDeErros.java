class TesterControladorDeErros{

    public static void main(String[] args){

        try {
            ControladorDeErros c1 = new ControladorDeErros(5);
            
            for (int i = 0; i <= 5; i++) {
                c1.registreUmErro();
            } 
            
            //Teste do método registreUmErro

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

        try {
            ControladorDeErros c2 = new ControladorDeErros(5);
            ControladorDeErros c3 = new ControladorDeErros(5);

            if (c2.equals(c3))
                System.out.println("iguais");
            else
                System.out.println("Diferentes");

            ControladorDeErros c4 = new ControladorDeErros(6);

            if (c3.equals(c4))
                System.out.println("iguais");
            else
                System.out.println("Diferentes");

            //Teste do método Equals

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

        try {
            ControladorDeErros c5 = new ControladorDeErros(5);
            System.out.println(c5.hashCode());

            ControladorDeErros c6 = new ControladorDeErros(5);
            c6.registreUmErro();
            System.out.println(c6.hashCode());

            //Teste do método hashCode

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

        try {
            ControladorDeErros c7 = new ControladorDeErros(6);
            System.out.println("Quantidade de erros de C7: " + c7);

            ControladorDeErros c8 = new ControladorDeErros(c7);
            System.out.println("Quantidade de erros de C8: " + c8);

            if(!c8.equals(c7))
                System.out.println("Não são iguais, o que prova que o construtor de cópias, copia o objeto e não apenas aponta para o objeto referenciado");
            else 
                System.out.println("nada foi alterado no objeto copaiado e nem no criado a partir da cópia porém, são objetos diferentes");

            c8.registreUmErro();
            if(!c8.equals(c7))
                System.out.println("Não são iguais, o que prova que o construtor de cópias, copia o objeto e não apenas aponta para o objeto referenciado");
            else 
                System.out.println("nada foi alterado no objeto copaiado e nem no criado a partir da cópia porém, são objetos diferentes");
            
            //Teste do Método ConstrutorDeErros - que é o construtor de cópias

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
        
        try {
            ControladorDeErros c9 = new ControladorDeErros(5);
            System.out.println("Quantidade de erros de C9: " + c9);

            ControladorDeErros c10 = (ControladorDeErros) c9.clone();
            System.out.println("Quantidade de erros de C10: " + c10);

             if(!c9.equals(c10))
                System.out.println("Não são iguais, o que prova que o construtor de cópias, copia o objeto e não apenas aponta para o objeto referenciado");
            else 
                System.out.println("nada foi alterado no objeto copaiado e nem no criado a partir da cópia porém, são objetos diferentes");

            c10.registreUmErro();
            if(!c9.equals(c10))
                System.out.println("Não são iguais, o que prova que o construtor de cópias, copia o objeto e não apenas aponta para o objeto referenciado");
            else 
                System.out.println("nada foi alterado no objeto copaiado e nem no criado a partir da cópia porém, são objetos diferentes");

            //Teste do Método Clone

        
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

    }

}
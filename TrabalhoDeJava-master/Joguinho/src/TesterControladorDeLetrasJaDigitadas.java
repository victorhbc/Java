class TesterControladorDeLetrasJaDigitadas{

    public static void main(String[] args) {
        try {
            ControladorDeLetrasJaDigitadas c1 = new ControladorDeLetrasJaDigitadas();

            if (c1.isJaDigitada('k'))
                System.out.println("letra já digitada");
            else
                System.out.println("Letra não digitada");

            c1.registreUmaLetra('k');
            
            if (c1.isJaDigitada('k'))
                System.out.println("letra já digitada");
            else
                System.out.println("Letra não digitada");

            //Teste do método registreUmErro


        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

        try {
            ControladorDeLetrasJaDigitadas c2 = new ControladorDeLetrasJaDigitadas();
            ControladorDeLetrasJaDigitadas c3 = new ControladorDeLetrasJaDigitadas();

            if (c2.equals(c3))
                System.out.println("iguais");
            else
                System.out.println("Diferentes");

            c3.registreUmaLetra('a');
            if (c2.equals(c3))
                System.out.println("iguais");
            else
                System.out.println("Diferentes");

            //Teste do método Equals

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

        try {
            ControladorDeLetrasJaDigitadas c4 = new ControladorDeLetrasJaDigitadas();
            System.out.println("O hashcode de c4 é: " + c4.hashCode());

            ControladorDeLetrasJaDigitadas c5 = new ControladorDeLetrasJaDigitadas();
            c5.registreUmaLetra('a');
            System.out.println("O hashcode de c5 é: " + c5.hashCode());
            
            //Teste do método hashCode

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }

        try {
            ControladorDeLetrasJaDigitadas c6 = new ControladorDeLetrasJaDigitadas();
            ControladorDeLetrasJaDigitadas c7 = new ControladorDeLetrasJaDigitadas (c6);

            if(!c6.equals(c7))
                System.out.println("Não são iguais, o que prova que o construtor de cópias, copia o objeto e não apenas aponta para o objeto referenciado");
            else 
                System.out.println("nada foi alterado no objeto copaiado e nem no criado a partir da cópia porém, são objetos diferentes");

            c7.registreUmaLetra('a');
            if(!c6.equals(c7))
                System.out.println("Não são iguais, o que prova que o construtor de cópias, copia o objeto e não apenas aponta para o objeto referenciado");
            else 
                System.out.println("nada foi alterado no objeto copaiado e nem no criado a partir da cópia porém, são objetos diferentes");
            
                //Teste do Método ConstrutorDeErros - que é o construtor de cópias

        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
        
        try {
            ControladorDeLetrasJaDigitadas c8 = new ControladorDeLetrasJaDigitadas();
            ControladorDeLetrasJaDigitadas c9 = (ControladorDeLetrasJaDigitadas) c8.clone();

             if(!c8.equals(c9))
                System.out.println("Não são iguais, o que prova que o construtor de cópias, copia o objeto e não apenas aponta para o objeto referenciado");
            else 
                System.out.println("nada foi alterado no objeto copaiado e nem no criado a partir da cópia porém, são objetos diferentes");

            c9.registreUmaLetra('e');
            if(!c8.equals(c9))
                System.out.println("Não são iguais, o que prova que o construtor de cópias, copia o objeto e não apenas aponta para o objeto referenciado");
            else 
                System.out.println("nada foi alterado no objeto copaiado e nem no criado a partir da cópia porém, são objetos diferentes");

            //Teste do Método Clone
        
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
    }

}
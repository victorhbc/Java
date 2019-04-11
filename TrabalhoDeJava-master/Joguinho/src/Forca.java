import java.io.*;

class Forca
{
    public static void main (String args [])
    {
        BancoDePalavras bancoDePalavras = new BancoDePalavras ();
        char            continuar       = ' ';

        do
        {
            try
            {
                Palavra palavra   =
                bancoDePalavras.getPalavraSorteada();
                Tracinhos tracinhos =
                new Tracinhos (palavra.getTamanho ());

                ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas =
                new ControladorDeLetrasJaDigitadas ();
                ControladorDeErros controladorDeErros =
                new ControladorDeErros ((int)(palavra.getTamanho()*0.6));

                while (tracinhos.isComTracinhosAinda () && !controladorDeErros.isComMaximoDeErrosAtingido ())
                {
                    System.out.println ("Palavra: "+tracinhos);
                    System.out.println ("Ja foi.: "+controladorDeLetrasJaDigitadas);
                    System.out.println ("Erros..: "+controladorDeErros);

                    System.out.print   ("Letra..? ");
                    char letra = Character.toUpperCase (Teclado.getUmChar());

                    if (controladorDeLetrasJaDigitadas.isJaDigitada (letra))
                        System.err.println ("Essa letra ja foi digitada!\n");
                    else
                    {
                        controladorDeLetrasJaDigitadas.registreUmaLetra (letra);

                        int qtd = palavra.getQuantidadeDaLetra (letra);

                        if (qtd==0)
                        {
                            System.err.println ("A palavra nao tem essa letra!\n");
                            controladorDeErros.registreUmErro ();
                        }
                        else
                        {
                            for (int i=0; i<qtd; i++)
                                tracinhos.desvele (palavra.getPosicaoDeOcorrenciaDaLetra (i,letra), letra);
                            System.out.println ();
                        }
                    }
                }

                if (controladorDeErros.isComMaximoDeErrosAtingido ())
                    System.out.println ("Que pena! Voce perdeu! A palavra era "+palavra+"\n");
                else
                    System.out.println ("Parabens! Voce ganhou! A palavra era mesmo "+palavra+"\n");

                for(;;)
                {
                    try
                    {
                        System.out.print ("Deseja jogar de novo (S/N)? ");
                        continuar = Character.toUpperCase (Teclado.getUmChar());
                        if (continuar!='S' && continuar!='N')
                            System.err.println ("Opcao invalida! Tente novamente...");
                        else
                            break;
                    }
                    catch (Exception erro)
                    {
                        System.err.println ("Opcao invalida! Tente novamente...");
                    }
                }
            }
            catch (Exception erro)
            {
                System.err.println (erro.getMessage());
            }
        }
        while (continuar == 'S');
    }
}
class TesterPalavra
{
	public static void main(String[] args)
	{
		try
		{
			Palavra palavra = new Palavra("teste");

			System.out.println(palavra);

			int quantidadeDaLetra = palavra.getQuantidadeDaLetra('e');

			System.out.println("A quantidade de vezes que a letra 'e' aparece e de: " + quantidadeDaLetra);

			for(int i=0; i<quantidadeDaLetra; i++)
			{
				System.out.println("A letra 'e' se encontra na posicao " + (palavra.getPosicaoDeOcorrenciaDaLetra(i, 'e') + 1) + " da palavra");
			}

			System.out.println("O tamanho da palavra e de " + palavra.getTamanho() + " caracteres");
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		//Teste dos métodos de construção, getQuantidadeDaLetra, getPosicaoDeOcorrenciaDaLetra e getTamanho

		try
		{
			Palavra palavra1 = new Palavra("teste");
			Palavra palavra2 = new Palavra("teste");
			Palavra palavra3 = new Palavra("diferente");

			if(palavra1.equals(palavra2))
				System.out.println("Sao iguais!");

			if(!palavra1.equals(palavra3))
				System.out.println("Sao diferentes!");

			System.out.println("O hashcode da palavra1 e de: " + palavra1.hashCode());
			System.out.println("O hashcode da palavra2 e de: " + palavra2.hashCode());
			System.out.println("O hashcode da palavra3 e de: " + palavra3.hashCode());
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		//Teste dos métodos equals e hashCode
	}
}
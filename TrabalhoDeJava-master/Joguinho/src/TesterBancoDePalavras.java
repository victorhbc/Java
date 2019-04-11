class TesterBancoDePalavras
{
	public static void main (String[] args)
	{
		try
		{
			BancoDePalavras banco = new BancoDePalavras();

			System.out.println(banco);

			Palavra palavra = banco.getPalavraSorteada();

			System.out.println(palavra);
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		//Teste do objeto e do método getPalavraSorteada

		try
		{
			BancoDePalavras banco1 = new BancoDePalavras();
			BancoDePalavras banco2 = new BancoDePalavras();

			if(banco1.equals(banco2))
				System.out.println("Sao iguais!");
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		//Teste do método equals

		try
		{
			BancoDePalavras banco = new BancoDePalavras();

			System.out.println("O hashcode de banco e: " + banco.hashCode());
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		//Teste do método hashCode
	}
}
class TesterTracinhos
{
	public static void main(String[] args)
	{
		try
		{
			Tracinhos t1 = new Tracinhos(3);

			System.out.println(t1);

			t1.desvele(1, 'B');

			System.out.println(t1);

			if(t1.isComTracinhosAinda())
				System.out.println("Ainda ha tracinhos");
			else
				System.out.println("Nao ha mais tracinhos");

			t1.desvele(0, 'O');
			t1.desvele(2, 'A');

			if(t1.isComTracinhosAinda())
				System.out.println("Ainda ha tracinhos");
			else
				System.out.println("Nao ha mais tracinhos");
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		//Teste dos métodos desvele e isComTracinhosAinda

		try
		{
			Tracinhos t1 = new Tracinhos(2);
			Tracinhos t2 = new Tracinhos(2);
			Tracinhos t3 = new Tracinhos(4);

			if(t1.equals(t2))
				System.out.println("Sao iguais");
			else
				System.out.println("Sao diferentes");

			if(t1.equals(t3))
				System.out.println("Sao iguais");
			else
				System.out.println("Sao diferentes");
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		//Teste do método equals

		try
		{
			Tracinhos t1 = new Tracinhos(2);
			Tracinhos t2 = new Tracinhos(5);

			System.out.println("O hashcode de t1 e: " + t1.hashCode());

			t2.desvele(1, 'B');
			System.out.println("O hashcode de t2 e: " + t2.hashCode());
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		//Teste do método hashCode

		try
		{
			Tracinhos t1 = new Tracinhos(2);
			Tracinhos t2 = new Tracinhos(t1);

			if(t1.equals(t2))
				System.out.println("Sao iguais");

			t2.desvele(0, 'A');

			if(!t1.equals(t2))
				System.out.println("Sao diferentes");

			//Teste do método construtor de cópia
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}

		try
		{
			Tracinhos t1 = new Tracinhos(2);
			Tracinhos t2 = (Tracinhos) t1.clone();

			if(t1.equals(t2))
				System.out.println("Sao iguais");

			t2.desvele(0, 'A');

			if(!t1.equals(t2))
				System.out.println("Sao diferentes");

			//Teste do método de clone
		}
		catch(Exception erro)
		{
			System.out.println(erro.getMessage());
		}
	}
}
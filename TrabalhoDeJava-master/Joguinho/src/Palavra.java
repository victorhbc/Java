class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String txt) throws Exception
    {
        if (txt == null || txt.equals(""))
            throw new Exception ("Tentativa de criar palavra a partir do nada");

        this.texto = txt;
    }

    public int getQuantidadeDaLetra (char ltr)
    {
    	int quantidade = 0;

    	for (int i = 0; i < this.texto.length(); i++)
    	{
    		if (this.texto.charAt(i) == ltr)
    		{
    			quantidade++;
    		}
    	}

    	return quantidade;

        // percorre o String this.texto, conta e retorna
        // quantas letras iguais a ltr existem nele
    }

    public int getPosicaoDeOcorrenciaDaLetra (int ord, char ltr) throws Exception
    {
    	int[] posicoes = new int[this.texto.length()];

    	int j = 0;

		for (int i = 0; i < this.texto.length(); i++)
		{
    		if (this.texto.charAt(i) == ltr)
    		{
    			posicoes[j] = i;
    		    j++;
			}
		}
    	
        if(posicoes.length == 0)
    		throw new Exception ("Letra nao encontrada!");

    	return posicoes[ord];

        // se ord==0, retorna a posicao em que ocorre
        // a primeira aparicao de ltr em this.texto;
        // se ord==1, retorna a posicao em que ocorre
        // a segunda aparicao de ltr em this.texto.
        // se ord==2, retorna a posicao em que ocorre
        // a terceira aparicao de ltr em this.texto;
        // e assim por diante.
        // lan�ar excecao caso nao encontre
        // a ltr procurada.
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    public boolean equals (Object obj)
    {
    if(this == obj)
        return true;
        
    if(obj == null)
        return false;
        
    if(this.getClass() != obj.getClass())
        return false;
    
    Palavra palavra = (Palavra) obj;

    if(this.texto.length() != palavra.texto.length())
        return false;

    for(int i=0; i<this.texto.length(); i++)
    {
        if(this.texto.charAt(i) != palavra.texto.charAt(i))
        {
            return false;
        }
    }

    return true;
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
    }

    public int hashCode ()
    {
        int ret = 1;
        ret = ret * 2 + texto.hashCode();

        return ret < 0 ? -ret : ret;
    }

    public int compareTo (Palavra p)
    {
        return this.texto.compareTo (p.texto);
    }
}
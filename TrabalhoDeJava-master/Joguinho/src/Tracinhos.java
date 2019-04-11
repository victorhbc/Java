class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
        if (qtd<=0)
            throw new Exception ("Tentativa de criar palavra com quantidade de letras invalida!");

        this.texto = new char [qtd];

        for (int i=0; i<qtd; i++)
            this.texto[i] = '_';
    }

    public void desvele (int pos, char ltr) throws Exception
    {
        if (pos<0 || pos>=texto.length)
            throw new Exception ("Tentativa de substituir letra em posicao inexistente!");

        this.texto[pos] = ltr;
    }

    public boolean isComTracinhosAinda()
    {
        for(char percorre: this.texto) //variavel percorre o texto
        {
            if (percorre == '_') //verificar underlines
                return true; //caso haja underline, retorne true
        }
        return false;
    }

    public String toString ()
    {
        String saida = "";
        int i;

        for (i=0; i<this.texto.length-1; i++)
            saida = saida + this.texto[i] + ' ';

        saida = saida + this.texto[i];

        return saida;
    }

    public boolean equals (Tracinhos obj)
    {
        if(this == obj)
            return true;

        if(obj==null)
            return false;

        if(this.getClass() !=obj.getClass())
            return false;

        Tracinhos tracinho = (Tracinhos)obj;

        if(this.texto.length != tracinho.texto.length)
            return false;

        for(int i=0; i<this.texto.length; i++)
        {
            if(this.texto[i] != tracinho.texto[i])
                return false;
        }

            return true;
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
    }

    public int hashCode ()
    {
        int ret = 1;
        for(char c : this.texto){//sintaxe que serve apenas caso o vetor esteja cheio
        ret = ret * 2 + new Character(c).hashCode();
        }
        return ret < 0 ? -ret : ret;
        // calcular e retornar o hashcode de this
    }

    public Tracinhos (Tracinhos t) throws Exception
    { 
        this.texto = new char[t.texto.length];
    
        for( int i = 0; i < t.texto.length;i++)
        {
        this.texto[i] = t.texto[i];
        }
        
        // instanciar this.texto um vetor com o mesmo tamanho de t.texto
        // e copilar o conteudo de t.texto para this.texto
    }

    public Object clone ()
    {
        Tracinhos ret = null;
        try {
            ret = new Tracinhos(this);
        }
        catch(Exception erro)
        {}
        return ret;
        // retornar uma copia de this
    }
}
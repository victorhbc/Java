public class BancoDePalavras
{
    private String banco [] = {"JAVA",
                               "CLASSE",
                               "OBJETO",
                               "INSTANCIA",
                               "PUBLICO",
                               "PRIVATIVO",
                               "METODO",
                               "CONSTRUTOR",
                               "SETTER",
                               "GETTER",
                               "LUZ",
                               "PRAZER"};

    public Palavra getPalavraSorteada ()
    {
        Palavra palavra = null;

        try
        {
            palavra = new Palavra (this.banco [(int)(Math.random() * this.banco.length)]);
        }
        catch (Exception e)
        {}

        return palavra;
    }

    public String toString ()
    {
        return ("Palavra sorteada : " + getPalavraSorteada());
    }

    public boolean equals (Object obj)
    {
    if(this == obj)
        return true;
            
        if(obj == null)
            return false;
            
        if(this.getClass() != obj.getClass())
            return false;
        
        BancoDePalavras palavra = (BancoDePalavras)obj;

        for (int i = 0; i < this.banco.length; i++)
        {
          if (this.banco[i] != palavra.banco[i])
            return false;
        }
        
        return true;

        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
    }

    public int hashCode ()
    {
        int ret = 1;
        ret = ret * 2 + banco.hashCode();

        return ret < 0 ? -ret : ret;
        // calcular e retornar o hashcode de this
    }
}
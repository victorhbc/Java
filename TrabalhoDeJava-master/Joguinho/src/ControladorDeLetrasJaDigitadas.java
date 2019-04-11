class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String jaForam;

    public ControladorDeLetrasJaDigitadas ()
    {
        this.jaForam="";
    }

    public boolean isJaDigitada (char ltr)
    {
        for (int i = 0; i < jaForam.length(); i++) {
            if (this.jaForam.charAt(i) == ltr)
                return true;
        }

        return false;

        // percorrer o String jaForam e verificar se o mesmo
        // possui a letra ltr, retornando true em caso afirmativo
        // ou false em caso negativo

    }

    public void registreUmaLetra (char ltr) throws Exception
    {
        if (this.isJaDigitada (ltr))
            throw new Exception ("Tentativa de registra letra ja registrada!");

        this.jaForam = this.jaForam+ltr;
    }

    public String toString ()
    {
        if (this.jaForam.compareTo ("") == 0)
            return "";

        String saida = "";
        int i;

        for (i=0; i<this.jaForam.length()-1; i++)
            saida = saida + this.jaForam.charAt (i) + ", ";

        saida = saida + this.jaForam.charAt (i);

        return saida;
    }

    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        ControladorDeLetrasJaDigitadas controlador = (ControladorDeLetrasJaDigitadas)obj;
        if (!this.jaForam.equals(controlador.jaForam))
            return false;

        return true; 

        // verificar se this e obj s�o iguais

    }

    public int hashCode ()
    {
        int ret = 1; 

        ret = ret * 2 + this.jaForam.hashCode();/* NESSE CASO USAR O THIS? */

        return ret;

        // calcular e retornar o hashcode de this

    }

    public ControladorDeLetrasJaDigitadas (ControladorDeLetrasJaDigitadas c) throws Exception // construtor de c�pia
    {
        if(c == null)
            throw new Exception("Modelo Ausente");
        
        this.jaForam = c.jaForam;

        // copiar c.jaForam em this.jaForam
    
    }

    public Object clone ()
    {
        ControladorDeLetrasJaDigitadas ret = null;

        try {
            ret = new ControladorDeLetrasJaDigitadas(this);
        } catch (Exception e) {}

        return ret;

        // retornar uma copia de this

    }
}
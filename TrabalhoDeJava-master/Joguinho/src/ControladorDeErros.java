class ControladorDeErros implements Cloneable
{
    private int qMax, qErr=0;
    private static final String INVALIDO = "Limite atingido"; 

    public ControladorDeErros (int qm) throws Exception
    {
        if (qm<=0)
            throw new Exception ("Tentativa de criar um controlador de erros que admite quantidade maxima de erros negativa!");

        this.qMax = qm;
    }

    public void registreUmErro () throws Exception
    {
        if (this.qErr == this.qMax) 
            throw new Exception(INVALIDO);
        else
            this.qErr++;
        
        // verifica se this.qErr ja � igual a this.qMax,
        // lan�ando excecao em caso positivo ou
        // incrementando this.qErr em caso negativo

    }

    public boolean isComMaximoDeErrosAtingido  ()
    {
        return this.qErr == this.qMax;
    }

    public String toString ()
    {
        return this.qErr + "/" + this.qMax;
    }

    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (this.getClass() != obj.getClass())
            return false;

        ControladorDeErros controlador = (ControladorDeErros)obj;
        if(this.qErr != controlador.qErr || this.qMax != controlador.qMax)
            return false;

        return true;
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
    }

    public int hashCode ()
    {
        int ret = 1;

        ret = ret * 2 + new Integer(this.qErr).hashCode();
        ret = ret * 2 + new Integer(this.qMax).hashCode();

        return ret < 0 ? -ret : ret;

        // calcular e retornar o hashcode de this

    }

    public ControladorDeErros (ControladorDeErros c) throws Exception
    {
        if (c == null) 
            throw new Exception("Modelo ausente");
        
        this.qErr = c.qErr;
        this.qMax = c.qMax;

        // copiar c.qMax e c.qErr, respectivamente em, this.qMax e this.qErr

    }

    public Object clone ()
    {
        ControladorDeErros ret = null;

        try {
            ret = new ControladorDeErros(this);
        } catch (Exception e) {}

        return ret;
        
        // returnar uma c�pia de this

    }
}
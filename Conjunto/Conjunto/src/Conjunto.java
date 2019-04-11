import java.lang.reflect.*;

public class Conjunto <MeuParametro>{
    private MeuParametro[] elem;
    private int tamanho = 0;
    public Conjunto(int tamanho) throws Exception{
        if(tamanho <= 0)
            throw new Exception("Capacidade inválida");
        
        this.elem = (MeuParametro[])new Object[tamanho];
    }
    
    private int ondeEsta (MeuParametro param){
        for (int i = 0; i < this.tamanho; i++) {
            if (param.equals(this.elem[i]))
                return i;
        }
        return -1;
    }

    public boolean tem(MeuParametro param){
        return this.ondeEsta(param) != -1; // se for diferente retorna true, se for igual retorna false
    }

    private MeuParametro meuCloneDeConjunto(MeuParametro param){
        MeuParametro ret = null;
        try {
            Class<?> classe = param.getClass();
            Method metodo = classe.getMethod("clone", (Class<?>[])null);
            ret = (MeuParametro)metodo.invoke(param, (Object[])null);
        } catch (Exception e) {  }
        return ret;
    }

    public void inclua(MeuParametro param) throws Exception{
        if(param == null)
            throw new Exception("Falta o que incluir");

        if(this.tamanho == this.elem.length)
            throw new Exception("Não cabe");

        if(this.tem(param))
            throw new Exception("Elemento Repetido");
        
        if(param instanceof Cloneable){
            this.elem[this.tamanho] = (MeuParametro) param.clone();
        }else
            this.elem[this.tamanho] = param;

        this.tamanho++;
    }

    public void exclua (MeuParametro param){
        //fazer esse método
        //Exceção em caso de nulo
    }

    public Conjunto<MeuParametro> intersecao (Conjunto<MeuParametro> conj) throws Exception{
        Conjunto<MeuParametro> ret = new Conjunto<MeuParametro>(this.tamanho < conj.tamanho ? this.tamanho : conj.tamanho); // o tamanho do conjunto da intersecao é o tamanho do menor
        for (int i = 0; i < this.tamanho; i++) {
            if (conj.tem(this.elem[i]))
                ret.inclua(this.elem[i]);
        }
        return ret;
    }

    // Fazer
    public Conjunto<MeuParametro> uniao (Conjunto<MeuParametro> conj) throws Exception{
        Conjunto<MeuParametro> ret = new Conjunto<MeuParametro>(this.tamanho + conj.tamanho);
        
        return ret;
    }

    // Fazer
    public Conjunto<MeuParametro> Menos (Conjunto<MeuParametro> conj) throws Exception{
        Conjunto<MeuParametro> ret = new Conjunto<MeuParametro>(this.tamanho); 

        return ret;
    }

    // Fazer
    public Conjunto<MeuParametro> contem (Conjunto<MeuParametro> conj) throws Exception{
        Conjunto<MeuParametro> ret = new Conjunto<MeuParametro>(this.tamanho); 

        return ret;
    }

    // Fazer
    public Conjunto<MeuParametro> estaContido (Conjunto<MeuParametro> conj) throws Exception{
        Conjunto<MeuParametro> ret = new Conjunto<MeuParametro>(this.tamanho); 

        return ret;
    }
}
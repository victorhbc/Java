import java.lang.reflect.*;

public class Conjunto<classeParametro> implements Cloneable, Comparable<Conjunto<classeParametro>> {
    private classeParametro [] elementos;
    private int tamanho = 0;

    // object aceita qualquer valor, por isso, apos criar um object com a capacidade passada deve se fazer o cast para o tipo que desejamos
    public Conjunto(int capacidade)throws Exception{
        if(capacidade <= 0)
            throw new Exception("Capacidade invalida");

        this.elementos = (classeParametro[]) new Object[capacidade];
    }

    // por estar lidando com classe como parametro, deve se usar o equals
    private int ondeEsta(classeParametro valor){
        for(int i = 0; i < this.tamanho; i++){
            if(valor.equals(elementos[i]))
                return i;
        }

        return -1;
    }

    // é verificado se o valor existe atraves do metodo ondeEsta, retornando true se for diferente de -1
    public boolean possuiValor(classeParametro valor){
        return this.ondeEsta(valor) != -1;
    }

    // como nao se sabe a classePassada como parametro é usado esse método quando possuir alguma interface implementada
    private classeParametro meuClone(classeParametro valor){
        classeParametro retorno = null;
        try{
            Class<?> classe = valor.getClass();
            Method metodo = classe.getMethod("clone", (Class<?>[])null);

            retorno = (classeParametro) metodo.invoke(valor,(Object[])null);
        }catch(Exception erro){

        }

        return retorno;
    }

    // deve se fazer as verificações necessárias em um vetor e apos isso saber se o valor possui cloneable
    // apos isso é chamar o metodo que adiciona o clone na posição atual do vetor e se não tiver adiciona o valor mesmo
    // depois se incrementa o tamanho
    public void inclua(classeParametro valor)throws Exception{
        if(valor == null)
            throw new Exception ("O valor inserido não pode ser nulo");
        if(possuiValor(valor))
            throw new Exception ("Não se pode inserir valores repetidos em um conjunto");
        if(this.tamanho == this.elementos.length)
            throw new Exception ("Impossivel adicionar novos valores");

        if(valor instanceof Cloneable)
            this.elementos[this.tamanho] = this.meuClone(valor);
        else
            this.elementos[this.tamanho] = valor;

        this.tamanho++;
    }

    // para remover deve se fazer as verificações necessárias
    // apos isso deve se saber onde esta o valor que deseja ser excluido
    // depois disso, esse valor é levado ate o ultimo lugar valido
    // recebe o valor null e seu tamanho é diminuido
    public void exclua(classeParametro valor)throws Exception{
        if(valor == null)
            throw new Exception ("Nenhum valor foi passado para excluir");
        if(!this.possuiValor(valor))
            throw new Exception ("Não existe esse elemento no vetor");

        int posicao = this.ondeEsta(valor);

        for(; posicao<this.tamanho-1; posicao++){
            this.elementos[posicao] = this.elementos[posicao+1];
        }

        this.elementos[posicao] = null;
        this.tamanho--;
    }

    // para realizar a intersecao deve se verificar se o conjunto passado como parametro nao é null
    // o objeto chamante nunca pode ser nulo
    // deve se retornar um vetor do mesmo tipo
    // deve se percorrer o menor tamanho e verificar se o valor existe no objeto chamante
    // se existir deve se incluir no vetor retorno
    public Conjunto<classeParametro> intersecao(Conjunto<classeParametro> conjunto)throws Exception{
        if(conjunto == null)
            throw new Exception ("Vetor comparado é nulo");

        Conjunto<classeParametro> retorno = new Conjunto<classeParametro>(this.tamanho>conjunto.tamanho?conjunto.tamanho:this.tamanho);

        for(int i = 0; i<this.tamanho; i++){
            if(conjunto.possuiValor(this.elementos[i]))
                retorno.inclua(this.elementos[i]);
        }

        return retorno;
    }

    // para fazer a uniao de dois vetores deve se considerar o pior caso, todos sao diferentes
    // apos isso deve se adicionar o vetor inteiro dentro do retorno
    // percorrer o vetor retorno e ver se existe esse elemento comparado, se n tiver, adiciona
    // i vai ate o tamanho do que sera comparado, no caso do this, usa se o this.elementos[i] e vice versa
    public Conjunto<classeParametro> uniao(Conjunto<classeParametro> conjunto) throws Exception{
        if(conjunto == null)
            throw new Exception ("Conjunto comparado é null");

        Conjunto<classeParametro> retorno = new Conjunto<classeParametro>(this.tamanho+conjunto.tamanho);

        for(int i = 0; i < this.tamanho; i++){
            retorno.inclua(this.elementos[i]);
        }

        for(int j = 0; j < conjunto.tamanho; j++){
            if(!retorno.possuiValor(conjunto.elementos[j]))
                retorno.inclua(conjunto.elementos[j]);
        }

        return retorno;
    }

    // metodo que verifica o que tem em this mas n tem em conjunto
    public Conjunto<classeParametro> menos(Conjunto<classeParametro> conjunto)throws Exception{
        if(conjunto == null)
            throw new Exception ("parametro invalido");

        Conjunto<classeParametro> retorno = new Conjunto<classeParametro>(this.tamanho);

            for (int i = 0; i < this.tamanho; i++) {
                if (!conjunto.possuiValor(this.elementos[i]))
                    retorno.inclua(this.elementos[i]);
            }

        return retorno;
    }

    // metodo que verifica se o this contem o conjunto dentro dele
    // caso nao tenha é retornado false
    // é tratado as exceções
    public boolean contido (Conjunto<classeParametro> conjunto)throws Exception{
        if(conjunto == null)
            throw new Exception ("Conjunto ausente para calculo");

        for(int i = 0; i < conjunto.tamanho; i++){
            if(!this.possuiValor(conjunto.elementos[i]))
                return false;
        }

        return true;
    }

//    public Conjunto<classeParametro> estaContido(Conjunto<classeParametro> conjunto)throws Exception{
//        if(conjunto == null)
//            throw new Exception("Conjunto ausente para calculo");
//
//        Conjunto<classeParametro> retorno = new Conjunto<>();
//
//        for(int i = 0; i <; i++){
//            if()
//        }
//    }

    public String toString(){
        String saida = "";

        int i = 0;

        for(; i < elementos.length-1; i++){
            saida = saida + this.elementos[i] + "|";
        }

        saida = saida + this.elementos[i];

        return saida;
    }

    // deve se verificar o elemento do comp e não o comp em si
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;

        Conjunto<classeParametro> comp = (Conjunto<classeParametro>) obj;

        for(int i =0; i < this.tamanho; i++){
            if(!comp.elementos[i].equals(this.elementos[i]))
                return false;
        }

        return true;
    }

    public int hashCode(){
        int retorno = 666;

        for(classeParametro v : this.elementos) {
            retorno = retorno * 397 + v.hashCode();
        }

        return retorno>0?retorno:-retorno;
    }

    public Conjunto(Conjunto<classeParametro> modelo)throws Exception{
        if(modelo == null)
            throw new Exception ("Modelo ausente");

        this.elementos = modelo.elementos;
        this.tamanho = modelo.tamanho;
    }

    public Object clone(){
        Conjunto<classeParametro> retorno = null;
        try{
            retorno = new Conjunto<classeParametro>(this);
        }catch (Exception erro){

        }

        return retorno;
    }

    public int compareTo(Conjunto<classeParametro> obj){
        if(this.tamanho > obj.tamanho)
            return 1;
        if(this.tamanho < obj.tamanho)
            return -1;

        return 0;

    }



}

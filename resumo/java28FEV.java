TIPOS DE VARIÁVEIS                                      CLASSE CORRESPONDENTE (CLASSES WRAPPERS(embrulhadoras))
    INTEIROS
        byte: menor /* byte ret = (byte)12 */  /*8 bits*/                       Byte  
        short: pequeno/* short ret = (short)12 *//*16 bits*/                    Short
        int: aceitável /*32 bits*/                                              Integer
        long: gigante /*64 bits*/                                               Long
    REAIS
        float: tamanho equivalente ao int/*32 bits*//*float f = (float)0.0*/    Float
        double: tamanho equivalente ao long/*64 bits*/                          Double
    VERIFICAÇÃO
        boolean                                                                 Boolean
    CARACTÉRES
         char                                                                   Character

        String não é classe wrapper pq não existe a variável string


PARA INSTACIAR CLASSES CORRESPONDENTE PODE USAR O NEW OU NÃO (opcional)

    Integer i = new Integer(10);
    OU
    Integer i = 10;

    String s = new String("Texto");
    OU 
    String s = "Texto"

MÉTODO toString
    public String toString(){
        return (dia < 10 ? "0" : "") + dia + "/" + (mes < 10 ? "0" : "") + mes + "/" + ano + (ano < 0 ? "AC" : "");
    }

TRATAR EXEÇOES
    Data(int dia, int mes, int ano) throws Exception { //sempre declarar o throws Exception para usar o throw new Exception
        if(!valida(dia, mes, ano))
            throw new Exception("Data inválida");
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    //ambos funcionam
    
    /****************** CONSTANTES ******************/
    //final - constante - se quiser usar na main fazer public
    // se não quiser dar acesso na main fazer ela private
    private static final String DATA_INVALIDA = "Data invalida";
    /****************** END CONSTANTES ******************/
    public void setDia(int dia) throws Exception{
        if (!valida(dia, mes, ano)) {
            throw new Exception(DATA_INVALIDA);
        }
        this.dia = dia;
    }
    
    //encapsulamento é deixar fechado para as antas - private ou aberto para as antas - public de acordo com as politicas definidas

GETTER EM BOOLEAN - troca o get por is, o setter é normal:
    private boolean feriado;

    public boolean isFeriado(){
        return this.feriado
    }

COMPARAR VALORES DE objetos:
    if(obj1.equals(obj2);
    o equals compara o valor apontado

COMPARAR VALORES DE TIPOS PRIMITIVOS: ==

O THIS NUNCA EH NULO PQ SE VOCE ENTRA NO METODO SIGNIFICA QUE ELE NAO E NULO

MÉTODOS A CONSTRUIR NA PROVA OBRIGATÓRIOS: toString, equals, hashCode

COMO SABER SE POE OU NÃO O STATIC NA FUNÇÃO:
    ANALISE SE A FUNÇÃO USA COISAS ALÉM DOS PARAMETROS (EX: THIS)
    SE USAR NÃO POE STATIC 
    SE USAR COLOCA



HASHCODE 
    UM DOS 6 MÉTODOS OBRIGATÓRIOS - FACILITA AS BUSCAS
    SAO NUMEROS NATURAIS

CONSTANTES
    QUANDO VOCÊ DECLARA UMA CONSTANTE VALE A PENA COLOCAR STATIC POIS CADA VEZ QUE VOCÊ USA ELA , COM O FINAL SÓ FAZ CONSULTA DE VALOR
    SE NÃO COLOCAR ELE DECLARA A CONSTANTE TODA VEZ
    PUBLIC SE VC FOR PEGAR O VALOR NA MAIN 
    PRIVATE SE SÓ FOR USAR ESSA CONSTANTE NA CLASSE QUE ESTÁ DECLARANDO ELA 
    SEMPRE COLOCAR O STATIC
    EX: public static final String hey = "hey ohhhh";


3 SITRUAÇÕES QUE NÃO USA MÉTODOS OBRIGATÓRIOS:
    Classes sem atributos (ex: classes que acessam banco de dados, a main) (só com métodos só que sem atributos)
    Classe tiver só atributos estáticos (ex: a classe teclado do Maligno)
    Quando uma classe herda de uma outra e não tem atributos adicionais aqueles que herdou//falta aprender herança

Construtores
    Padrão - construtor sem PARAMETROS
    Cópia - um parametro: recebe um objeto da própria classe
    Construtor normal é o que recebe parametros igual na data

CLONE E CONSTRUTOR DE CÓPIA
    só faz quando tem métodos que alteram artibutos ex: setters, adiante, atrase // Fazer esses métodos quando classe tiver métodos além dos construtores que alteram atributos do this
    //quando esses dois métodos não forem obrigatórios eles serão proibidos 
    no clone precisa de casting, ex: 
        // ControladorDeErros c7 = new ControladorDeErros(6);
        // ControladorDeErros c8 = new ControladorDeErros(c7);

NA PROVA SÓ FAZER GETTERS E SETTERS SE ESTIVER NO ENUNCIADO PQ NÃO SÃO OBRIGATÓRIOS

SÓ PODE COLOCAR PRINTS E DIGITAÇÕES NA MAIN OU EM CLASSES FEITAS ESPECIFICAMENTE PARA PRINTAR OU DIGITAR

QUANDO VOCÊ CRIA OBJETOS ELES SÃO NULOS POREM SE ESTIVER EM UM MÉTODO QUE ELE FOR RETORNO E ELE FOR EXEÇÃO PRECISA COLOCAR ANTES Objeto nome = null

compareTo(): 1 dos métodos obrigatórios porém só é obrigatório raramente , não colóca em classses de estruturas de dados
    COMPARA THIS COM O PARâMETRO RECEBIDO
        SE THIS VEM ANTES DO PARAMETRO (THIS É MENOR QUE O PARAMETRO) RETORNA UM INTEIRPO NEGATIVO
        SE THIS VEM ANTES DO PARAMETRO (THIS É MAIOR QUE O PARAMETRO) RETORNA UM INTEIRPO POSITIVO
        SE THIS VEM ANTES DO PARAMETRO (THIS É IGUAL QUE O PARAMETRO) RETORNA 0  



DECLARAÇÃO DE VETORES:
    int[] vet1 = new int[5]; 
    int[] vet2 = {3,5,7}; // vet[3]

MATRIZ
    int[][] mat1 = new int [2][3];
    int[][] mat2 = {{2,3},{4,7}};

QUANTIDADE DE LINHAS
    vet1.length
    mat1.length

QUANTIDADE DE COLUNAS DA MATRIZ
    mat1[0].length //esse 0 é por causa que ele mede quantas colunas tem em uma linha já existente, é bom usar o 0 pq toda matriz tem a linha 0

FOREACH VALE A PENA USAR SÓ PRA PERCORRER O VETOR PORÉM NÃO GUARDA A POSIÇÃO DO ÍNDICE
    public int hashCode ()
    {
        int ret = 1;
        for(char c : this.texto){//sintaxe que serve apenas caso o vetor esteja cheio
        ret = ret * 2 + new Character(c).hashCode();
        }
        return ret;
        // calcular e retornar o hashcode de this
    }

CLASSES QUE NÃO ALTERAM ATRIBUTOS NÃO POSSUEM CLONE E CONSTRUTOR DE CÓPIAS
    Ex: String e classes wrappers
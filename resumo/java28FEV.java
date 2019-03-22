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
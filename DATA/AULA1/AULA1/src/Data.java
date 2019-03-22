public class Data{
	
	private static final String DATA_INVALIDA = "Data invalida";
	private int dia, mes, ano;

    private static boolean bissexto(int a){
        if(a % 400 == 0) return true;
        if(a % 4 == 0 && a % 100 != 0) return true;
        return false;
    } 

    private static boolean valida(int d, int m, int a){
        if (d < 1 || d > 31) return false;
        if (m < 1 || m > 12) return false;
        if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) return false;
        if (d > 29 && m == 2) return false;
        if (d > 28 && m ==2 && !Data.bissexto(a))return false;
        return true;
    }

    /***************JEITO CERTO***************/
    Data(int dia, int mes, int ano) throws Exception { //sempre declarar o throws Exception para usar o throw new Exception
        if(!Data.valida(dia, mes, ano))
            throw new Exception("Data inválida");
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /************ MÉTODO OBRIGATÓRIO ************/
    public String toString(){
        return (dia < 10 ? "0" : "") + dia + "/" + (mes < 10 ? "0" : "") + mes + "/" + ano + (ano < 0 ? "AC" : "");
    }

    /**
     * @return the dia
     */
    public int getDia() {
        return this.dia;
    }
    /**
     * @param dia the dia to set
     */
    public void setDia(int dia) throws Exception{
        if (!Data.valida(dia, this.mes, this.ano)) {
            throw new Exception(DATA_INVALIDA);
        }
        this.dia = dia;
    }
    /**
     * @return the mes
     */
    public int getMes() {
        return this.mes;
    }
    /**
     * @param mes the mes to set
     */
    public void setMes(int mes) throws Exception{
        if (!Data.valida(this.dia, mes, this.ano)) {
            throw new Exception(DATA_INVALIDA);
        }
        this.mes = mes;
    }
    /**
     * @return the ano
     */
    public int getAno() {
        return this.ano;
    }
    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) throws Exception{
        if (!Data.valida(this.dia, this.mes, ano)) {
            throw new Exception(DATA_INVALIDA);
        }
        this.ano = ano;
    }

    public Data diaSeguinte(){
        int dia, mes, ano;
        Data ret = null;
        try {
            dia = this.dia + 1;
            mes = this.mes;
            ano = this.ano;
            if (valida(dia, mes, ano)){
                ret = new Data(dia, mes, ano); 
            }else{
                dia = 1;
                mes++;
                if (valida(dia, mes, ano)) {
                    ret = new Data(dia, mes, ano);
                } else {
                    mes = 1;
                    ano++;
                    ret = new Data(dia, mes, ano);
                }
            }
            
        } catch (Exception e) {
             
        }
        return ret;
    }
    public Data diaSeguinteMaligno(){
        Data ret = null;

        try {
            if (valida(this.dia + 1, this.mes, this.ano)){
                ret = new Data(this.dia + 1, this.mes, this.ano);
            }else{
                if(valida(1, this.mes + 1, this.ano)){
                    ret = new Data(1, this.mes + 1, this.ano);
                }else{
                    ret = new Data(1, 1, this.ano + 1);
                }
            }
        } catch (Exception e) {
             
        }
        return ret;
    }

    public Data diaAnterior(){//solução conservadora
        int dia, mes, ano;
        Data ret = null;
        try {
            dia = this.dia - 1;
            mes = this.mes;
            ano = this.ano;
            if (valida(dia, mes, ano)){
                ret = new Data(dia, mes, ano); 
            }else{
                mes--;
                if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 11){
                    dia = 31;
                    if (valida(dia, mes, ano)) {
                        ret = new Data(dia, mes, ano);
                    }else{
                        dia = 1;
                        mes = 12;
                        ano--;
                        ret = new Data(dia, mes, ano);
                    }
                }
                if (mes == 4 || mes == 6 || mes == 9 || mes == 12){
                    dia = 30;
                    if (valida(dia, mes, ano)) {
                        ret = new Data(dia, mes, ano);
                    }
                }
                if (mes == 2) {
                    if(bissexto(ano)){
                        dia = 29;
                        ret = new Data(dia, mes, ano);
                    }else{
                        dia = 28;
                        ret = new Data(dia, mes, ano);
                    }
                }

                ret = new Data(dia, mes, ano); 
            }
            
        } catch (Exception e) {
          
        }
        return ret;
    }
    public Data diaAnteriorMaligno(){//solucao ousada
        Data ret = null;
        try {
            ret = new Data (this.dia - 1, this.mes, this.ano);
        } catch (Exception a) {
            try {
                ret = new Data (31, this.mes - 1, this.ano);
            } catch (Exception b) {
                try {
                    ret = new Data(30, this.mes - 1, this.ano);
                } catch (Exception c) {
                    try {
                        ret = new Data(29, this.mes - 1, this.ano);
                    } catch (Exception d) {
                        try {
                            ret = new Data(28, this.mes - 1, this.ano);
                        } catch (Exception e) {
                            try {
                                ret = new Data(1, 12, this.ano - 1);
                            } catch (Exception f) {
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }

    /*******fazendo um equals na mão QUE É OBRIGATÓTRIO FAZER********/

    public boolean equals(Object obj){
        if (this == obj) //comparando se o endereço de memória é igual
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        // if (this.dia != ((Data)obj).dia || this.mes != ((Data)obj).mes || this.ano != ((Data)obj).ano)//tipo entre parentes é cast //nesse caso é só uma convenção pois não da pra fazer converção de classe sem método pra isso
        //     return false;
        Data data = (Data)obj;
        if (this.dia != data.dia || this.mes != data.mes || this.ano != data.ano)//tipo entre parentes é cast //nesse caso é só uma convenção pois não da pra fazer converção de classe sem método pra isso
            return false;
        return true;
    }  

    public int hashCode(){//se o atributo for constante ou nulo 
        int ret = 1;//escolher um numero (POSITIVO) menos 0
        ret = ret * 2 + new Integer(this.dia).hashCode(); // o 2 pode ser um numero primo qualquer a partir do 2            
        ret = ret * 2 + new Integer(this.mes).hashCode();
        ret = ret * 2 + new Integer(this.ano).hashCode();
        //objetos de classes wrappers só chama o hashCode direto, exemplo: se fosse uma String(nome) ficaria ret = ret * 2 + nome.hashCode()
        //fazer antes de criar hashCode de objetos que o construtor deixa ser nulo um if null

        return ret < 0 ? -ret : ret;
    }
    

}
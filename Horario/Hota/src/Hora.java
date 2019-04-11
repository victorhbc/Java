public class Hora{

    public static final String HORA_INVALIDA = "Horário inválido";
    private int horas, minutos, segundos;

    public static boolean valida(int h, int m, int s){
        if (h > 23 || h < 0) {
            return false;
        }
        if (m > 59 || m < 0) {
            return false;
        }
        if (s > 59 || s < 0) {
            return false;
        }
        return true;
    }

    public boolean segSeg(int s){
        if (s > 60)
            return false;
        return true;
    }

    public boolean minMin(int m){
        if (m > 60)
            return false;
        return true;
    }

    Hora(int horas, int minutos, int segundos) throws Exception{
        if (!Hora.valida(horas, minutos, segundos)) {
            throw new Exception(HORA_INVALIDA);
        }
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setHoras(int horas) throws Exception{
        if (!Hora.valida(horas, this.minutos, this.segundos)) {
            throw new Exception(HORA_INVALIDA);
        }
        this.horas = horas;
    }

    public void setMinutos(int minutos) throws Exception{
        if (!Hora.valida(this.horas, minutos, this.segundos)) {
            throw new Exception(HORA_INVALIDA);
        }
        this.minutos = minutos;
    }

    public void setSegundos(int segundos) throws Exception{
        if (!Hora.valida(this.horas, this.minutos, segundos)) {
            throw new Exception(HORA_INVALIDA);
        }
        this.segundos = segundos;
    }

    public Hora adiante(int qtdSegundos) throws Exception {
        Hora h = null;
        try {
            if (qtdSegundos < 0) {
                throw new Exception(HORA_INVALIDA);
            }
            if (Hora.valida(this.horas, this.minutos,qtdSegundos + this.segundos)) {
                h = new Hora(this.horas, this.minutos, this.segundos + qtdSegundos);
            }else{
                int modSeg = (qtdSegundos + this.segundos) % 60; //quantidade de segundos
                int xSeg = (qtdSegundos + this.segundos) / 60; //quantidade de minutos a ser acrescida
                if (Hora.valida(this.horas, this.minutos + xSeg, modSeg)) {
                    h = new Hora(this.horas, this.minutos + xSeg, modSeg);    
                }else{
                    int sumMin = this.minutos + xSeg;
                    int modMin = sumMin % 60;
                    int xMin = sumMin / 60;
                    if (valida(this.horas + xMin, modMin, modSeg)) {
                        h = new Hora(this.horas + xMin, modMin, modSeg);
                    }else{
                        int sumH = this.horas + xMin;
                        int xH = sumH % 24;
                        h = new Hora(xH, modMin, modSeg);
                    }
                }
            }
        } catch (Exception e) {}
        return h;
    }

    public void atrase (int qtdSegundos) throws Exception{
        // fazer
    }

    public String toString (){
        return (horas > 9 ? "" : "0") + horas + ":" + (minutos > 9 ? "" : "0") + minutos + ":" + (segundos > 9 ? "" : "0") + segundos;
    }

    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Hora hora = (Hora)obj;
        if (this.horas != hora.horas || this.minutos != hora.minutos || this.segundos != hora.segundos) return false;
        return true;
    }

    public int hashCode(){
        int ret  = 1;
        ret = ret * 2 + new Integer(this.horas).hashCode();
        ret = ret * 2 + new Integer(this.minutos).hashCode();
        ret = ret * 2 + new Integer(this.segundos).hashCode();
        return ret < 0 ? -ret : ret; 
    }

    // no futuro, quando aprenderem, incluir
    // clone
    // de cópia e compareTo
}
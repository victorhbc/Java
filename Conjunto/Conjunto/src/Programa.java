public class Programa {

    public static void main(String[] args) {
        try { // o tipo a ser incluido só pode ser classes, tipos primitivos não
            Conjunto<String> c1;
            c1 = new Conjunto<String>(12);
            c1.inclua("primeiro");
            c1.inclua("segundo");
            Conjunto<Integer> c2 = new Conjunto<Integer>(5);
            c2.inclua(5);

            Data d = new Data(12, 11, 2010);
            Conjunto<Data> c = new Conjunto<Data>(10);
            c.inclua(d);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
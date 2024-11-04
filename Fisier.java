class Fisier{
    private String nume;
    private String continut;
    private int id;
    private static int contor=0;
    private Fisier versiuneAnterioara;
    private int nr;

    public Fisier(String nume, String continut)
    {
        this.nume=nume;
        this.continut=continut;
        this.id=contor;
        contor++;
    }

    public void salveazaVersiune()
    {
        Fisier f = new Fisier(this.nume+"bak", this.continut);
        this.versiuneAnterioara=f.versiuneAnterioara;
        this.versiuneAnterioara=f;
    }

    public void concateneaza(Fisier f)
    {
        this.salveazaVersiune();
        this.continut=this.continut+f.continut;
        nr++;
    }

    public String toString()
    {
        String sir="";
        if(this.versiuneAnterioara==null)
        {
            return this.id + " " +this.nume+ "["+ this.continut+"]";
        }
        else
        {
            return this.id + " " +this.nume+ "["+ this.continut+"]" +"<" +this.versiuneAnterioara+">";
        }

    }
    public int numarConcatenari()
    {
        return nr;
    }
}

class Main{
    public static void main(String[] args)
    {
        Fisier f1= new Fisier("Alina", "Maria ");
        Fisier f2= new Fisier("Ioana", "Ruset");

        f1.concateneaza(f2);

        System.out.println(f1.numarConcatenari());
        System.out.println(f1);
    }
}
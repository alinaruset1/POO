class Angajat{
    private String nume;
    private int salariu;

    public Angajat(String nume, int salariu)
    {
        this.nume=nume;
        this.salariu=salariu;
    }
    public String toString()
    {
        String sir="";
        sir = sir + "Angajat " + "<"+this.nume+">-<"+this.salariu+">";
        return sir;  
    }
    public int getSalariu()
    {
        return this.salariu;
    }
}

class Firma{
    private String nume_firma;
    private int buget;
    private Angajat[] angajati;
    private int contor=0;

    public Firma(String nume_firma, int buget)
    {
        this.nume_firma=nume_firma;
        this.buget=buget;
        this.angajati = new Angajat[30];
        this.contor=0;
    }

    public boolean adaugaAngajat(Angajat a)
    {
        if(contor>=30)
        {
            return false;
        }
        for(int i=0; i<contor; i++)
        {
            if(angajati[i]==a)
            {
                return false;
            }
        }
        angajati[contor++]=a;
        return true;
    }

    public String toString()
    {
        String sir="";
        sir = sir + this.nume_firma + " ";
        for(int i=0; i<contor; i++)
        {
            sir = sir + angajati[i].toString();
        }
        return sir;
    }

    public int platesteSalarii()
    {
        for(int i=0; i<contor; i++)
        {
        buget=buget-angajati[i].getSalariu();
        }
        return buget;

    }
}

class Main{
    public static void main(String[] args)
    {
        Firma f = new Firma("Alina&Maria", 100000);

        Angajat a1= new Angajat("Mami", 10000);
        Angajat a2= new Angajat("Tati",  8000);
        Angajat a3= new Angajat("Catalin", 5000);

        f.adaugaAngajat(a1);
        f.adaugaAngajat(a2);
        f.adaugaAngajat(a3);
        f.adaugaAngajat(a1);

        System.out.println(f);
        System.out.println(f.platesteSalarii());

    }
}
class Jucator{
    private String nume;
    private int numar;

    public Jucator(String nume, int numar)
    {
        this.nume=nume;
        this.numar=numar;
    }
    public boolean equals(Object o)
    {
        if(o instanceof Jucator)
        {
            Jucator copie = (Jucator) o;
            if(this.numar == copie.numar && this.nume.equals(copie.nume))
            {
                System.out.println("Jucatorii sunt identici.");
                return true;
            }
            System.out.println("Jucatorii sunt diferiti");
        }
        return false;
    }
    public String toString()
    {
        return this.nume + " " + this.numar;
    }

}

class Echipa{
    private Jucator[] titulari;
    private Jucator[] rezerve;

    public Echipa(Jucator[] titulari, Jucator[] rezerve)
    {
        this.titulari=titulari;
        this.rezerve=rezerve;
    }

    public boolean efectueazaSchimbare(Jucator titular, Jucator rezerva)
    {
        int contor_tit=-1;
        int contor_rez=-1;
        for(int i=0; i<titulari.length; i++)
        {
            if(titulari[i].equals(titular))
            {
                contor_tit=i;
                break;
            }
        }
        for(int i=0; i<rezerve.length; i++)
        {
            if(rezerve[i].equals(rezerva))
            {
                contor_rez=i;
                break;
            }
        }
        if(contor_tit !=-1 && contor_rez!=-1)
        {
            titulari[contor_tit]=rezerva;
            rezerve[contor_rez]=titular;
            return true;
        }
        return false;
    }

    public String toString()
    {
        String sir ="";
        sir = sir + "Titulari: ";
        for(int i=0; i<titulari.length; i++)
        {
            sir = sir + titulari[i].toString() + " ";
        }

        sir = sir +"Rezerve: ";
        for(int i=0; i<rezerve.length; i++)
        {
            sir = sir + rezerve[i].toString() + " ";
        }
        return sir;
    }

}

class Main{
    public static void main(String[] args)
    {
        Jucator j1 = new Jucator("Player1", 10);
        Jucator j2 = new Jucator("Player2", 11);
        Jucator j3 = new Jucator("Player3", 12);
        Jucator j4 = new Jucator("Player4", 13);
        Jucator j5 = new Jucator("Player5", 14);

        Jucator r1 = new Jucator("Reserve1", 20);
        Jucator r2 = new Jucator("Reserve2", 21);
        Jucator r3 = new Jucator("Reserve3", 22);
        Jucator r4 = new Jucator("Reserve4", 23);
        Jucator r5 = new Jucator("Reserve5", 24);

        
        Jucator[] titulari = {j1, j2, j3, j4, j5};
        Jucator[] rezerve = {r1, r2, r3, r4, r5};
        Echipa echipa = new Echipa(titulari, rezerve);

        
        System.out.println("Echipa initiala:");
        System.out.println(echipa);


        boolean schimbareReusita = echipa.efectueazaSchimbare(j1, r1);

        
        if (schimbareReusita) {
            System.out.println("\nSchimbare efectuata:");
        } else {
            System.out.println("\nSchimbare esuata.");
        }

        System.out.println(echipa);
    }
    
}
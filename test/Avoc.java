class Avocat{
    private String nume;
    private int numar;
    private String[] titluri;

    public Avocat(String nume)
    {
        this.nume=nume;
        this.titluri= new String[40];
        this.numar=0;
    }

    public void adaugaCaz(String reclamant, String acuzat)
    {
        if(numar<40)
        {
            this.titluri[numar]=reclamant + " vs " + acuzat;
            numar++;
        }
    }

    public Avocat formeazaAlianta(Avocat c)
    {
        if(this.numar+c.numar<40)
        {
        Avocat nou = new Avocat(this.nume+ "-" +c.nume);
        nou.numar=this.numar+c.numar;
        for(int i=0; i<this.numar; i++)
        {
            nou.titluri[i]=this.titluri[i];

        }
        for(int i=0; i<c.numar; i++)
        {
            nou.titluri[i+this.numar]=c.titluri[i];
        }
        return nou;   
    }
        return null;
    }

    public String toString()
        {
            String sir="";
            sir = sir+this.nume+"\n";
            for(int i=0; i<this.numar; i++)
            {
                sir=sir+this.titluri[i]+"\n";
            }
            
            return sir;
        }
    
}

class Main{
    public static void main(String[] args)
    {
        Avocat a1= new Avocat("ali");
        Avocat a2= new Avocat("ale");

        a1.adaugaCaz("r1", "a1");
        a1.adaugaCaz("r2", "a2");

        //System.out.println(c1.toString());

        a2.adaugaCaz("r3", "a3");
        a2.adaugaCaz("r4", "a4");
        a2.adaugaCaz("r5", "a5");

        //System.out.println(c2.toString());

        Avocat a3 = a1.formeazaAlianta(a2);

        System.out.println(a3.toString());
    }
}
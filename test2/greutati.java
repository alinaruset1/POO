abstract class Greutate{

    public Greutate()
    {
       
    }
    abstract public int capacitate();
}

class GreutateSimpla extends Greutate{
    private int greutate;
    public GreutateSimpla(int greutate)
    {
        this.greutate=greutate;
    }
    public int capacitate()
    {
        return this.greutate;
    }
}

class GreutateDubla extends Greutate{
    private Greutate g1,g2;
    public GreutateDubla(Greutate g1, Greutate g2)
    {
        this.g1=g1;
        this.g2=g2;
    }

    public void setGreutate1(Greutate g)
    {
        this.g1=g;
    }

    public void setGreutate2(Greutate g)
    {
        this.g2=g;
    }
    public int capacitate()
    {
        return this.g1.capacitate() + this.g2.capacitate();
    }
}

class GreutateMultipla extends Greutate{
    private Greutate[] greutati;
    private int nrGreutati;
    public GreutateMultipla(Greutate[] greutati)
    {
     this.greutati=greutati;
     this.nrGreutati=greutati.length;   
    }

    public void adaugaGreutate(Greutate g)
    {
        this.greutati[nrGreutati++]=g;
    }

    public int capacitate()
    {
        int suma=0;
        for(int i=0; i<nrGreutati; i++)
        {
            suma=suma+this.greutati[i].capacitate();
        }
        return suma;
    }


}

class ColectieGreutati{
    private Greutate[] greutati;
    private int nr;
    private int maximGreutati;
    public ColectieGreutati(int maximGreutati){
        this.maximGreutati=maximGreutati;
        this.greutati=new Greutate[maximGreutati];
        this.nr=0;
    }

    public void adauga(Greutate g)
    {
        this.greutati[nr++]=g;
    }

    public int getnr()
    {
        return this.nr;
    }

    public double medie()
    {
        int suma=0;
        for(int i=0; i<nr; i++)
        {
            suma=suma+this.greutati[i].capacitate();
        }
        return suma/nr;
    }
}

class Main{
    public static void main(String[] args)
    {
        ColectieGreutati greutati1=new ColectieGreutati(10);
        Greutate greutate1=new GreutateSimpla(9);
        Greutate greutate2=new GreutateSimpla(11);
        Greutate greutate3=new GreutateDubla(greutate1, greutate2);
        Greutate[] greutati4={greutate1,greutate2};
        Greutate greutate4=new GreutateMultipla(greutati4);
        greutati1.adauga(greutate1);
        greutati1.adauga(greutate2);
        greutati1.adauga(greutate4);
        greutati1.adauga(greutate3);
        System.out.println(greutati1.getnr() + " " +greutati1.medie());
    }
}
import java.util.*;

abstract class Autovehicul{
    private String numar_inmatriculare;
    private double greutate;
    public Autovehicul(String numar_inmatriculare, double greutate)
    {
        this.numar_inmatriculare=numar_inmatriculare;
        this.greutate=greutate;
    }
    public String getNumar()
    {
        return this.numar_inmatriculare;
    }
    public double getGreutate()
    {
        return this.greutate;
    }
    public abstract double calculeazaGreutateTotala();
    public abstract String toString();
}

class Autoturism extends Autovehicul{
    private double greutate_pasageri;
    public Autoturism(String numar_inmatriculare, double greutate, double greutate_pasageri)
    {
        super(numar_inmatriculare, greutate);
        this.greutate_pasageri=greutate_pasageri;
    }

    public double calculeazaGreutateTotala()
    {
        return this.greutate_pasageri+ this.getGreutate();
    }

    public String toString()
    {
        String sir="";
        sir=sir+"Numar inmatriculare:"+getNumar()+", Greutate autovehicul:"+this.getGreutate()+", Greutate pasageri: "+greutate_pasageri+"\n";
        return sir;
    }
}

class Camion extends Autovehicul{
    private ArrayList<Autoturism> autoturisme= new ArrayList<Autoturism>();
    private int nr_autoturisme;
    public Camion(String numar_inmatriculare, double greutate)
    {
        super(numar_inmatriculare, greutate);
        this.nr_autoturisme=0;
    }
    
    public void adaugaAutoturism(Autoturism a)
    {
        this.autoturisme.add(a);
        nr_autoturisme++;
    }

    public double calculeazaGreutateTotala()
    {
        double rez= this.getGreutate();
        for(int i=0;i<nr_autoturisme; i++)
        {
            rez= rez+this.autoturisme.get(i).getGreutate();
        }
        return rez;
    }

    public String toString()
    {
        String sir="";
        sir = sir+ "Numar Inmatriculare:"+this.getNumar()+", Greutate:"+this.getGreutate()+"\n";
        for(int i=0; i<nr_autoturisme; i++)
        {
            sir = sir + this.autoturisme.get(i).toString();
        }
        return sir;
    }

}

class Bac{
    private double greutate_maxima;
    private double greutate;
    private ArrayList<Autovehicul> autovehicule = new ArrayList<Autovehicul>();
    public Bac(double greutate_maxima)
    {
        this.greutate_maxima=greutate_maxima;
        this.greutate=0;
    }

    public boolean adaugaAutovehicul(Autovehicul a)
    {
        if(this.greutate+a.calculeazaGreutateTotala()<=this.greutate_maxima)
        {this.autovehicule.add(a);
            this.greutate=this.greutate+a.calculeazaGreutateTotala();
            return true;
        }
        return false;
    }

    public String toString()
    {
        String rezultat="";
        int i=0;
        for(i=0;i<this.autovehicule.size();i++){
            rezultat=rezultat+this.autovehicule.get(i).toString();
        }
        rezultat=rezultat+">";
        return rezultat;
    }


}

class Main{
    public static void main(String[] args)
    {
      Autoturism a1= new Autoturism("MRY", 4000,300);
      Autoturism a2= new Autoturism("MRA", 5000,250);
      Autoturism a3= new Autoturism("MRS", 4500,150);

      Camion c = new Camion("Camion",10000);
      c.adaugaAutoturism(a1);
      c.adaugaAutoturism(a2);

      Bac b= new Bac(20000);
      b.adaugaAutovehicul(c);
      b.adaugaAutovehicul(a3);
      System.out.println(b);
    
    } 
}
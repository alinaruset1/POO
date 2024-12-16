import java.util.*;

abstract class Whiskey{
    private String nume;
    public Whiskey(String nume)
    {
        this.nume=nume;
    }
    

    public abstract double getConcentratieAlcool();
    public abstract double getNrCalorii(double ml);
    public abstract String toString();
    public String getNume()
    {
        return this.nume;
    }

}

class ClassicWhiskey extends Whiskey{
    private double concentratie;
    public ClassicWhiskey(String nume, double concentratie)
    {
        super(nume);
        this.concentratie=concentratie;
    }

    public double getNrCalorii(double ml)
    {
        return concentratie*ml*5;
    }
    public double getConcentratieAlcool(){
        return this.concentratie;
    }

    public String toString()
    {
        String sir="";
        sir=sir+"Nume: " +this.getNume()+"Concentratie alcool: "+concentratie+"%, Calorii pe 100 ml" + this.getNrCalorii(100)+ "kcal";
        return sir;
    }
}

class JackAndHoney extends Whiskey{
    private double concentratie;
    private int  indulcitor;
    public JackAndHoney(String nume, double concentratie, int indulcitor)
    {
        super(nume);
        this.concentratie=concentratie;
        this.indulcitor=indulcitor;
    }

    public double getNrCalorii(double ml)
    {
        return this.concentratie*ml*5+ indulcitor*ml*15;
    }

    public double getConcentratieAlcool()
    {
        return this.concentratie;
    }

    public String toString()
    {
        String sir="";
        sir=sir+"Nume: " +this.getNume()+"Concentratie alcool: "+concentratie+"%, Calorii pe 100 ml:" + this.getNrCalorii(100)+ "kcal "+"Cantitate indulcitor: "+indulcitor+"g";
        return sir;
    }
}

class BlendedWhiskey extends Whiskey{
    private List<Whiskey> whiskeys=new ArrayList<Whiskey>();
    private int nr_bauturi;
    public BlendedWhiskey(String nume)
    {
        super(nume);
        this.nr_bauturi=0;
    }
    public void adaugareBautura(Whiskey w)
    {
        this.whiskeys.add(w);
        nr_bauturi++;
    }

    public double getConcentratieAlcool()
    {
        double suma=0;
        for(int i=0; i<nr_bauturi; i++)
        {
            suma=suma+this.whiskeys.get(i).getConcentratieAlcool();
        }
        return suma/nr_bauturi;
    }

    public double getNrCalorii(double ml)
    {
        double suma=0;
        double kcal=100/this.nr_bauturi;
        for(int i=0; i<nr_bauturi; i++)
        {
            suma=suma+this.whiskeys.get(i).getNrCalorii(kcal);
        }
        return suma;
    }

    public String toString()
    {
        String rezultat="";
        //String rezultat=this.getNume()+"-"+this.getConcentratieAlcool()+"-"+this.getNrCalorii(100)+"-"+"Compozitie:";
        int i=0;
        for(i=0;i<this.whiskeys.size();i++)
        {
            rezultat=rezultat+this.whiskeys.get(i).toString()+"\n";
        }

        return rezultat;
    }
}

class Main{
    public static void main(String[] args) {
        ClassicWhiskey w1= new ClassicWhiskey("W1", 0.15);
        JackAndHoney w2= new JackAndHoney("W2",0.20,10);
        BlendedWhiskey w3= new BlendedWhiskey("W3");
        ClassicWhiskey w4= new ClassicWhiskey("W4", 0.17);
        ClassicWhiskey w5= new ClassicWhiskey("W5", 0.18);
        w3.adaugareBautura(w4);
        w3.adaugareBautura(w5);
        BlendedWhiskey w6= new BlendedWhiskey("W6");
        w6.adaugareBautura(w1);
        w6.adaugareBautura(w2);
        w6.adaugareBautura(w3);
        System.out.println(w6.toString());
        System.out.println(w6.getNrCalorii(150));

    }
}

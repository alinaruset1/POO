import java.util.*;
abstract class Utilizator{
    private String nume;
    public Utilizator(String nume)
    {
        this.nume=nume;
    }
    public String getNume()
    {
        return this.nume;
    }
    public abstract double calculeazaVenit(int nr_minute);
    public abstract String toString();
}

class Subscriber extends Utilizator{
    private int nivel;
    public Subscriber(String nume, int nivel)
    {
        super(nume);
        this.nivel=nivel;
    }
    public double calculeazaVenit(int nr_minute)
    {
        return nr_minute*1.5*this.nivel;
    }
    public String toString()
    {
        String rezultat ="<"+this.getNume()+"-"+nivel;
        return rezultat;
    }

}

class Creator extends Utilizator{
    private List<Subscriber> subscriberi= new ArrayList<Subscriber>();
    public Creator(String nume)
    {
        super(nume);
    }

    public void adaugaSubscriber(Subscriber subscriber)
    {
        subscriberi.add(subscriber);
    }

    public double calculeazaVenit(int nr_minute)
    {
        double rez=0;
        for(int i=0; i<subscriberi.size();i++)
        {
            rez=rez+this.subscriberi.get(i).calculeazaVenit(nr_minute);
        }
        return rez;
    }

    public String toString()
    {
        String rezultat=" "+getNume();
        for(int i=0; i<subscriberi.size(); i++)
        {
            rezultat = rezultat +this.subscriberi.get(i).toString()+" ";
        }
        return rezultat;
    }

}

class Platforma{
    private static final int maxim=1000;
    private Utilizator[] utilizatori;
    private int nr_utilizatori;
    public Platforma()
    {
        this.utilizatori=new Utilizator[maxim];
        this.nr_utilizatori=0;
    }

    public boolean adaugaUtilizator(Utilizator u)
    {
        if(nr_utilizatori<1000)
        {
            utilizatori[nr_utilizatori++]=u;
            return true;
        }
        return false;
    }

    public Utilizator determinaVIP(int nr_minute)
    {
        Utilizator VIP=null;
        double maxVenit=0;
        for(int i=0; i<nr_utilizatori; i++)
        {
            if(utilizatori[i].calculeazaVenit(nr_minute)>maxVenit)
            {
                maxVenit=utilizatori[i].calculeazaVenit(nr_minute);
                VIP=utilizatori[i];
            }
        }
        return VIP;
    }

}

class Main{
    public static void main(String[] args)
    {
        Platforma platforma=new Platforma();
        Subscriber subscriber1=new Subscriber("Alina", 1);
        Subscriber subscriber2=new Subscriber("Mirela", 1);
        Subscriber subscriber3=new Subscriber("Nadira", 2);
        Subscriber subscriber4=new Subscriber("Sabina", 2);
        Subscriber subscriber5=new Subscriber("Roxi", 2);
        Creator creator1=new Creator("Artur");
        Creator creator2=new Creator("Solo");
        creator1.adaugaSubscriber(subscriber1);
        creator1.adaugaSubscriber(subscriber2);
        creator1.adaugaSubscriber(subscriber3);
        platforma.adaugaUtilizator(creator1);
        platforma.adaugaUtilizator(creator2);
        platforma.adaugaUtilizator(subscriber1);
        Utilizator vip=platforma.determinaVIP(30);
        if(vip!=null){
            System.out.println(vip.toString());
        }
    }
}
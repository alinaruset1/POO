import java.util.*;

class DestinatarDuplicat extends Exception{
    public DestinatarDuplicat(String mesaj)
    {
        super(mesaj);
    }
}

abstract class Destinatar{
    private String nume;
    public Destinatar(String nume)
    {
        this.nume=nume;
    }
    public String getNume()
    {
        return this.nume;
    }
    public abstract void receptioneaza(Utilizator u, String s);
    public boolean equals(Object o)
    {
        if(o instanceof Destinatar)
        {
            Destinatar d=(Destinatar)o;
            if(d.nume.equals(this.nume))
            {
                return true;
            }
        }
        return false;
    }
}

class Utilizator extends Destinatar{
    private String jurnal="";
    public Utilizator(String nume)
    {
        super(nume);
    }
    public void trimite(Destinatar d, String s)
    {

        jurnal=jurnal+"Trimis catre:"+d.getNume()+" mesajul "+s+"\n";
        d.receptioneaza(this, s);

    }

    public void receptioneaza(Utilizator expeditor, String mesaj)
    {
        jurnal=jurnal+"Primit de la "+ expeditor.getNume()+" mesajul "+mesaj+"\n";
    }
    public String toString()
    {
        return jurnal;
    }

}

class Grup extends Destinatar{
    List<Destinatar> destinatari = new ArrayList<Destinatar>();

    public Grup(String nume) {
        super(nume);
    }

    public void inscrie(Destinatar d) throws DestinatarDuplicat
    {
        boolean ok=true;
        for(Destinatar i:destinatari)
        {
            if(i.equals(d))
            {
                ok=false;
            }
        }
        if(ok==false)
        {
            throw new DestinatarDuplicat("Destinatar duplicat!");

        }
        destinatari.add(d);
    }

    public void receptioneaza(Utilizator u, String s)
    {
        for(Destinatar d: destinatari)
        {
            if(!d.equals(u))
            {
                d.receptioneaza(u,s);
            }
        }
    }
}

class Main{
    public static void main(String[] args){
    Utilizator u1, u2, u3;
        u1 = new Utilizator("Dan");
        u2 = new Utilizator("Marius");
        u3 = new Utilizator("Alex");
        Grup grup;
        grup = new Grup("Carnivorii");
        try {
            grup.inscrie(u1);
            grup.inscrie(u2);
            grup.inscrie(u3);
            grup.inscrie(u3);
        } catch (DestinatarDuplicat eroare) {
            System.out.println(eroare.getMessage());
        }
        u3.trimite(grup, "Am deschis magazinul");
        u2.trimite(grup, "Vin acuma");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }
}
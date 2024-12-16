import java.util.*;

abstract class Tip{
    public String getTip()
    {
        return "Tip: ";
    }
    public abstract String toString();
}

class Intreg extends Tip{

    private int atribut;
    public Intreg(int atribut)
    {
        this.atribut=atribut;
    }
    public String getTip()
    {
        return super.getTip()+" Intreg";
    }

    public String toString()
    {
        return ""+atribut;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Intreg)
        {
            Intreg i= (Intreg) o;
            if(i.atribut==this.atribut)
            {
                return true;
            }
        }
        return false;
    }

}

class Sir extends Tip
{
    private String atribut;
    public Sir(String atribut)
    {
        this.atribut=atribut;
    }

    public String getTip()
    {
        return super.getTip()+" String";
    }

    public String toString()
    {
        return ""+atribut;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Sir)
        {
            Sir i=(Sir) o;
            if(i.atribut.equals(this.atribut))
            {
                return true;
            }
        }
        return false;
    }
}

class Colectie extends Tip{
    private List<Tip> lista =new ArrayList<Tip>();
    public String getTip()
    {
        return "String";
    }

    public String toString()
    {
        String rez="";
        int x=1;
        Iterator<Tip> i=lista.iterator();
        while(i.hasNext())
        {
            Tip e =i.next();
            rez= rez+ "Elementul "+ x+ ":"+e;
            x=x+1;
        }
        return rez;
    }

    public void adauga(Tip element)
    {
        lista.add(element);
    }

    public boolean equals(Object o)
    {
        if(o instanceof Colectie)
        {
            Colectie noua = (Colectie) o;
            if(noua.lista.size()==this.lista.size())
            {
                for(int i=0; i<this.lista.size(); i++)
                {
                    Tip el1=this.lista.get(i);
                    Tip el2=noua.lista.get(i);
                    if(!el1.equals(el2))
                    {
                        return false;
                    }
                }
                
            }
            return true;
        }
        return false;
    }

}

class Main{
    public static void main(String[] args) {
        Colectie c1= new Colectie();
        Sir s1= new Sir("alina");
        Intreg i1=new Intreg(2);
        Intreg i2=new Intreg(3);
        c1.adauga(s1);
        c1.adauga(i1);
        c1.adauga(i2);

        Colectie c2= new Colectie();
        Sir s2= new Sir("alina");
        Intreg i11=new Intreg(2);
        Intreg i12=new Intreg(3);
        c2.adauga(i11);
        c2.adauga(s2);
        c2.adauga(i12);

        System.out.println(c1.equals(c2));

    }
}




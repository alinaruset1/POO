class Card{
    private String numar;
    private double sold;

    public Card(String numar, double sold)
    {
        this.numar=numar;
        this.sold=sold;
    }

    public boolean equals(Object o)
    {
        if(o instanceof Card)
        {
            Card copie = (Card) o;
            if(this.numar.equals(copie.numar))
            {
                System.out.println("Carduri identice");
                return true;
            }
            System.out.println("Carduri diferite");
        }
        return false;
    }
    public String getNumar()
    {
        return this.numar;
    }
    public String toString()
    {
        String sir="";
        sir = this.numar + " "+ this.sold + "\n";
        return sir;
    }
    public double getSold()
    {
        return this.sold;
    }

}

class Portofel{
    private String proprietar;
    private Card[] carduri;
    private int contor=0;

    public Portofel(String proprietar)
    {
        this.proprietar= proprietar;
        this.carduri = new Card[6];
        this.contor=0;
    }

    public boolean adaugaCard(String numar, double sold)
    {
        if(contor>=6)
        {
            return false;
        }
        Card nou = new Card(numar, sold);
        for(int i=0; i<contor; i++)
        {
            if(nou.equals(carduri[i]))
            {
                return false;
            }
        }    
        carduri[contor++]=nou;
        return true;
    }

    public String toString()
    {
        String sir="";
        sir = sir + this.proprietar;
        for(int i=0; i<contor; i++)
        {
            sir = sir +carduri[i].toString();
        }
        return sir;
    }
    public double suma()
    {
        double suma=0;
        for(int i=0; i<contor; i++)
        {
            suma=suma+carduri[i].getSold();
        }
        return suma;
    }
}

class Main{
    public static void main(String[] args)
    {

    Portofel p= new Portofel("Portofelul meu: \n");
    p.adaugaCard("Alina", 100);
    p.adaugaCard("Maria", 200);
    p.adaugaCard("Mami", 34);
    p.adaugaCard("Alina", 23);

    System.out.println("Suma bani: " +p.suma());

    System.out.println(p);
    }
}
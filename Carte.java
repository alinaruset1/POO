public class Carte{
    private int nrPag;
    public Carte(int nrPag)
    {
        this.nrPag=nrPag;
    }

    public boolean equals(Carte carte2)
    {
        if(carte2 instanceof Carte)
            return (((Carte)carte2).nrPag==nrPag);
        else
            return false;
    }
}

class Main{
public static void main(String[] args)
{
    Carte carte1=new Carte(300);
    Carte carte2= new Carte(300);
    Carte carte3= new Carte(150);

    if(carte1.equals(carte2))
    {
        System.out.println("Cartea 1 si Cartea 2 sunt identice (au acelasi numar de pagini).");
        } else {
            System.out.println("Cartea 1 si Cartea 2 nu sunt identice.");
    }

    if (carte1.equals(carte3)) {
        System.out.println("Cartea 1 si Cartea 3 sunt identice (au acelasi numar de pagini).");
    } else {
        System.out.println("Cartea 1 si Cartea 3 nu sunt identice.");
    }
}
}
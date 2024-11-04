class Figura{
    private double arie;
    public Figura(double arie)
    {
        this.arie=arie;
    }
    public String toString() {
        return "Figura - Arie:" + arie;
    }

    public double getArie()
    {
        return this.arie;
    }

}

class Desen{
    private String titlu;
    private Figura figuri[];
    private int contor;

    public Desen(String titlu)
    {
        this.titlu=titlu;
        figuri = new Figura[1024];
        this.contor=0;
    }

    public boolean adaugaFigura(Figura f)
    {
        if(contor>=1024)
        {
            return false;
        }
        for(int i=0; i<contor;i++)
        {
            if(figuri[i].equals(f))
            {
                return false;
            }
        }
        figuri[contor++]=f;
        return true;
    }

    public String toString()
    {
        String sir="";
        sir = sir + this.titlu + ":" ;
        for(int i=0; i<contor; i++)
        {
            sir = sir + figuri[i].toString() + " ";
        } 
        return sir;
    }

    public double medieArie()
    {
        if(contor==0) return 0;
        double suma=0;
        for(int i=0; i<contor; i++)
        {
            suma =figuri[i].getArie();
        }
        return suma/contor;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Desen desen = new Desen("Desenul Meu  ");

        Figura f1 = new Figura(10.5);
        Figura f2 = new Figura(15.3);
        Figura f3 = new Figura(20.7);

        desen.adaugaFigura(f1);
        desen.adaugaFigura(f2);
        desen.adaugaFigura(f3);
        desen.adaugaFigura(f1); 
        System.out.println(desen);
        System.out.println("Media ariilor: " + desen.medieArie());
    }
}
class Masina{
    private String numar_inmatriculare;
    private int litri;
    public Masina(String numar_inmatriculare, int litri)
    {
        this.numar_inmatriculare=numar_inmatriculare;
        this.litri=litri;
    }
    public int getLitri()
    {
        return this.litri;
    }
    public String toString()
    {
        String sir="";
        sir = sir + this.numar_inmatriculare+"-" + this.litri +"\n";
        return sir;
    }


}

class Benzinarie{
    private int benzina;
    private Masina[] masini;
    private int contor;

    public Benzinarie(int benzina)
    {
        this.benzina=benzina;
        this.contor=0;
        this.masini=new Masina[10];
    }

    public boolean alimenteazaMasina(Masina m)
    {
        if(benzina>=m.getLitri())
        {
            benzina=benzina-m.getLitri();
            return true;
        }
        if(benzina<m.getLitri())
        {
            if(contor<9)
            {
            masini[contor++]=m;
            return true;
            }
            
        }
        return false;

    }

    public String toString()
    {
        String sir="";
        sir = sir+"Coada asteptare:\n";
        for(int i=0; i<contor;i++)
        {
            sir=sir+masini[i].toString();
        }
        return sir;

    }

    public void alimenteazaBenzinarie(int combustibil)
    {
        this.benzina=this.benzina+combustibil;
        for(int i=0; i<contor;i++)
        {
            if(this.benzina<masini[i].getLitri())
            {
                return;
            }
            else 
            {
                this.alimenteazaMasina(masini[i]);
                for(int j=i; j<contor-1; j++)
                {
                    masini[j]=masini[j+1];
                }
                contor--;
                i--;
            }

        }
    }    
}


class Main{
    public static void main(String[] args)
    {
        Benzinarie b= new Benzinarie(10);

        Masina m1= new Masina("MRY", 5);
        Masina m2= new Masina("MRI", 10);
        Masina m3= new Masina("MRP", 15);
        b.alimenteazaMasina(m1);
        b.alimenteazaMasina(m2);
        b.alimenteazaMasina(m3);

        System.out.println(b);

        b.alimenteazaBenzinarie(15);
        System.out.println(b);
    }
}
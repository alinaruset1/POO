class Vocabular{
    private String[] caractere;
    private int contor;

    public Vocabular(String sir)
    {
        this.caractere= new String[1000];
        this.caractere[0]=sir;
        this.contor=1;
    }

    public void adaugaCuvinte(String[] c)
    {
        
        for(int i=0; i<c.length; i++)
        {
            this.caractere[contor]=c[i];
            contor++;
        }
    }
    public int determinaDiferente(Vocabular v)
    {
        int dif=0;
        for(int i=0; i<v.contor; i++)
        {
            boolean ok=false;
            for(int j=0; j<contor; j++)
            {
                if(v.caractere[i].equals(this.caractere[j]))
                {
                    ok=true;
                }
            }
            if(!ok)
            {
                dif++;
            }
        }
        return dif;
    }

    public String toString()
    {
        String sir="";
        for(int i=0; i<this.contor; i++)
        {
            sir =sir+this.caractere[i]+ " ";
        }
        return sir;
    }
}

class Main{
    public static void main(String[] args) {
        {
            Vocabular v1=new Vocabular("A");
            Vocabular v2 = new Vocabular("B");

            String[] s2={"mere", "pere", "banane","wow"};
            String[] s1= {"mere", "pere"};

            
            v1.adaugaCuvinte(s1);
            v2.adaugaCuvinte(s2);
            System.out.println(v1);
            System.out.println(v2);
            v2.determinaDiferente(v1);

            int dif=v1.determinaDiferente(v2);
            System.out.println(dif);
        }
    }
}


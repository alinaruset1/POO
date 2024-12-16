import java.util.*;

interface Statistica{
    public void calculeaza(String[] v);
}

class StatisticaNumarAparitii implements Statistica{
    private List<String> sir;
    private String jurnal="";
    public StatisticaNumarAparitii(List<String> sir)
    {
        this.sir=sir;
    } 

    public void calculeaza(String[] v)
    {
        int contor=0;
        for(String i:v)
        {
            for(String j:sir)
            {
                if(i.equals(j))
                {
                    contor++;
                }
            }
        }
        jurnal=jurnal+"In secventa (";
        for(String i:v)
        {
            jurnal=jurnal+i.toString();
        }
        jurnal=jurnal+") apar "+contor+" siruri din secventa ("+this.sir+")\n";
        
    }

    public String toString()
    {
      return jurnal;
    }
}

class StatisticaNumereReale implements Statistica{
    private String jurnal="";
    public void calculeaza(String[] v)
    {
        int contor=0;
        for(String i:v)
        {
            try
            {
                Double.parseDouble(i);
            }
            catch(NumberFormatException e)
            {
                contor++;
            }
        }
        jurnal=jurnal+"In secventa (";
        for(String i:v)
        {
            jurnal=jurnal+i.toString()+ " ";
        }
        jurnal=jurnal+") apar "+contor+" siruri care nu sunt nr reale\n";
    }

    public String toString()
    {
        return jurnal;
    }

}

class Executor 
{
    private List<Statistica> statistici ;
    public Executor(List<Statistica> statistici)
    {
        this.statistici=statistici;
    }
    public void executa(String[] v)
    {
        for(Statistica s: statistici)
        {
            s.calculeaza(v);
        }
        for(Statistica s:statistici)
        {
            System.out.println(s);
        }
    }

}

class Main{
    public static void main(String[] args) {
        {
            List<String> siruricautate=new ArrayList<String>();
        siruricautate.add("mere");
        siruricautate.add("pere");
        siruricautate.add("banane");
        
        StatisticaNumarAparitii sna=new StatisticaNumarAparitii(siruricautate);
        StatisticaNumereReale snr=new StatisticaNumereReale();

        List<Statistica> s=new ArrayList<Statistica>();
        s.add(sna);
        s.add(snr);

        Executor e=new Executor(s);

        String[] secventa1 = {"Ana", "are", "mere"};
        e.executa(secventa1);

        
        String[] secventa2 = {"Maria", "are", "pere"};
        e.executa(secventa2);
        }
    }
}

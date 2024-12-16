import java.util.ArrayList;
import java.util.List;

abstract class Project implements Risky{
    private String titlu;
    private String obiectiv;
    private long fonduri;
    private Membru manager;
    private List<Membru> membri;


    public Project(String titlu, String obiectiv, long fonduri, Membru manager)
    {
        this.titlu=titlu;
        this.obiectiv=obiectiv;
        this.fonduri=fonduri;
        this.manager=manager;
        this.membri = new ArrayList<>();
    }

    public abstract void addMember(Membru m);

    public List<Membru> getMembri()
    {
        return membri;
    }

    public String getTitlu()
    {
        return this.titlu;
    }
    public long getFonduri()
    {
        return this.fonduri;

    }


}

class Comercial extends Project{
    private String deadline;
    //15 membri
    private long fonduri_marketing;
    private int nr_echipe;
    private int nr_membri;

    public Comercial(String titlu, String obiectiv, long fonduri, Membru manager,String deadline, 
 int nr_echipe, int nr_membri)
    {
        super(titlu,obiectiv,fonduri,manager);
        this.deadline=deadline;
        this.fonduri_marketing=fonduri/2;
        this.nr_echipe=nr_echipe;
        this.nr_membri=nr_membri;
    }

    public void addMember(Membru m)
    {
        if(this.nr_membri<15)
        {
            this.getMembri().add(m);
        }
    }
public double getRisk(){
        return this.nr_echipe*3/this.nr_membri/(this.getFonduri()-this.fonduri_marketing);
    }
    
}
class Militar extends Project{
        private String deadline;
        private String parola;
        private int nr_membri;
        public Militar(String titlu, String obiectiv, long fonduri, Membru manager,String deadline, String parola, int nr_membri)
        {
            super(titlu, obiectiv, fonduri, manager);
            this.deadline=deadline;
            this.nr_membri=nr_membri;
            this.parola=parola;

        }

        public void addMember(Membru m)
        {
            if(this.nr_membri<15)
            {
                this.getMembri().add(m);
            }
        }

        public double getRisk()
        {
            return nr_membri/parola.length()/this.getFonduri();
        }

    }

    class OpenSource extends Project{
        private String mailing_list;
        public OpenSource(String titlu, String obiectiv, long fonduri, Membru manager,String mailing_list)
        {
            super(titlu, obiectiv, fonduri, manager);
            this.mailing_list=mailing_list;

        }
        
        public void addMember(Membru m)
        {
                this.getMembri().add(m);
        }

        public double getRisk()
        {
            return this.getMembri().size()/getFonduri();
        }
    }
class Membru{
    private int varsta;
    private String nume;
    public Membru(String nume, int varsta)
    {
        this.nume=nume;
        this.varsta=varsta;
    }
}

interface Risky{
    public double getRisk();
}


class InvestmentCompany {
    private List<Project> proiecte;

    public InvestmentCompany() {
        this.proiecte = new ArrayList<>();
    }

    public void adaugaProiect(Project proiect) {
        proiecte.add(proiect);
    }

    public Project getInvestitiaOptima() {
        if (proiecte.isEmpty()) {
            return null;
        }
        Project celMaiSigur = proiecte.get(0);
        for (Project proiect : proiecte) {
            if (proiect.getRisk() < celMaiSigur.getRisk()) {
                celMaiSigur = proiect;
            }
        }
        return celMaiSigur;
    }

    public static void main(String[] args) {
        Membru manager1 = new Membru("Alice", 35);
        Membru manager2 = new Membru("Bob", 40);

        Comercial proiectComercial = new Comercial("Proiect Comercial", "Obiectiv Comercial", 500000, manager1, "2025-12-31", 5,2);
        proiectComercial.addMember(new Membru("Charlie", 30));
        proiectComercial.addMember(new Membru("Diana", 28));

        Militar proiectMilitar = new Militar("Proiect Militar", "Obiectiv Militar", 10000, manager2, "2026-06-30", "secure123",2);
        proiectMilitar.addMember(new Membru("Edward", 33));
        proiectMilitar.addMember(new Membru("Fiona", 29));
    
        OpenSource proiectOpenSource = new OpenSource("Proiect Open-Source", "Obiectiv Open-Source", 200000, manager1, "opensource@project.com");
        proiectOpenSource.addMember(new Membru("George", 27));
        proiectOpenSource.addMember(new Membru("Hannah", 31));
    
        InvestmentCompany companie = new InvestmentCompany();
        companie.adaugaProiect(proiectComercial);
        companie.adaugaProiect(proiectMilitar);
        companie.adaugaProiect(proiectOpenSource);

        Project investitieOptima = companie.getInvestitiaOptima();
        System.out.println("Investitia optima: " + ((Project) investitieOptima).getTitlu());
    }
}
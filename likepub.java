class Bautura{
    private String nume_bautura;
    private int pret;
    public Bautura(String nume_bautura, int pret){
        this.nume_bautura=nume_bautura;
        this.pret=pret;
    }

    int get_pret()
    {
        return this.pret;
    }

    String get_nume()
    {
        return this.nume_bautura;
    }

}

class Student{
    private String nume_student;
    private int bani;
    private Bautura[] stomac;
    private int index;
    public Student(String nume_student, int bani)
    {
        this.nume_student=nume_student;
        this.bani=bani;
        this.stomac = new Bautura[10];
        this.index=0;
    }

    public boolean cumparaBautura(Bautura b)
    {
        
        if(this.bani >=b.get_pret() && index<stomac.length)
        {
            bani=bani-b.get_pret();
            stomac[index++]= b;
            return true;
        }
        return false;
    }

    public String toString()
    {
        String sir ="";
        
        sir=sir+ nume_student; 
        sir = sir + ":" ;
        for(int i=0; i<index;i++)
        {
            sir =sir +stomac[i].get_nume() + "->"; 
        }    
        return sir;
    }

    public boolean Dureri()
    {
        int diferit=0;
        for(int i=0; i<index; i++)
        {
            boolean gasit=false;
            for(int j=0; j<i; j++)
            {
                if(stomac[i].get_nume().equals(stomac[j].get_nume()))
                {
                    gasit=true;
                    break;
                }
            }
            if(!gasit) diferit++;
            if(diferit>=3) return true;
        }
        return false;
    }
}

class Main{
    public static void main(String[] args)
    {
        Student s1= new Student("Andrei", 30);
        Bautura b1= new Bautura("Whiskey", 11);
        Bautura b2= new Bautura("Vin", 10);
        Bautura b3= new Bautura("Bere", 5);

        s1.cumparaBautura(b1);
        s1.cumparaBautura(b2);
        s1.cumparaBautura(b3);

        System.out.println(s1);
        System.out.println("Va avea dureri de cap maine? " + s1.Dureri());
    }
}
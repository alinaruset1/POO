public class Patrat{

    private int latura;
    public Patrat()
    {
        this.latura=10;
    }

    public Patrat(int latura)
    {
        this.latura=latura;
    }

    public int calculeazaAria()
    {
        return latura*latura;
    }

    public void tipareste()
    {
        System.out.println("Patrat cu latura " +latura +", Aria: " + calculeazaAria());

    }

}

class Main{
    public static void main(String[] args)
    {
        Patrat p=new Patrat();
        p.tipareste();

        Patrat p2= new Patrat(15);
        p2.tipareste();

        Patrat p3=new Patrat(5);
        p3.tipareste();
    }
}
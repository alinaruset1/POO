import java.util.Date;
import java.util.Random;
class Out extends Exception
{
    public Out(String mesaj)
    {
        super(mesaj);
    }
}

class Corner extends Exception
{
    public Corner(String mesaj)
    {
        super(mesaj);
    }
}

class Gol extends Exception
{
    public Gol(String mesaj)
    {
        super(mesaj);
    }
}
class Minge{
    private int x;
    private int y;
    public Minge(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void suteaza(Generator generator) throws Out,Gol,Corner
    {
        this.x=generator.generateX();
        this.y=generator.generateY();
        if(y==0 || y==50)
        {
            throw new Out("Mingea a iesit la("+x+","+y+")");
        }
        else if((x==0||x==100)&&y>=20&&y<=30)
        {
            throw new Gol("Gol la"+"("+x+","+y+")");
        }
        else if(x==0 || x==100)
        {
            throw new Corner("Corner in punctul("+x+","+y+")");
        }
    }
}

class Generator{
    private Random randomGenerator;
    public Generator(){
        Date now=new Date();
        long sec=now.getTime();
        randomGenerator=new Random(sec);
    }
    public int generateX(){
        int x=randomGenerator.nextInt(101);
        if(x<5){
            x=0;
        }else if(x>95){
            x=100;
        }else{
            x=randomGenerator.nextInt(99)+1;
        }
        return x;
    }
    public int generateY(){
        int y=randomGenerator.nextInt(101);
        if(y<5){
            y=0;
        }else if(y>95){
            y=50;
        }else{
            y=randomGenerator.nextInt(49)+1;
        }
        return y;
    }
}

class Joc{
    private String echipa1;
    private String echipa2;
    private int nr_goluri1;
    private int nr_goluri2;
    private int totalOuturi;
    private int totalCornere;

    public Joc(String echipa1, String echipa2)
    {
        this.echipa1=echipa1;
        this.echipa2=echipa2;
        this.nr_goluri1=0;
        this.nr_goluri2=0;
        this.totalOuturi=0;
        this.totalCornere=0;
    }

    public void simuleaza()
    {
        Minge m=new Minge(50,25);
        Generator generator= new Generator();
        for(int i=0; i<100; i++)
        {
            try{
            System.out.println(echipa1+" - "+echipa2+" : Mingea se afla la coordonatele("+m.getX()+", "+m.getY()+").");
            m.suteaza(generator);
            }
            catch(Out e){
                System.out.println(e.getMessage());
                totalOuturi++;
            }
            catch(Corner e){
                System.out.println(e.getMessage());
                totalCornere++;
                // Mingea se mută în colțul corespunzător
                if(m.getX()==0){
                    m=new Minge(0,(m.getY()<25)?0:50);
                }else{
                    m=new Minge(100,(m.getY()<25)?0:50);
                }
            }
            catch(Gol e)
            {
                System.out.println(e.getMessage());
                if(m.getX()==0){
                    nr_goluri2++;
                }else{
                    nr_goluri1++;
                }
                m=new Minge(50, 25);
            }
        }
    }
    public String toString(){
        String rezultat=echipa1+"-"+echipa2+":"+nr_goluri1+"-"+nr_goluri2+"\n"+
        "Statistici:\n"+
        "Total out-uri:"+totalOuturi+"\n"+
        "Total cornere:"+totalCornere;
        return rezultat;
    }
}

class fotbal{
    public static void main(String[] args){
        Joc joc1=new Joc("Echipa A", "Echipa B");
        Joc joc2=new Joc("Echipa C", "Echipa D");

        System.out.println("Simulam primul joc:");
        joc1.simuleaza();
        System.out.println(joc1);

        System.out.println("\nSimulam al doilea joc:");
        joc2.simuleaza();
        System.out.println(joc2);
    }
}

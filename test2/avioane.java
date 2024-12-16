class Avion{
    private String planeID;

    public Avion(String planeID, int totalEnginePower)
    {
        this.planeID=planeID;
        this.totalEnginePower=totalEnginePower;
    }
    public String getPlaneID()
    {
        return this.planeID;
    }
    private int totalEnginePower;
    public int getTotalEnginePower()
    {
        return this.totalEnginePower;
    }

    public void takeOff()
    {
        System.out.println("PlaneID:"+ this.planeID+" Initiating takeoff procedure - Starting engines - Accelerating down the runway- Taking off- Retracting gear- Takeoff complete");
    }

    public void land()
    {
        System.out.println("PlaneID-"+this.planeID+"Initiating landing procedure - Enabling airbrakes -\r\n" + //
                        "Lowering gear - Contacting runway - Decelerating - Stopping engines - Landing\r\n" + //
                        "complete");
    }

    public void fly()
    {
        System.out.println("PlaneID "+this.planeID+"Flying");
    }

}


class AvionCalatori extends Avion{
    private int maxPassengers;

    public AvionCalatori(String planeID, int totalEnginePower,int maxPassengers)
    {
        super(planeID,totalEnginePower);
        this.maxPassengers=maxPassengers;
    }

    public int getMaxPassengers()
    {
        return this.maxPassengers;
    }

}

class AvionLupta extends Avion{

    public AvionLupta(String planeID, int totalEnginePower)
    {
        super(planeID, totalEnginePower);
    }
    public void launchMissile(){
        System.out.println(this.getPlaneID()+ "- Initiating missile launch procedure - Acquiring target - Launching missile - Breaking away - Missile launch complete");
    }
}

class Mig extends AvionLupta{

    public Mig(String planeID,int totalEnginePower)
    {
        super(planeID, totalEnginePower);
    }
    public void highSpeedGeometry()
    {
        System.out.println("Plane ID:"+this.getPlaneID()+"High speed geometry selected");

    }
    public void normalSpeedGeometry()
    {
        System.out.println("Plane ID:"+this.getPlaneID()+"Normal speed geometry selected");

    }

}

class TomCat extends AvionLupta{
    public TomCat(String planeID, int totalEnginePower)
    {
        super(planeID, totalEnginePower);
    }
    public void refuel()
    {
        System.out.println("PlaneID:"+this.getPlaneID()+"Initiating refueling procedure - Locating refueller - Catching up-Refueling - Refueling complete");
    }
}

class Boeing extends AvionCalatori{
    public Boeing(String planeID,int totalEnginePower,int maxPasenggers){
        super(planeID,totalEnginePower,maxPasenggers);

    }
}
class Concorde extends AvionCalatori{

    public Concorde(String planeID,int totalEnginePower,int maxPasenggers){
        super(planeID,totalEnginePower,maxPasenggers);

    }
    public void goSuperSonic()
    {
        System.out.println("Plane ID:"+this.getPlaneID()+"SuperSonic mode activated");

    }
    public void goSubSonic()
    {
        System.out.println("Plane ID:"+this.getPlaneID()+"SubSonic mode activated");

    }
}

class Main{
    public static void main(String[] args)
{
    Avion av1= new Concorde("Concorde",1000,15);
    Avion av2=new Boeing("Boeing", 2000, 200);
    Avion av3=new Mig("Mig", 1500);
    Avion av4=new TomCat("TomCat", 3500);

    av1.takeOff();
    if(av1 instanceof Concorde)
    {
        ((Concorde) av1).goSubSonic();
    }


    Avion a1= new Mig("MigOne",150);
	Avion a2 = new Concorde("Alina", 1000, 100);
	a1.fly();
	//	a1.launchMissile();// nu merge
	((AvionLupta)a1).launchMissile();
	((Mig)a1).launchMissile();
	//((AvionLupta)a2).launchMissile(); // nu merge
	
	//((TomCat)a1).launchMissile(); //nu merge
	//((AvionCalatori)a1).getmaxPassengers();
	((AvionCalatori)a2).getMaxPassengers();  
}

}




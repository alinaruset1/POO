import java.util.*;
interface CircuitElectric{
    public abstract double rezistentaEchivalenta();
    public abstract double curent(double tensiune);
    public abstract boolean contineSubcircuit(CircuitElectric subcircuit);

}

class Rezistenta implements CircuitElectric {
    private double rezistenta;
    public Rezistenta(double rezistenta)
    {
        this.rezistenta=rezistenta;
    }
    public double rezistentaEchivalenta()
    {
        return this.rezistenta;
    }

    public double curent(double tensiune)
    {
        return tensiune/this.rezistenta;
    }

    public boolean contineSubcircuit(CircuitElectric subcircuit)
    {
        return true;
    }
}

class CircuitSerie implements CircuitElectric{
    private List<CircuitElectric> circuite;
    public CircuitSerie(ArrayList<CircuitElectric> circuite)
    {
        this.circuite=circuite;
    }

    public double rezistentaEchivalenta()
    {
        double suma=0;
        for(CircuitElectric c: circuite)
        {
            suma=suma+c.rezistentaEchivalenta();
        }
        return suma;
    }

    public double curent(double tensiune)
    {
        double suma=0;
        for(CircuitElectric c: circuite)
        {
            suma=suma+c.rezistentaEchivalenta();
        }
        return tensiune/suma;
    }

    public boolean contineSubcircuit(CircuitElectric subcircuit)
    {
        for(CircuitElectric c: circuite)
        {
            if(c.contineSubcircuit(subcircuit))
            {
                return true;
            }

        }
        return false;
    }


}

class CircuitParalel implements CircuitElectric{
    private ArrayList<CircuitElectric> circuite;
    public CircuitParalel(ArrayList<CircuitElectric> circuite)
    {
        this.circuite=circuite;
    }

    public double rezistentaEchivalenta()
    {
        double suma=0;
        for(CircuitElectric c: circuite)
        {
            suma=suma+1/c.rezistentaEchivalenta();
        }
        return suma;
    }

    public double curent(double tensiune)
    {
        double suma=0;
        for(CircuitElectric c: circuite)
        {
            suma=suma+1/c.rezistentaEchivalenta();
        }
        return tensiune/suma;
    }

    public boolean contineSubcircuit(CircuitElectric subcircuit)
    {
        for(CircuitElectric c: circuite)
        {
            if(c.contineSubcircuit(subcircuit))
            {
                return true;
            }

        }
        return false;
    }

}
class Main {
    public static void main(String[] args) {
        // Create individual resistors
        Rezistenta R1 = new Rezistenta(5); // 5 Ohms
        Rezistenta R2 = new Rezistenta(10); // 10 Ohms
        Rezistenta R3 = new Rezistenta(15); // 15 Ohms

        // Create a series circuit: R1 + R2
        ArrayList<CircuitElectric> c= new ArrayList<CircuitElectric>();
        c.add(R1);
        c.add(R2);
        CircuitSerie serie = new CircuitSerie(c);

        // Create a parallel circuit: (R1 + R2) || R3

        ArrayList<CircuitElectric> d= new ArrayList<CircuitElectric>();
        d.add(serie);
        d.add(R3);
        CircuitParalel paralel = new CircuitParalel(d);

        // Supply voltage
        double voltage = 9.0; // 9 Volts

        // Calculate equivalent resistance and current
        double rezistentaEchivalenta = paralel.rezistentaEchivalenta();
        double current = paralel.curent(voltage);

        // Output results
        System.out.println("Rezistenta echivalenta: " + rezistentaEchivalenta + " Ohmi");
        System.out.println("Curentul total: " + current + " Amperi");
    }
}

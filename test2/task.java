import java.util.*;
abstract class Task{
    private String nume;
    public Task(String nume)
    {
        this.nume=nume;
    }
    public String getNume()
    {
        return this.nume;
    }
    public abstract boolean execute(double secunde);
    public abstract String toString();

}

class SimpleTask extends Task{
    private double timp;
    public SimpleTask(String nume, double timp)
    {
        super(nume);
        this.timp=timp;
    }

    public boolean execute(double secunde)
    {
        if(timp!=0)
        {
            timp=timp-secunde;
            return false;
        }
        return true;
    }

    public String toString()
    {
        String sir="";
        sir= sir+"Nume: "+getNume()+" Time:" + this.timp+"\n";
        return sir;
    }

}

class ComposedTask extends Task{
    private List<SimpleTask> taskuri= new ArrayList<SimpleTask>();
    public ComposedTask(String nume, List<SimpleTask> taskuri)
    {
        super(nume);
        this.taskuri=taskuri;
    }

    public boolean execute(double secunde)
    {
        double numar=secunde/taskuri.size();
        for(SimpleTask i:taskuri)
        {
            if(i.execute(numar)==false)
            {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        String sir="Nume:"+getNume()+" Content:\n";
        for(SimpleTask i: taskuri)
        {
            sir= sir+ i.toString();
        }
        return sir;
    }
}

class Procesor{
    private List<Task> taskuri= new ArrayList<Task>();
    public Procesor(List<Task> taskuri)
    {
        this.taskuri=taskuri;
    }

    public void finishAllTasks()
    {
        boolean rezultat=true;
        do {    
            rezultat=true;
            for(Task i:taskuri){
                if(i.execute(5)==false){
                    rezultat=false;
                }
            }
        } while (rezultat==false);
    }

    public String toString()
    {
        String sir="Procesor: \n";
        for(Task i:taskuri)
        {
            sir=sir+ i.toString();
        }
        return sir;
    }
}

class Main{
    public static void main(String[] args) {
        {
            SimpleTask s1= new SimpleTask("S1",10 );
            SimpleTask s2= new SimpleTask("S2",5 );
            List<SimpleTask> simpleTaskuri=new ArrayList<SimpleTask>();
            simpleTaskuri.add(s1);
            simpleTaskuri.add(s2);
            ComposedTask c= new ComposedTask("CT",simpleTaskuri);
            List<Task> taskuri= new ArrayList<Task>();
            taskuri.add(c);
            Procesor p = new Procesor(taskuri);
            System.out.println(p);

            p.finishAllTasks();
            System.out.println(p);
        }
    }
}
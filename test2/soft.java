import java.util.*;

class WrongQualityIndicatorException extends RuntimeException{
    public WrongQualityIndicatorException(String mesaj)
    {
        super(mesaj);
    }
}

class WrongComponentComplexityIndicatorException extends Exception{
    public WrongComponentComplexityIndicatorException(String mesaj)
    {
        super(mesaj);
    }
}

interface Test{
    int getNumarTeste();
}


abstract class Teste implements Test{
    private String nume;
    private int indicator;
    public Teste(String nume, int indicator)
    {
        this.nume=nume;
        this.indicator=indicator;
    }
    public String getNume()
    {
        return this.nume;
    }
    public abstract String toString();

    public int getIndicator()
    {
        return this.indicator;
    }
}

class IntegrationTest extends Teste{
    public IntegrationTest(String nume, int indicator) {
        super(nume, indicator);
        if (indicator > 10 || indicator < 1) {
            throw new WrongQualityIndicatorException("Nu e corect indicatorul.");
        }
    }    

    public int getNumarTeste()
    {
        return 1;
    }

    public String toString()
    {
        return "IntegrationTest "+this.getNume()+" Quality indicator "+this.getIndicator();
    }

}

class ComponentTest extends Teste {
    private int complexitate;
    public ComponentTest(String nume, int indicator, int complexitate) throws WrongComponentComplexityIndicatorException
    {
        super(nume, indicator);
        if(indicator<1 || indicator>10)
        {
            throw new WrongQualityIndicatorException("Nu e indicator corect ");
        
        }   
        if(complexitate<0)
        {
            throw new WrongComponentComplexityIndicatorException("Nu e complexitate buna");

        }
        this.complexitate=complexitate;
    }

    public int getNumarTeste()
    {
        return 1;
    }

    public String toString()
    {
        return "ComponentTest "+ this.getNume()+", Quality indicator="+this.getIndicator()+" Component Complexity: "+complexitate;
    }


}

class TestSuite implements Test{
    private List<Teste> teste;
    private int nrTeste;
    public TestSuite(ArrayList<Teste> teste)
    {
        this.teste=teste;
        
    }

    public boolean addNewIntegrationTest(String name, int indicator) {
        try {
            IntegrationTest test = new IntegrationTest(name, indicator);
            teste.add(test);
            return true;
        } catch (WrongQualityIndicatorException exception) {
            return false;
        }
    }

    public boolean addNewComponentTest(String name, int indicator, int complexity)
            throws WrongComponentComplexityIndicatorException {
        try {
            ComponentTest test = new ComponentTest(name, indicator, complexity);
            teste.add(test);
            return true;
        } catch (WrongQualityIndicatorException exception) {
            return false;
        }
    }

    public int getNumarTeste()
    {
        return this.teste.size();
    }

    public String toString() {
        String text = "TestSuite \n";
        int i;
        for (Teste t: teste)
        {
            text=text+t.toString()+"\n";
        }
        return text;
    }


}

class Main{
    public static void main(String[] args)
    {
        TestSuite testSuite = new TestSuite(new ArrayList<Teste>());
        try{
        testSuite.addNewIntegrationTest("Test1", 4);
        testSuite.addNewIntegrationTest("Test2", 7);
        testSuite.addNewComponentTest("Test3", 2, -2); // Va afișa eroare
        }
        catch(WrongComponentComplexityIndicatorException e)
        {
        System.out.println("Exceptie detectata:"+ e.getMessage());

        }
        try {
            testSuite.addNewComponentTest("Test4", 10, 1);
        } catch (WrongComponentComplexityIndicatorException e) {

        }
        System.out.println(testSuite);
        System.out.println("Numar total de teste: " + testSuite.getNumarTeste());

    }
}
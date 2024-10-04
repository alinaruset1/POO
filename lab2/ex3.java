class Motorex3{
    private int capacitate;
    public Motorex3(int c)
    {
	capacitate=c;
    }
    public void setCapacitate(int c)
    {
	capacitate=c;
    }

    public void tipareste()
    {
	System.out.println("Motor de capacitate " + capacitate);
    }

    public static void main(String[] args)
    {
	Motorex3 m1, m2;
	m1=new Motorex3(5);
	m2=m1;
	m2.setCapacitate(10);
	m1.tipareste();
    }
}

class complex{
    private double real;
    private double imaginar;
    private static int counter=0;
    public complex(double real, double imaginar)
    {
	this.real=real;
	this.imaginar=imaginar;
    }
    public double modul(){
	return Math.sqrt(real*real + imaginar*imaginar);
    }
    public void tipareste()
    {
	System.out.println(real+ " +i*"+imaginar);
	counter++;
    }
    public complex aduna(complex c)
    {
	double realnou=this.real + c.real;
	double imagnou=this.imaginar + c.imaginar;
	return new complex(realnou, imagnou);
    }
    public static int getContor()
    {
	return counter;
    }
}
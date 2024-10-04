class main{
    public static void main(String[] args)
    {
	complex c1= new complex(3.0, 4.0);
	complex c2= new complex(1.0, 2.0);

	c1.tipareste();
	c2.tipareste();

	System.out.println("Modulul lui c1: " + c1.modul());

	complex sum=c1.aduna(c2);
	System.out.println("suma dintre c1 si c2: ");
	sum.tipareste();

	System.out.println("numar de afisari: "+complex.getContor());
    }
}

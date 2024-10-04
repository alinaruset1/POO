class main{

    public static void main(String[] args)
    {
	sertar s1=new sertar(40,50,10);
	sertar s2=new sertar(30,45,12);
	birou birou = new birou(100,60,75,s1,s2);
	birou.tipareste();
    }
}

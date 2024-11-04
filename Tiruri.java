class Remorca {
    private int cantitate;
    private String inmatriculare;
    private static int cantitateAnterioara = 9;

    public Remorca(int cantitate, String inmatriculare) {
        this.cantitate = cantitate;
        this.inmatriculare = inmatriculare;
        cantitateAnterioara = cantitate;
    }

    public Remorca(String inmatriculare) {
        cantitateAnterioara = cantitateAnterioara + 1;
        this.cantitate = cantitateAnterioara;
        this.inmatriculare = inmatriculare;
    }

    public int getCantitate() {
        return this.cantitate;
    }

    public String getInmatriculare() {
        return this.inmatriculare;
    }

    public String toString() {
        return "R(" + this.inmatriculare + "," + this.cantitate + ")";
    }
}

class Tir {
    private Remorca [] remorci;
    private int index;
    private int cantitate;

    public Tir() {
        this.remorci = new Remorca[5];
        this.index = 0;
        this.cantitate = 0;
    }

    public boolean adaugaRemorca(int cantitate, String inmatriculare) {
        if(this.index == 5) {
            return false;
        }
        Remorca newRemorca = new Remorca(cantitate, inmatriculare);
        this.remorci[index] = newRemorca;
        this.index = this.index + 1;
        this.cantitate = this.cantitate + cantitate;
        return true;
    }

    public boolean adaugaRemorca(Remorca remorca) {
        if(this.index == 5) {
            return false;
        }
        this.remorci[index] = remorca ;
        this.index = this.index + 1;
        this.cantitate = this.cantitate + remorca.getCantitate();
        return true;
    }

    public Remorca stergeRemorca(String inmatriculare) {
        int i, j;
        Remorca aux;
        for(i = 0; i < this.index; i++) {
            if(this.remorci[i].getInmatriculare().equals(inmatriculare)) {
                aux = this.remorci[i];
                for(j = i; j < this.index - 1; j++) {
                    this.remorci[j] = this.remorci[j + 1];
                }
                this.index = this.index - 1;
                i--;
                this.cantitate = this.cantitate - aux.getCantitate();
                return aux;
            }
        }
        return null;
    }

    public boolean equals(Object o) {
        if(o instanceof Tir) {
            Tir copie = (Tir) o;
            if(this.cantitate == copie.cantitate ) {
                System.out.println("Tirurile sunt identice");
                return true;
            }
            System.out.println("Tirurile sunt diferite");
        }
        return false;
    }

    public String toString() {
        System.out.print("T ->");
        int i;
        String text = "";
        for(i = 0; i < this.index - 1; i++) {
            text = text + (" " + this.remorci[i] + " -> ");
        }
        text = text + this.remorci[i];
        return text;
    }
}

class Main {
    public static void main(String [] argv) {
        Remorca r1, r2, r3, r4;
        r1 = new Remorca("Alina");
        r2 = new Remorca(8, "Maria");
        r3 = new Remorca("Nicoleta");
        r4 = new Remorca("Ioana");
        Tir t1, t2;
        t1 = new Tir();
        t2 = new Tir();
        t1.adaugaRemorca(r1);
        t1.adaugaRemorca(r2);
        t1.adaugaRemorca(r3);
        t1.adaugaRemorca(4, "Ruset");
        t2.adaugaRemorca(r4);
        System.out.println(t1);
        t1.stergeRemorca("Alina");
        System.out.println(t1);
        t1.equals(t2);
        t1.stergeRemorca("Maria");
        t1.stergeRemorca("Ruset");
        t1.equals(t2);
    }
}

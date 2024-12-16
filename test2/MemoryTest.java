import java.util.*;

// Interfață Memory
interface Memory {
    int calculeazaMemorie();
}

// Clasa abstractă Memorie
abstract class Memorie implements Memory {
    protected List<Byte> octeti = new ArrayList<Byte>();
    private int dimensiune;

    public Memorie(int dimensiune) {
        if (dimensiune < 0) {
            throw new IllegalArgumentException("Dimensiunea trebuie să fie mai mare decât 0");
        }
        this.dimensiune = dimensiune;
    }

    public int calculeazaMemorie() {
        return this.dimensiune;
    }

    public List<Byte> read(int start, int end) {
        if (start < 0 || end < 0 || start > end || start >= octeti.size() || end >= octeti.size()) {
            throw new IllegalArgumentException("Index invalid pentru citire");
        }
        List<Byte> nou = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            nou.add(octeti.get(i));
        }
        return nou;
    }

    public void setOcteti(List<Byte> octeti) {
        this.octeti = octeti;
    }
}

// Clasa PROM: Memorie doar pentru citire cu date predefinite
class PROM extends Memorie {
    public PROM(int dimensiuneMemorie, List<Byte> octeti) {
        super(dimensiuneMemorie);
        this.octeti = new ArrayList<>(octeti);
    }
}

// Clasa RandomROM: Memorie doar pentru citire cu conținut aleator
class RandomROM extends Memorie {
    public RandomROM(int dimensiuneMemorie) {
        super(dimensiuneMemorie);
        for (int i = 0; i < dimensiuneMemorie; i++) {
            double random = Math.random();
            if (random < 0.5) {
                octeti.add((byte) 0);
            } else {
                octeti.add((byte) 1);
            }
        }
    }
}

// Clasa RAM: Memorie care permite scriere și citire
class RAM extends Memorie {
    public RAM(int dimensiuneMemorie) {
        super(dimensiuneMemorie);
        for (int i = 0; i < dimensiuneMemorie; i++) {
            octeti.add((byte) 0); // Inițializăm memoria cu 0
        }
    }

    public void write(int start, List<Byte> data) {
        if (start < 0 || start + data.size() > octeti.size()) {
            throw new IllegalArgumentException("Datele depășesc dimensiunea memoriei");
        }
        for (int i = 0; i < data.size(); i++) {
            octeti.set(start + i, data.get(i));
        }
    }
}

// Clasa RedundantRAM: RAM cu funcționalități de redundanță
class RedundantRAM extends RAM {
    private List<RAM> redundantMemories;

    public RedundantRAM(int dimensiuneMemorie) {
        super(dimensiuneMemorie);
        redundantMemories = new ArrayList<>();
    }

    public void addWritableMemory(RAM memory) {
        if (memory.calculeazaMemorie() < this.calculeazaMemorie()) {
            throw new IllegalArgumentException("Memoria adăugată este prea mică");
        }
        redundantMemories.add(memory);
    }

    @Override
    public void write(int start, List<Byte> data) {
        super.write(start, data);
        for (RAM memory : redundantMemories) {
            memory.write(start, data);
        }
    }
}

// Clasa Main pentru testare
public class MemoryTest {
    public static void main(String[] args) {
        // Test PROM
        List<Byte> promData = Arrays.asList((byte) 1, (byte) 0, (byte) 1, (byte) 1, (byte) 0);
        PROM prom = new PROM(5, promData);
        System.out.println("PROM Read: " + prom.read(0, 4));

        // Test RandomROM
        RandomROM randomROM = new RandomROM(5);
        System.out.println("RandomROM Read: " + randomROM.read(0, 4));

        // Test RAM
        RAM ram = new RAM(5);
        List<Byte> writeData = Arrays.asList((byte) 0, (byte) 1, (byte) 1, (byte) 0, (byte) 1);
        ram.write(0, writeData);
        System.out.println("RAM Read after Write: " + ram.read(0, 4));

        // Test RedundantRAM
        RedundantRAM redundantRAM = new RedundantRAM(5);
        RAM backup1 = new RAM(5);
        RAM backup2 = new RAM(5);

        redundantRAM.addWritableMemory(backup1);
        redundantRAM.addWritableMemory(backup2);

        List<Byte> redundantData = Arrays.asList((byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 1);
        redundantRAM.write(0, redundantData);

        System.out.println("RedundantRAM Read: " + redundantRAM.read(0, 4));
        System.out.println("Backup RAM 1 Read: " + backup1.read(0, 4));
        System.out.println("Backup RAM 2 Read: " + backup2.read(0, 4));
    }
}
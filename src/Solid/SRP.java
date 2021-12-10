package Solid;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SRP {
    public static void main(String[] args) throws FileNotFoundException {
        Journal journal = new Journal();

        journal.addEntry("Banana frita");
        journal.addEntry("Cenoura caramelizada");
        journal.addEntry("Pneu queimado com farofa");

        journal.removeEntry(2);

        System.out.println(journal.toString());

        Persistence persistence = new Persistence();
        String filename = ("C:\\Users\\Pichau\\Desktop");
        persistence.saveToFile(journal, filename, true);
    }
}

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ":" + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }
}

class Persistence {
    public void saveToFile(Journal journal, String filename, boolean overwite) throws FileNotFoundException {
        if (overwite || new File(filename).exists()) {
            try (PrintStream printStream = new PrintStream(filename)){
                System.out.println(journal.toString());
            }
        }
    }
}

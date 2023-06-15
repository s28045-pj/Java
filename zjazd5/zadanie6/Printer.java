import java.util.Iterator;
import java.util.List;

class Printer {
    static void printAll(List<Hamster> hl) {
        Iterator<Hamster> iterator = hl.iterator();
        while (iterator.hasNext()) {
            Hamster hamster = iterator.next();
            System.out.println(hamster.getHamsterNumber() + " o imieniu: " + hamster.getName());
        }
    }
}

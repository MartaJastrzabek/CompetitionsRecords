import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CompetitionTest {
    private static final String EXIT_PHRASE = "stop";
    private static final String OUTPUT_FILE = "stats.csv";

    public static void main(String[] args) {
        try {
            List<Competitor> competitors = createCompetitorsList();
            Collections.sort(competitors);
            saveToFile(competitors);
            System.out.println("Dane posortowano i zapisano do pliku.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("wprowadzono niepoprawne dane");
        }
    }

    private static void saveToFile(List<Competitor> competitors) throws IOException {
        File file = new File(OUTPUT_FILE);
        BufferedWriter br = new BufferedWriter(new FileWriter(file));
        for (Competitor c : competitors) {
            br.write(c.getFirstName() + "," + c.getLastName() + "," + c.getResult());
            br.newLine();
        }
        br.flush();
        br.close();
    }

    private static List<Competitor> createCompetitorsList() {
        List<Competitor> competitors = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Podaj imie, nazwisko i wynik kolejnego gracza, lub stop, aby zakończyć");
        String userInput = input.nextLine();
        String[] split = null;

        while (!EXIT_PHRASE.equalsIgnoreCase(userInput)) {
            split = userInput.split(" ");

            if (split.length != 3) {
                System.out.println("Błędne dane. Spróbuj ponownie");
                userInput = input.nextLine();
                continue;
            }

            competitors.add(new Competitor(split[0], split[1], Integer.valueOf(split[2])));
            System.out.println("Podaj imie, nazwisko i wynik kolejnego gracza, lub stop, aby zakończyć");
            userInput = input.nextLine();
        }

        input.close();

        return competitors;
    }
}

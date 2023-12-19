import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
Данный код указан в учебнике. Не работает. Возможно, проблема в отсутствии правильного указания аргументов.

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {

      if (args.length == 0) {
            System.out.println("Please provide the file name as a command line argument");
            return;
        }

        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line: lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }
}
 */


public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";
    private static final String FILE_NAME = "transactions"; // Жестко закодированный путь к файлу

    public BankTransactionAnalyzerSimple() throws IOException {
    }

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES, FILE_NAME);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]); //30-01-2017 индекс 1,-50.00 индекс 2,Tesco индекс 3. (parseDouble переформатирует строку в число типа Double)
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    // } вот здесь по-хорошему завершить и вывести январь в отдельный класс

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        System.out.println("The total for all transactions in January is " + total);
    }
 }



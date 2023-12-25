import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;


public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final String FILE_NAME = "transactions"; // Жестко закодированный путь к файлу

    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + FILE_NAME);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    public static void collectSummary(final BankStatementProcessor bankStatementProcessor) {

        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}

//    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
//        double total = 0d;
//        for (final BankTransaction bankTransaction : bankTransactions) {
//            total += bankTransaction.getAmount();
//        }
//        return total;
//    }

//    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
//        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
//        for (final BankTransaction bankTransaction : bankTransactions) {
//            if (bankTransaction.getDate().getMonth() == month) {
//                bankTransactionsInMonth.add(bankTransaction);
//            }
//        }
//        return bankTransactionsInMonth;
//    }
//}

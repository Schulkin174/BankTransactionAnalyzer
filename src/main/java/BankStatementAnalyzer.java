import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String FILE_NAME = "C:\\Users\\Алекс\\IdeaProjects\\BankTransactionAnalyzer\\src\\main\\resources\\transactions"; // Жестко закодированный путь к файлу

    // отвязываю BankStatementAnalyzer от специфической реализации BankStatementCSVParser с помощью введения метода analyze
    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(FILE_NAME);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

        final BankTransactionIsInFebruaryAndExpensive transactionFilter = new BankTransactionIsInFebruaryAndExpensive();
        transactionFilter.test((BankTransaction) bankTransactions);
    }

    public static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
//        System.out.println("New list: " + bankStatementProcessor.transactions());
    }
}
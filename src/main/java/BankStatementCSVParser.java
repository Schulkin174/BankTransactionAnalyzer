import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// класс BankStatementCSVParser объявляет 2 метода: parseFromCSV и parseLinesFromCSV, которые созают объекты BankTransaction
// являющиеся экземплярами доменного класса (BankTransaction), моделирующего банковские операции
//public class BankStatementCSVParser implements BankStatementParser{
//    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//    private BankTransaction parseFrom (final String line) {
//        final String[] columns = line.split(",");
//
//        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
//        final double amount = Double.parseDouble(columns[1]);
//        final String description = columns[2];
//
//        return new BankTransaction(date, amount, description);
//    }
//    public List<BankTransaction> parseLinesFromCSV (final List<String> lines) {
//        final List<BankTransaction> bankTransactions = new ArrayList<>();
//        for(final String line: lines) {
//            bankTransactions.add(parseFromCSV(line));
//        }
//        return bankTransactions;
//    }
//
//    @Override
//    public BankTransaction parseFromCSV(String line) {
//        return null;
//    }
//
//    @Override
//    public List<BankTransaction> parseLinesFrom(List<String> lines) {
//        return null;
//    }
//}

public class BankStatementCSVParser implements BankStatementParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (String line : lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}

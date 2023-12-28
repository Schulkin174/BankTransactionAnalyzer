import java.util.List;

// добавляю интерфейс для возможности использования парсера банковских операций BankStatementCSVParser без реализации
// например, необходимости чтения не только CSV, а JSON или XML
public interface BankStatementParser {
    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    // трехступенчатый шаблон модульного тестирования: Giwen-When-Then
    @Test
    public void shouldParceOneCorrectLine() throws Exception {
        final String line = "30-01-2017, -50.00, Tesco";

        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, " Tesco");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount());
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}

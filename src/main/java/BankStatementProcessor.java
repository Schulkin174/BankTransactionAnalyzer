import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
    }
        return total;
}

    public double calculateTotalForCategory(final String category) {
    double total = 0;
    for (final BankTransaction bankTransaction: bankTransactions) {
        if (bankTransaction.getDescription().equals(category)) {
            total += bankTransaction.getAmount();
        }
    }
    return total;
    }

    // добавляю поиск операций на определенную сумму и за определенный месяц
    public List<BankTransaction> findTransactionsInMonthAndGreater(final Month month, final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() >= 3000) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}

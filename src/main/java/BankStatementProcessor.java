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
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    // поиск банковских операций на определенную сумму и за определенный месяц
    //    public List<BankTransaction> BankTransactionIsInMonthAndGreater(final Month month, final int amount) {
//        final List<BankTransaction> result = new ArrayList<>();
//        for(final BankTransaction bankTransaction: bankTransactions) {
//            if(bankTransaction.getDate().getMonth() == month && bankTransaction.getAmount() >= amount) {
//                result.add(bankTransaction);
//            }
//        }
//        return result;
//    }


    // но лучше создадим интерфейс и возложим на него ответственность за выбор подходящих транзакций. В нем будет метод test.
    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}

// реализация BankTransactionFilter с использованием лямбда-выражение
//     final List<BankTransaction> transactions = BankStatementProcessor.findTransactions(bankTransaction ->
//            bankTransaction.getDate().getMonth() == Month.FEBRUARY
//            && bankTransaction.getAmount() >= 1_000);
//}



import java.time.Month;
import java.util.List;

// объявляю класс, который реализует интерфейс BankTransactionFilter
class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
    }
}


//public class BankTransactionIsInFebruaryAndExpensive {
//    public List<BankTransaction> findTransactionsInFebruaryAndGreater(List<BankTransaction> bankTransactions) {
//        List<BankTransaction> bigFebruaryTransactions = new ArrayList<>();
//        for (BankTransaction transaction : bankTransactions) {
//            if (transaction.getDate().getMonth() == Month.FEBRUARY && transaction.getAmount() >= 1000) {
//                bigFebruaryTransactions.add(transaction);
//            }
//        }
//        return bigFebruaryTransactions;
//    }
//}

// не реализован.

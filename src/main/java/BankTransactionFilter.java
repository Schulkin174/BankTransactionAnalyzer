@FunctionalInterface // интерфейс содержит только один абстрактный метод
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction); // интерфейс для выбора подходящих транзакций по разным критериям метод test возвращает булево значение, а в качестве аргумента принимает объект BankTransaction
}
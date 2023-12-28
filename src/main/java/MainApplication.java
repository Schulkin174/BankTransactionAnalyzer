import java.io.IOException;

//public class MainApplication {
//    public static void main(String[] args) throws IOException {
//
//        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
//        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
//
//        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
//    }
//}

public class MainApplication {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        String filePath = "C:\\Users\\Алекс\\IdeaProjects\\BankTransactionAnalyzer\\src\\main\\resources\\transactions";
        bankStatementAnalyzer.analyze(filePath, bankStatementParser);
    }
}

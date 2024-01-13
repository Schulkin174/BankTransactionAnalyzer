//// внедрение доменного класса, отвечающего за сбор ошибок: создание шаблона уведомлений
//// цель - решить проблему использования слишком большого количества непроверяемых исключений.
//
//import java.time.LocalDate;
//import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Notification {
//    private final List<String> errors = new ArrayList<>();
//
//    public void addError(final String message) {
//        errors.add(message);
//    }
//
//    public boolean hasErrors() {
//        return !errors.isEmpty();
//    }
//
//    public String errorMessage() {
//        return errors.toString();
//    }
//
//    public List<String> getErrors() {
//        return this.errors;
//    }
//
////  теперь мы можем объвить метод для проверки корректности данных, который способен собирать много ошибок за раз.
////  и теперь вместо генерирования исключений можем добавлять сообщения об ошибках в объект Notification
//
//// создаем шаблон уведомлений:
//
//    public Notification validate() {
//
//        final Notification notification = new Notification();
//        if (this.description.lengtgh() > 100) {
//            notification.addError("The description is too long");
//        }
//
//        final LocalDate parsedDate;
//        try {
//            parsedDate = LocalDate.parse(this.date);
//            if (parsedDate.isAfter(LocalDate.now())) {
//                notification.addError("date cannot be in the future");
//            }
//        } catch (DateTimeParseException e) {
//            notification.addError("Invalid format for date");
//        }
//
//        final double amount;
//        try {
//            amount = Double.parseDouble(this.amount);
//        } catch (NumberFormatException e) {
//            notification.addError("Invalid format for amount");
//        }
//        return notification;
//    }
//}

// класс не реализован.
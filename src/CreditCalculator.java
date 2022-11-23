import java.util.Scanner;

public class CreditCalculator {

    public static final String HUMAN = "human";
    public static final String BUSINESS = "business";

    public static void main(String[] args) throws ScannerException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел: сумма кредита, ежемесячный платеж, ставка%, тип клиента.");
        CreditData creditData = new CreditData();
        CreditCalculations creditCalculations = new CreditCalculations();

        creditData.setSum(Double.parseDouble(scanner.next()));
        creditData.setPay(Double.parseDouble(scanner.next()));
        creditData.setBet(Double.parseDouble(scanner.next()));
        creditData.setType(scanner.next());

        if (creditData.getSum() < 0) {
            throw new ScannerException("Сумма кредита должна быть положительной: проверьте ввод данных");
        }
        if (creditData.getType().compareToIgnoreCase(CreditCalculator.HUMAN) == 0) {
            if (creditData.getSum() * (creditData.getBet() / 100) >= creditData.getPay() * 12) {
                throw new ScannerException("Сумма годового платежа должна быть больше суммы годовых процентов: проверьте ввод данных");
            }
        }
        if (creditData.getType().compareToIgnoreCase(CreditCalculator.BUSINESS) == 0) {
            double a = creditData.getSum() - creditData.getPay() * 12;
            if (a * (creditData.getBet() / 100) >= creditData.getPay() * 12) {
                throw new ScannerException("Сумма годового платежа должна быть больше суммы годовых процентов: проверьте ввод данных");
            }
        }
        if (creditData.getType().compareToIgnoreCase(CreditCalculator.HUMAN) != 0 && creditData.getType().compareToIgnoreCase(CreditCalculator.BUSINESS) != 0) {
            throw new ScannerException("Тип клиента должен быть 'human' или 'business'");
        }
        creditCalculations.countCredit(creditData);
    }
}














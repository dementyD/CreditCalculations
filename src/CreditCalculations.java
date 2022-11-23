public class CreditCalculations {

    void countCredit(CreditData creditData) {
        double sumMonth = creditData.getSum() / creditData.getPay();
        double payYear = creditData.getPay() * 12;
        double firstPercent = 0;
        double finishPercent = 0;
        double savePercent;
        double percent;
        double result;
        double sumCredit = creditData.getSum();

        if (sumMonth <= 12) {

            if (creditData.getType().equalsIgnoreCase(CreditCalculator.HUMAN)) {
                result = sumCredit * (creditData.getBet() / 100);
                System.out.println(Math.ceil(result));
            }
            if (creditData.getType().equalsIgnoreCase(CreditCalculator.BUSINESS)) {
                System.out.println(0.0);
            }
        } else if (sumMonth > 12) {

            if (creditData.getType().equalsIgnoreCase(CreditCalculator.HUMAN)) {
                firstPercent = sumCredit * (creditData.getBet() / 100);
                sumCredit += firstPercent;
            }
            do {
                percent = 0;

                sumCredit = sumCredit - payYear;
                percent = sumCredit * (creditData.getBet() / 100);
                sumCredit = sumCredit + percent;

                savePercent = percent;
                finishPercent = savePercent + finishPercent;

            } while (sumCredit >= payYear);
            System.out.println(Math.ceil(firstPercent + finishPercent));
        }
    }
}

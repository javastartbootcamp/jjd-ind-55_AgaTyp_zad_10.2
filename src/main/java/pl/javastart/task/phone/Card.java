package pl.javastart.task.phone;

public class Card extends Contract {
    double prePaidValue;
    double smsCost;
    double mmsCost;
    double minuteCost;

    public Card(double prePaidValue, double smsCost, double mmsCost, double minuteCost) {
//        super(prePaidValue);
        this.prePaidValue = prePaidValue;
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.minuteCost = minuteCost;
    }

    @Override
    public String getAdditionalContractInfo() {
        return "Na koncie zostało: " + String.format("%.2f", prePaidValue) + " zł" + "\n";
    }

    @Override
    public void sendSms() {
        if (smsCost > prePaidValue) {
            System.out.println("Nie udało się wysłać SMSa."  + "\n");
        } else {
            prePaidValue -= smsCost;
            super.sendSms();
        }
    }

    @Override
    public void sendMms() {
        if (mmsCost > prePaidValue) {
            System.out.println("Nie udało się wysłać MMSa."  + "\n");
        } else {
            prePaidValue -= mmsCost;
            super.sendMms();
        }
    }

    @Override
    public void call(int seconds) {

        double minutes = Math.ceil((double) seconds / 60);
        double potentialMinutes = prePaidValue / minuteCost;

        if (minutes <= potentialMinutes) {
            prePaidValue -= minutes * minuteCost;
            super.call(seconds);
        } else if (minuteCost < prePaidValue) {
            int callLength = (int) Math.ceil(prePaidValue / minuteCost);
            prePaidValue = 0;
            secondsNo += callLength * 60;
            System.out.printf("Rozmowa wykonana, trwała %d min\n", callLength);
        } else {
            System.out.println("Nie udało się zadzwonić."  + "\n");
        }

    }

}

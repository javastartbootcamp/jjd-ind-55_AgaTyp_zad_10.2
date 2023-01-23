package pl.javastart.task.phone;

public class Mix extends Card {
    int smsAmount;
    int mmsAmount;
    int minutesAmount;

    public Mix(double prePaidValue, double smsCost, double mmsCost, double minuteCost, int smsAmount, int mmsAmount, int minutesAmount) {
        super(prePaidValue, smsCost, mmsCost, minuteCost);
        this.smsAmount = smsAmount;
        this.mmsAmount = mmsAmount;
        this.minutesAmount = minutesAmount;
    }

    @Override
    public String getAdditionalContractInfo() {
        return super.getAdditionalContractInfo() +
                "Pozostało SMSów: " + smsAmount + "\n" +
                "Pozostało MMSów: " + mmsAmount + "\n" +
                "Pozostało minut: " + minutesAmount;
    }

    @Override
    public void sendSms() {
        if (smsAmount == 0) {
            super.sendSms();
        } else {
            smsNo++;
            smsAmount--;
            System.out.println("SMS wysłany" + "\n");
        }
    }

    @Override
    public void sendMms() {
        if (mmsAmount == 0) {
            super.sendMms();
        } else {
            mmsNo++;
            mmsAmount--;
            System.out.println("MMS wysłany" + "\n");
        }
    }

    @Override
    public void call(int seconds) {

        if (minutesAmount == 0) {
            super.call(seconds);
        } else if (seconds > (minutesAmount * 60)) {
            seconds = seconds - minutesAmount * 60;
            minutesAmount = 0;
            super.call(seconds);
        } else {
            minutesAmount = minutesAmount - (int) Math.ceil((double) seconds / 60);
            secondsNo += seconds;
            int minutes = (int) Math.floor((double) seconds / 60);
            int secRest = seconds - minutes * 60;
            System.out.printf("Rozmowa wykonana, trwała %d min i %d sekund\n\n", minutes, secRest);
        }
    }

}

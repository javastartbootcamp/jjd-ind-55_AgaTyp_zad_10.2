package pl.javastart.task.phone;

public abstract class Contract implements ContractUtility {
    int smsNo = 0;
    int mmsNo = 0;
    int secondsNo = 0;

    public void sendSms() {
        smsNo++;
        System.out.println("SMS wysłany"  + "\n");
    }

    public void sendMms() {
        mmsNo++;
        System.out.println("MMS wysłany"  + "\n");
    }

    public void call(int seconds) {
        secondsNo = secondsNo + seconds;
        System.out.println("Rozmowa wykonana"  + "\n");
    }

    @Override
    public String toString() {
        return "=== STAN KONTA ===" + "\n" +
                "Wysłanych SMSów: " + smsNo + "\n" +
                "Wysłanych MMSów: " + mmsNo + "\n" +
                "Liczba sekund rozmowy: " + secondsNo + "\n" +
                getAdditionalContractInfo();
    }

}

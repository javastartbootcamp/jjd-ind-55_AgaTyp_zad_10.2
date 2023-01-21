package pl.javastart.task.phone;

public abstract class Contract {
    private double accountValue;
    private int smsNo = 0;
    private int mmsNo = 0;
    private int secondsNo = 0;

    public Contract(double accountValue) {
        this.accountValue = accountValue;
    }

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
                "Liczba sekund rozmowy: " + secondsNo;
    }

    public double getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(double accountValue) {
        this.accountValue = accountValue;
    }

    public int getSmsNo() {
        return smsNo;
    }

    public void setSmsNo(int smsNo) {
        this.smsNo = smsNo;
    }

    public int getMmsNo() {
        return mmsNo;
    }

    public void setMmsNo(int mmsNo) {
        this.mmsNo = mmsNo;
    }

    public int getSecondsNo() {
        return secondsNo;
    }

    public void setSecondsNo(int secondsNo) {
        this.secondsNo = secondsNo;
    }
}

package pl.javastart.task.phone;

public class Phone {
    private Contract contract;

//    public Phone(Contract contract) {
//        this.contract = contract;
//    }

    public Phone(String type, double accountValue, double smsCost, double mmsCost, double minuteCost, int smsAmount, int mmsAmount, int minutesAmount) {
        this.contract = new Mix(accountValue, smsCost, mmsCost, minuteCost, smsAmount, mmsAmount, minutesAmount);
    }

    public Phone(String type, double accountValue, double smsCost, double mmsCost, double minuteCost) {
        this.contract = new Card(accountValue, smsCost, mmsCost, minuteCost);
    }

    public Phone(String type, double accountValue) {
        this.contract = new Subscription(accountValue);
    }

    public void sendSms() {
        contract.sendSms();
    }

    public void sendMms() {
        contract.sendMms();
    }

    public void call(int seconds) {
        contract.call(seconds);
    }

    public void printAccountState() {
        System.out.println(contract.toString());
    }
}

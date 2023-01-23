package pl.javastart.task.phone;

public class Phone {
    private Contract contract;

    public Phone(Contract contract) {
        this.contract = contract;
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

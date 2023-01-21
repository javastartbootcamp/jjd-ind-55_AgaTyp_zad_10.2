package pl.javastart.task.phone;

class Subscription extends Contract implements ContractUtility {

    public Subscription(double accountValue) {
        super(accountValue);
    }

    @Override
    public String printContractInfo() {
        return "Rachunek: " + String.format("%.2f", getAccountValue())  + " zł"  + "\n";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + printContractInfo();
    }
}

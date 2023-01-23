package pl.javastart.task.phone;

public class Subscription extends Contract {
    double subscriptionCost;

    public Subscription(double subscriptionCost) {
        this.subscriptionCost = subscriptionCost;
    }

    @Override
    public String getAdditionalContractInfo() {
        return "Rachunek: " + String.format("%.2f", subscriptionCost)  + " zł"  + "\n";
    }
    
}

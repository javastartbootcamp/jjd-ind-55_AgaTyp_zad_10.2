package pl.javastart.task.phone;

class Card extends Contract implements ContractUtility {
    private double smsCost;
    private double mmsCost;
    private double minuteCost;

    public Card(double accountValue, double smsCost, double mmsCost, double minuteCost) {
        super(accountValue);
        this.smsCost = smsCost;
        this.mmsCost = mmsCost;
        this.minuteCost = minuteCost;
    }

    @Override
    public String printContractInfo() {
        return "Na koncie zostało: " + String.format("%.2f", getAccountValue()) + " zł" + "\n";
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + printContractInfo();
    }

    @Override
    public void sendSms() {
        if (smsCost > getAccountValue()) {
            System.out.println("Nie udało się wysłać SMSa."  + "\n");
        } else {
            setAccountValue(getAccountValue() - smsCost);
            super.sendSms();
        }
    }

    @Override
    public void sendMms() {
        if (mmsCost > getAccountValue()) {
            System.out.println("Nie udało się wysłać MMSa."  + "\n");
        } else {
            setAccountValue(getAccountValue() - mmsCost);
            super.sendMms();
        }
    }

    @Override
    public void call(int seconds) {

        double minutes = Math.ceil((double) seconds / 60);
        double potentialMinutes = getAccountValue() / minuteCost;

        if (minutes <= potentialMinutes) {
            setAccountValue(getAccountValue() - minutes * minuteCost);
            super.call(seconds);
        } else if (minuteCost < getAccountValue()) {
            int callLength = (int) Math.ceil(getAccountValue() / minuteCost);
            setAccountValue(0);
            setSecondsNo(getSecondsNo() + callLength * 60);
            System.out.printf("Rozmowa wykonana, trwała %d min\n", callLength);
        } else {
            System.out.println("Nie udało się zadzwonić."  + "\n");
        }

    }

    public double getSmsCost() {
        return smsCost;
    }

    public void setSmsCost(double smsCost) {
        this.smsCost = smsCost;
    }

    public double getMmsCost() {
        return mmsCost;
    }

    public void setMmsCost(double mmsCost) {
        this.mmsCost = mmsCost;
    }

    public double getMinuteCost() {
        return minuteCost;
    }

    public void setMinuteCost(double minuteCost) {
        this.minuteCost = minuteCost;
    }
}

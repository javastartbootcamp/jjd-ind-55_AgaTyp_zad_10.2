package pl.javastart.task.phone;

class Mix extends Card implements ContractUtility {
    private int smsAmount;
    private int mmsAmount;
    private int minutesAmount;

    public Mix(double accountValue, double smsCost, double mmsCost, double minuteCost, int smsAmount, int mmsAmount, int minutesAmount) {
        super(accountValue, smsCost, mmsCost, minuteCost);
        this.smsAmount = smsAmount;
        this.mmsAmount = mmsAmount;
        this.minutesAmount = minutesAmount;
    }

    @Override
    public String printContractInfo() {
        return "Pozostało SMSów: " + smsAmount + "\n" +
                "Pozostało MMSów: " + mmsAmount + "\n" +
                "Pozostało minut: " + minutesAmount;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\n" + super.printContractInfo();
    }

    @Override
    public void sendSms() {
        if (smsAmount == 0) {
            super.sendSms();
        } else {
            setSmsNo(getSmsNo() + 1);
            smsAmount--;
            System.out.println("SMS wysłany" + "\n");
        }
    }

    @Override
    public void sendMms() {
        if (mmsAmount == 0) {
            super.sendMms();
        } else {
            setMmsNo(getMmsNo() + 1);
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
            setSecondsNo(getSecondsNo() + seconds);
            int minutes = (int) Math.floor((double) seconds / 60);
            int secRest = seconds - minutes * 60;
            System.out.printf("Rozmowa wykonana, trwała %d min i %d sekund\n\n", minutes, secRest);
        }
    }

    public int getSmsAmount() {
        return smsAmount;
    }

    public void setSmsAmount(int smsAmount) {
        this.smsAmount = smsAmount;
    }

    public int getMmsAmount() {
        return mmsAmount;
    }

    public void setMmsAmount(int mmsAmount) {
        this.mmsAmount = mmsAmount;
    }

    public int getMinutesAmount() {
        return minutesAmount;
    }

    public void setMinutesAmount(int minutesAmount) {
        this.minutesAmount = minutesAmount;
    }

}

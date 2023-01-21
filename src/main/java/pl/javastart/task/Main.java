package pl.javastart.task;

import pl.javastart.task.phone.Phone;

public class Main {

    public static void main(String[] args) {

//        Phone phone = new Phone("Mix", 5.0, .1, .2, .5, 3, 2, 10);
        Phone phone = new Phone("Card", 5.0, .1, .2, .5);
//        Phone phone = new Phone("Subsription", 5.0);

        phone.printAccountState();

//        phone.sendSms();
        phone.call(320);
        phone.printAccountState();

        phone.sendSms();
        phone.sendSms();
        phone.sendSms();
        phone.sendSms();
        phone.printAccountState();

        phone.sendMms();
        phone.sendMms();
        phone.sendMms();
        phone.sendMms();
        phone.printAccountState();

    }
}

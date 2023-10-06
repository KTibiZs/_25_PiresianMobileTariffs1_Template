package hu.ak_akademia.oop.piresian;

import java.util.Scanner;

import hu.ak_akademia.oop.piresian.general.InvalidCharacterException;
import hu.ak_akademia.oop.piresian.general.InvalidInput;

import hu.ak_akademia.oop.piresian.general.Duration;
import hu.ak_akademia.oop.piresian.general.PhoneNumber;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Class to get the user input data: phone number as well as call duration.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
class UserInput implements AutoCloseable {
    TextHolder th = new TextHolder();
    private final Scanner scanner = new Scanner(System.in);

    PhoneNumber askPhoneNumber(String prompt) throws InvalidInput {
        System.out.print(prompt);
        String phoneNumberText = scanner.nextLine().trim();
        if (phoneNumberText.isEmpty()) {
            th.goodbye();
            System.exit(0);
        }
        return new PhoneNumber(phoneNumberText);
    }

    Duration askCallDuration(String prompt) throws InvalidCharacterException {
        System.out.print(prompt);
        String durationText = scanner.nextLine().trim();
        if (durationText.isEmpty()) {
            th.goodbye();
            System.exit(0);
        } else {
            return new Duration(durationText);
        }
        throw new InvalidCharacterException("A megadott telefonszám nem értelmezhető karaktert tartalmaz");
    }

    @Override
    public void close() {
        scanner.close();
    }
}

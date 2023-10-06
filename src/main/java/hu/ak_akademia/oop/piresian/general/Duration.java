package hu.ak_akademia.oop.piresian.general;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Class to represent the duration of a call. Also includes a few convenience methods dedicated to specific tariff types.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class Duration {
    String rawDuration;
    int minInSec = 60;

    public Duration(String rawDuration) {
        this.rawDuration = rawDuration;
    }

    public String getRawDuration() {
        return rawDuration;
    }

    public double rawDurationToSec(String rawDuration) throws InvalidCharacterException {

        // Ez valamiért nem akart működni:
//        for (char c : rawDuration.toCharArray()) {
//            if (("0123456789".indexOf(c)) < 0) {
//                throw new InvalidCharacterException("A megadott idő nem értelmezhető");
//            }
//        }

        String[] time = rawDuration.split(":");
        int minute = Integer.parseInt(time[0].trim());
        int second = Integer.parseInt(time[1].trim());

        if (minute < 0 || minute > 59) {
            throw new InvalidCharacterException("A megadott idő nem értelmezhető");
        }
        if (second < 0 || second > 59) {
            throw new InvalidCharacterException("A megadott idő nem értelmezhető");
        }
        return second + (minInSec * minute);
    }
}

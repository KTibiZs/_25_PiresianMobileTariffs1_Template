package hu.ak_akademia.oop.piresian;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Class to assist the main program in holding or printing some text elements.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
class TextHolder {
    void welcome() {
        System.out.printf("Üdvözöllek az első piréz mobiltelefonos díjkalkulátorban!%n%n");
    }

    void printUserInfo() {
        System.out.printf("" //
                + "A programmal a Piréziában érvényes mobiltelefonos szolgáltatási díjakról tájékozódhatsz. A program előbb%n"
                + "azonosítja az adott hívószámból a szolgáltatót és kiszámolja a hívás díját, majd meghatározza, hogy az adott%n"
                + "időtartamú hívás melyik szolgáltatónál a legolcsóbb. A programból bármikor kiléphetsz üres adat megadásával.%n%n");
    }

    void goodbye() {
        System.out.printf("%nViszlát!%n");
    }
}

package hu.ak_akademia.oop.piresian.general;

import hu.ak_akademia.oop.piresian.Operator;
import hu.ak_akademia.oop.piresian.operator.AbstractOperator;

/**
 * <b>Exercise: Piresian Mobile Tariffs #1 (Piréz mobiltelefon-tarifák #1)</b>
 * <p>
 * Class to represent a phone number.
 *
 * @author A&amp;K Akad&eacute;mia (Lajos Czuczor)
 */
public class PhoneNumber {

    private static final String CHARS_TO_DISCARD = "()- "; // allowed but discarded chars in phone numbers
    private static final String[] PREFIXES = {"+355", "00355", "06"}; // long distance call prefixes, int'l or domestic
    private static final int LOCAL_NUMBER_LEN_MIN = 5; // length limits of local phone numbers
    private static final int LOCAL_NUMBER_LEN_MAX = 7;
    private static final int NUMBER_LEN_MIN = 2 + LOCAL_NUMBER_LEN_MIN; // length limits of phone numbers: area code + local
    private static final int NUMBER_LEN_MAX = 3 + LOCAL_NUMBER_LEN_MAX;

    private final String normalForm; // normal form of this phone number: area code + local number

    //************************************************************************************************************
// Behaviour: constructor and public methods
//
    public PhoneNumber(String rawPhoneNumber) throws InvalidInput {
        String fullPhoneNumber = clean(rawPhoneNumber);
        normalForm = removePrefix(fullPhoneNumber);
        makePriorCheck();
    }

    public String getNormalForm() {
        return normalForm;
    }

    // make a check after identification
    public void makePosteriorCheck(AbstractOperator operator) throws InvalidInput {
        checkLocalLength(operator);
    }

    //************************************************************************************************************
// Interior
//
    // clean phone number from valid but unnecessary characters
    private String clean(String rawNumber) {
        String fullNumber = rawNumber;
        for (String s : CHARS_TO_DISCARD.split("")) {
            fullNumber = fullNumber.replace(s, "");
        }
        return fullNumber;
    }

    // remove long distance call prefix (international or domestic)
    private String removePrefix(String fullNumber) throws WithoutPrefixException {
        for (String prefix : PREFIXES) {
            if (fullNumber.startsWith(prefix)) {
                return fullNumber.substring(prefix.length());
            }
        }
        throw new WithoutPrefixException("A megadott telefonszámból hiányzik a (nemzetközi vagy belföldi) távolsági előhívó");
    }

    // make all possible checks before the identification of the mobile operator
    private void makePriorCheck() throws InvalidInput {
        checkChars();
        checkLength();
        checkAreaCode();
    }

    // check if all characters are numeric
    private void checkChars() throws InvalidCharacterException {
        for (char c : normalForm.toCharArray()) {
            if ("0123456789".indexOf(c) < 0) {
                throw new InvalidCharacterException("A megadott telefonszám nem értelmezhető karaktert tartalmaz");
            }
        }
    }

    // make a primary check on the length of this phone number (area code + local)
    private void checkLength() throws InvalidLengthOfPhoneNumber {
        int length = getNormalForm().length();
        if (length < NUMBER_LEN_MIN) {
            throw new InvalidLengthOfPhoneNumber("A megadott telefonszám túl rövid");
        }
        if (length > NUMBER_LEN_MAX) {
            throw new InvalidLengthOfPhoneNumber("A megadott telefonszám túl hosszú");
        }
    }

    // check the first digit of the area code
    private void checkAreaCode() throws AreaNumberStartWithZeroException {
        if (normalForm.charAt(0) == '0') {
            throw new AreaNumberStartWithZeroException("A megadott telefonszám körzetszáma 0-val kezdődik");
        }
    }

    // check the length of the local component of this phone number
    private void checkLocalLength(AbstractOperator operator) throws InvalidLengthOfLocalComponent {
        if (getNormalForm().startsWith(operator.getOperatorSpecifyNumber())) {
            int localLength = getNormalForm().length() - operator.getOperatorSpecifyNumber().length();
            if (localLength < LOCAL_NUMBER_LEN_MIN) {
                throw new InvalidLengthOfLocalComponent("A megadott telefonszám körzeten belüli része túl rövid");
            }
            if (localLength > LOCAL_NUMBER_LEN_MAX) {
                throw new InvalidLengthOfLocalComponent("A megadott telefonszám körzeten belüli része túl hosszú");
            }
        }
    }
}
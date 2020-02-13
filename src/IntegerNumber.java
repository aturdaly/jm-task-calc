//integer numbers class
public class IntegerNumber extends Number {

    public int intNumber;

    public IntegerNumber(String intNumber) {

        super(intNumber);
    }

    //is string integer numbers?
    public boolean isInteger() {
        try {
            intNumber = Integer.parseInt(super.number);

        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}

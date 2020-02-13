import java.util.NoSuchElementException;

//roman numbers class
public class RomanNumber extends Number {

    public RomanNumber(String romanNumber) {

        super(romanNumber);
    }

    // This function returns value of a Roman symbol
    private int value(char r)
    {
        if (r == 'I')
            return 1;
        else if (r == 'V')
            return 5;
        else if (r == 'X')
            return 10;
        else throw new NoSuchElementException("wrong format!!");
    }

    // This function returns flag of a Roman symbol: IV true, VX false
    private boolean flag(char r)
    {
        if (r == 'I')
            return true;
        else if (r == 'V')
            return false;
        else if (r == 'X')
            return true;
        else throw new NoSuchElementException("wrong format!!");
    }

    // Finds decimal value of a given roman numbers
    public int romanToInteger()
    {
        // Initialize result and format
        int intNumber = 0;
        boolean boolFormat = true;

        for (int i=0; i<super.number.length(); i++)
        {
            // Getting value of symbol s[i]
            int s1 = value(super.number.charAt(i));

            // Getting value of symbol s[i+1]
            if (i+1 <super.number.length())
            {
                int s2 = value(super.number.charAt(i+1));

                // Comparing both values
                if (s1 >= s2)
                {
                    // Value of current symbol is greater
                    // or equal to the next symbolIV
                    intNumber = intNumber + s1;
                }
                else
                {
                    if (flag(super.number.charAt(i)))
                    {
                        if (boolFormat)
                        {
                            intNumber = intNumber + s2 - s1;
                            i++; // Value of current symbol is
                            // less than the next symbol
                            if (intNumber /10<1) boolFormat=false;
                        }
                        else throw new NoSuchElementException("wrong format!!");

                    }
                    else throw new NoSuchElementException("wrong format!!");
                }
            }
            else
            {
                if (boolFormat)
                {
                    intNumber = intNumber + s1;
                    i++;
                }
                else throw new NoSuchElementException("wrong format!!");
            }
        }

        return intNumber;
    }
}

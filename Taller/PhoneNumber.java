package Taller;

public class PhoneNumber implements Comparable<PhoneNumber> {
    private int areaCode;
    private int prefix;
    private int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    @Override
    public int compareTo(PhoneNumber elem) {
        int cmp;
        if ((cmp = Integer.compare(areaCode,elem.areaCode)) == 0) {
            if ((cmp = Integer.compare(prefix,elem.prefix)) == 0){
                cmp = Integer.compare(lineNumber, elem.lineNumber);
            }
        }
        return cmp;
    }
}

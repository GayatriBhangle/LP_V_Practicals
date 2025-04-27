import StringReverseApp.StringReversePOA;

public class StringReverseImpl extends StringReversePOA {

    @Override
    public String reverseString(String inputStr) {
        return new StringBuilder(inputStr).reverse().toString();
    }
}

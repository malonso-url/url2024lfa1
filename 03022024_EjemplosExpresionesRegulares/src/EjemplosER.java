import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EjemplosER{

    public static boolean isSetqValid(String value){
        Pattern pattern = Pattern.compile("^setq[ ]+[a-zA-z]+[ ]+[0-9]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public static boolean isSetqValidForStrings(String value){
        Pattern pattern = Pattern.compile("^setq[ ]+[a-zA-z]+[ ]+\"[a-zA-Z0-9]+\"$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public static boolean isAComment(String value){
        Pattern pattern = Pattern.compile("^\\+.+>>$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public static boolean isASequenceOfAsBs(String value){
        Pattern pattern = Pattern.compile("^[a][a]*[b]*[b]$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public static boolean isAIntegerNotStartingZero(String value){
        Pattern pattern = Pattern.compile("^(0|[123456789][1234567890]*)$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
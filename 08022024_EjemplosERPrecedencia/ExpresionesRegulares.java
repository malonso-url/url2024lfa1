import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesRegulares{

    public static boolean isValidURL(String url){
        
        Pattern pattern = Pattern.compile("^(https?://)?(www.)?[a-zA-Z0-9_\\.\\-]+([\\.][a-zA-Z]+)+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        return  matcher.find();
    }

    public static boolean isValidEmail(String email){
        String username = email.split("@")[0];
        String domain = email.split("@")[1];
        return  emailUserIsCorrect(username) && emailDomainIsCorrect(domain);
    }

    private static boolean emailUserIsCorrect(String username){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9_\\.\\-]*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(username);
        return  matcher.find();
    }

    private static boolean emailDomainIsCorrect(String domain){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9_\\-]*([\\.][a-zA-Z]+)+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(domain);
        return  matcher.find();
    }

}
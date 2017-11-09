package id.co.tripoin.email.validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created on 11/9/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class Main {

    public static void main(String [] args) {
        String emailToValidate = "kukuh_pambudi@yahoo.com";
        if (validateByString(emailToValidate)) {
            if (validateByInternet(emailToValidate)) {
                System.out.println("Email Valid");
            }else {
                System.out.println("Email is not registered on internet");
            }
        }else {
            System.out.println("email pattern is not valid");
        }
    }

    public static boolean validateByString(String p_Email) {
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        p_Email = p_Email.trim();
        return p_Email.matches(emailPattern) && p_Email.length() > 0;
    }

    public static boolean validateByInternet(String p_Email) {
        try {
            InternetAddress internetAddress = new InternetAddress(p_Email);
            internetAddress.validate();
            return true;
        } catch (AddressException e) {
            System.out.println("Email is not valid / available");
            return false;
        }
    }
}

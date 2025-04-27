import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import StringReverseApp.StringReverse;
import StringReverseApp.StringReverseHelper;
import java.util.Scanner;

public class StringReverseClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            StringReverse reverseRef = StringReverseHelper.narrow(ncRef.resolve_str("StringReverseService"));

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter string to reverse: ");
            String input = sc.nextLine();
            
            String result = reverseRef.reverseString(input);
            System.out.println("Reversed String: " + result);
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import StringUppercaseApp.StringUppercase;
import StringUppercaseApp.StringUppercaseHelper;
import java.util.Scanner;

public class StringUppercaseClient {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            StringUppercase stringObj = StringUppercaseHelper.narrow(ncRef.resolve_str("StringUppercaseService"));

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter string to convert to UPPERCASE: ");
            String input = sc.nextLine();

            String result = stringObj.toUpperCase(input);
            System.out.println("Uppercased String: " + result);

        } catch (Exception e) {
            System.out.println("Client Exception: " + e);
            e.printStackTrace(System.out);
        }
    }
}

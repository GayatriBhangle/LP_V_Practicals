import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import StringReverseApp.StringReverse;
import StringReverseApp.StringReverseHelper;

public class StringReverseServer {
    public static void main(String[] args) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA and activate the POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create servant and register it with ORB
            StringReverseImpl reverseImpl = new StringReverseImpl();

            // Get object reference from servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(reverseImpl);
            StringReverse href = StringReverseHelper.narrow(ref);

            // Get the Naming Service reference
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Bind the object reference in naming
            NameComponent path[] = ncRef.to_name("StringReverseService");
            ncRef.rebind(path, href);

            System.out.println("String Reverse Server Ready...");

            // Wait for incoming requests
            orb.run();

        } catch (Exception e) {
            System.out.println("Server Exception: " + e);
            e.printStackTrace(System.out);
        }
    }
}

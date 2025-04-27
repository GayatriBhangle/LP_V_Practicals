import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import StringUppercaseApp.StringUppercase;
import StringUppercaseApp.StringUppercaseHelper;

public class StringUppercaseServer {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);

            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            StringUppercaseImpl impl = new StringUppercaseImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(impl);
            StringUppercase href = StringUppercaseHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            NameComponent path[] = ncRef.to_name("StringUppercaseService");
            ncRef.rebind(path, href);

            System.out.println("String Uppercase Server Ready...");

            orb.run();
        } catch (Exception e) {
            System.out.println("Server Exception: " + e);
            e.printStackTrace(System.out);
        }
    }
}

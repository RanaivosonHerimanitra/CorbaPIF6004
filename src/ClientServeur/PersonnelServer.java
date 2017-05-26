package ClientServeur;

import PersonnelAPP.*;
import ClientServeur.*;
import org.omg.CosNaming.*; 
import org.omg.CosNaming.NamingContextPackage.*;

import java.util.Properties;

import org.omg.CORBA.*;     
import org.omg.PortableServer.*;   
import org.omg.PortableServer.POA;


public class PersonnelServer 
{
    public static void main(String args[]) 
    {
	try { 
		Properties props = new Properties();
        props.put("org.omg.CORBA.ORBInitialPort", "1000");
        props.put("org.omg.CORBA.ORBInitialHost", "192.168.0.187");
        ORB orb = ORB.init(args, props);
	   // ORB orb = ORB.init(args, null); 

	    POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));  
	    rootpoa.the_POAManager().activate(); 

	    PersonnelServant PersonnelImpl = new PersonnelServant();
	    PersonnelImpl.setORB(orb);   

	    org.omg.CORBA.Object personnelRef = rootpoa.servant_to_reference(PersonnelImpl);
	    Personnel personnelHref = PersonnelHelper.narrow(personnelRef);
	    
	    org.omg.CORBA.Object objRef = 
		           orb.resolve_initial_references("NameService");
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

	    String name = "Personnel";
	    NameComponent path[] = ncRef.to_name(name);
	    ncRef.rebind(path, personnelHref);

	    orb.run();
	}
	    
	catch(Exception e) {
	    System.err.println("ERROR : " + e);
	    e.printStackTrace(System.out);
	}
    }
}

package PersonnelAPP;


/**
* PersonnelAPP/PersonnelPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PersonnelAPP.idl
* jeudi 1 juin 2017 14 h 49 EDT
*/


//Service de l'App
public abstract class PersonnelPOA extends org.omg.PortableServer.Servant
 implements PersonnelAPP.PersonnelOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("creerEnseignant", new java.lang.Integer (0));
    _methods.put ("creerEtudiant", new java.lang.Integer (1));
    _methods.put ("chercherEnseignant", new java.lang.Integer (2));
    _methods.put ("chercherEtudiant", new java.lang.Integer (3));
    _methods.put ("AfficherEnseigants", new java.lang.Integer (4));
    _methods.put ("AfficherEtudiants", new java.lang.Integer (5));
    _methods.put ("supprimerEtudiant", new java.lang.Integer (6));
    _methods.put ("supprimerEnseigant", new java.lang.Integer (7));
    _methods.put ("modifierEnseignant", new java.lang.Integer (8));
    _methods.put ("modifierEtudiant", new java.lang.Integer (9));
    _methods.put ("shutdown", new java.lang.Integer (10));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // PersonnelAPP/Personnel/creerEnseignant
       {
         PersonnelAPP.Enseignant e = PersonnelAPP.EnseignantHelper.read (in);
         boolean $result = false;
         $result = this.creerEnseignant (e);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // PersonnelAPP/Personnel/creerEtudiant
       {
         PersonnelAPP.Etudiant e = PersonnelAPP.EtudiantHelper.read (in);
         boolean $result = false;
         $result = this.creerEtudiant (e);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // PersonnelAPP/Personnel/chercherEnseignant
       {
         String nom = in.read_string ();
         String prenom = in.read_string ();
         PersonnelAPP.Enseignant $result = null;
         $result = this.chercherEnseignant (nom, prenom);
         out = $rh.createReply();
         PersonnelAPP.EnseignantHelper.write (out, $result);
         break;
       }

       case 3:  // PersonnelAPP/Personnel/chercherEtudiant
       {
         String nom = in.read_string ();
         String prenom = in.read_string ();
         PersonnelAPP.Etudiant $result = null;
         $result = this.chercherEtudiant (nom, prenom);
         out = $rh.createReply();
         PersonnelAPP.EtudiantHelper.write (out, $result);
         break;
       }

       case 4:  // PersonnelAPP/Personnel/AfficherEnseigants
       {
         PersonnelAPP.Enseignant $result[] = null;
         $result = this.AfficherEnseigants ();
         out = $rh.createReply();
         PersonnelAPP.EnseignantsHelper.write (out, $result);
         break;
       }

       case 5:  // PersonnelAPP/Personnel/AfficherEtudiants
       {
         PersonnelAPP.Etudiant $result[] = null;
         $result = this.AfficherEtudiants ();
         out = $rh.createReply();
         PersonnelAPP.EtudiantsHelper.write (out, $result);
         break;
       }

       case 6:  // PersonnelAPP/Personnel/supprimerEtudiant
       {
         PersonnelAPP.Etudiant e = PersonnelAPP.EtudiantHelper.read (in);
         this.supprimerEtudiant (e);
         out = $rh.createReply();
         break;
       }

       case 7:  // PersonnelAPP/Personnel/supprimerEnseigant
       {
         PersonnelAPP.Enseignant e = PersonnelAPP.EnseignantHelper.read (in);
         this.supprimerEnseigant (e);
         out = $rh.createReply();
         break;
       }

       case 8:  // PersonnelAPP/Personnel/modifierEnseignant
       {
         PersonnelAPP.Enseignant e = PersonnelAPP.EnseignantHelper.read (in);
         PersonnelAPP.Enseignant newEnseigant = PersonnelAPP.EnseignantHelper.read (in);
         this.modifierEnseignant (e, newEnseigant);
         out = $rh.createReply();
         break;
       }

       case 9:  // PersonnelAPP/Personnel/modifierEtudiant
       {
         PersonnelAPP.Etudiant e = PersonnelAPP.EtudiantHelper.read (in);
         PersonnelAPP.Etudiant newEtudiant = PersonnelAPP.EtudiantHelper.read (in);
         this.modifierEtudiant (e, newEtudiant);
         out = $rh.createReply();
         break;
       }

       case 10:  // PersonnelAPP/Personnel/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:PersonnelAPP/Personnel:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Personnel _this() 
  {
    return PersonnelHelper.narrow(
    super._this_object());
  }

  public Personnel _this(org.omg.CORBA.ORB orb) 
  {
    return PersonnelHelper.narrow(
    super._this_object(orb));
  }


} // class PersonnelPOA

package PersonnelAPP;


/**
* PersonnelAPP/EnseignantsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PersonnelAPP.idl
* jeudi 1 juin 2017 15 h 55 EDT
*/

public final class EnseignantsHolder implements org.omg.CORBA.portable.Streamable
{
  public PersonnelAPP.Enseignant value[] = null;

  public EnseignantsHolder ()
  {
  }

  public EnseignantsHolder (PersonnelAPP.Enseignant[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PersonnelAPP.EnseignantsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PersonnelAPP.EnseignantsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PersonnelAPP.EnseignantsHelper.type ();
  }

}

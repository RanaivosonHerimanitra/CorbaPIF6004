package PersonnelAPP;

/**
* PersonnelAPP/EnseignantHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PersonnelAPP.idl
* jeudi 1 juin 2017 14 h 49 EDT
*/

public final class EnseignantHolder implements org.omg.CORBA.portable.Streamable
{
  public PersonnelAPP.Enseignant value = null;

  public EnseignantHolder ()
  {
  }

  public EnseignantHolder (PersonnelAPP.Enseignant initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PersonnelAPP.EnseignantHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PersonnelAPP.EnseignantHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PersonnelAPP.EnseignantHelper.type ();
  }

}

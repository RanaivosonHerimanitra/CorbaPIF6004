package PersonnelAPP;

/**
* PersonnelAPP/EtudiantHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PersonnelAPP.idl
* jeudi 1 juin 2017 14 h 13 EDT
*/

public final class EtudiantHolder implements org.omg.CORBA.portable.Streamable
{
  public PersonnelAPP.Etudiant value = null;

  public EtudiantHolder ()
  {
  }

  public EtudiantHolder (PersonnelAPP.Etudiant initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PersonnelAPP.EtudiantHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PersonnelAPP.EtudiantHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PersonnelAPP.EtudiantHelper.type ();
  }

}

package PersonnelAPP;

/**
* PersonnelAPP/PersonInfoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PersonnelAPP.idl
* vendredi 2 juin 2017 14 h 53 EDT
*/

public final class PersonInfoHolder implements org.omg.CORBA.portable.Streamable
{
  public PersonnelAPP.PersonInfo value = null;

  public PersonInfoHolder ()
  {
  }

  public PersonInfoHolder (PersonnelAPP.PersonInfo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PersonnelAPP.PersonInfoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PersonnelAPP.PersonInfoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PersonnelAPP.PersonInfoHelper.type ();
  }

}

package PersonnelAPP;


/**
* PersonnelAPP/EnseignantsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PersonnelAPP.idl
* mardi 23 mai 2017 13 h 17 EDT
*/


//*
abstract public class EnseignantsHelper
{
  private static String  _id = "IDL:PersonnelAPP/Enseignants:1.0";

  public static void insert (org.omg.CORBA.Any a, PersonnelAPP.Enseignant[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static PersonnelAPP.Enseignant[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = PersonnelAPP.EnseignantHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (PersonnelAPP.EnseignantsHelper.id (), "Enseignants", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static PersonnelAPP.Enseignant[] read (org.omg.CORBA.portable.InputStream istream)
  {
    PersonnelAPP.Enseignant value[] = null;
    int _len0 = istream.read_long ();
    value = new PersonnelAPP.Enseignant[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = PersonnelAPP.EnseignantHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, PersonnelAPP.Enseignant[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      PersonnelAPP.EnseignantHelper.write (ostream, value[_i0]);
  }

}
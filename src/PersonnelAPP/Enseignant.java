package PersonnelAPP;


/**
* PersonnelAPP/Enseignant.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from PersonnelAPP.idl
* jeudi 1 juin 2017 14 h 13 EDT
*/

public final class Enseignant implements org.omg.CORBA.portable.IDLEntity
{
  public PersonnelAPP.PersonInfo p = null;
  public long tel = (long)0;
  public long post = (long)0;

  public Enseignant ()
  {
  } // ctor

  public Enseignant (PersonnelAPP.PersonInfo _p, long _tel, long _post)
  {
    p = _p;
    tel = _tel;
    post = _post;
  } // ctor

} // class Enseignant

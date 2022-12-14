/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 18 "CodeJava.ump"
public class Empresa
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Empresa Attributes
  private double ruc;
  private String descripcion;
  private String tipo;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetRuc;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Empresa(double aRuc, String aDescripcion, String aTipo)
  {
    cachedHashCode = -1;
    canSetRuc = true;
    ruc = aRuc;
    descripcion = aDescripcion;
    tipo = aTipo;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRuc(double aRuc)
  {
    boolean wasSet = false;
    if (!canSetRuc) { return false; }
    ruc = aRuc;
    wasSet = true;
    return wasSet;
  }

  public boolean setDescripcion(String aDescripcion)
  {
    boolean wasSet = false;
    descripcion = aDescripcion;
    wasSet = true;
    return wasSet;
  }

  public boolean setTipo(String aTipo)
  {
    boolean wasSet = false;
    tipo = aTipo;
    wasSet = true;
    return wasSet;
  }

  public double getRuc()
  {
    return ruc;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public String getTipo()
  {
    return tipo;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Empresa compareTo = (Empresa)obj;
  
    if (getRuc() != compareTo.getRuc())
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + (Double.valueOf(getRuc())).hashCode();

    canSetRuc = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
    return "["+
            "ruc" + ":" + getRuc()+ "," +
            "descripcion" + ":" + getDescripcion()+ "," +
            "tipo" + ":" + getTipo()+ "]";
  }
}
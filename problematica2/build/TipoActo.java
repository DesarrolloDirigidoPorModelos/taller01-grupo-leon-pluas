/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 34 "CodeJava.ump"
public class TipoActo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TipoActo Attributes
  private String codigo;
  private String descripcion;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCodigo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TipoActo(String aCodigo, String aDescripcion)
  {
    cachedHashCode = -1;
    canSetCodigo = true;
    codigo = aCodigo;
    descripcion = aDescripcion;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCodigo(String aCodigo)
  {
    boolean wasSet = false;
    if (!canSetCodigo) { return false; }
    codigo = aCodigo;
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

  public String getCodigo()
  {
    return codigo;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    TipoActo compareTo = (TipoActo)obj;
  
    if (getCodigo() == null && compareTo.getCodigo() != null)
    {
      return false;
    }
    else if (getCodigo() != null && !getCodigo().equals(compareTo.getCodigo()))
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
    if (getCodigo() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getCodigo().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetCodigo = false;
    return cachedHashCode;
  }

  public void delete()
  {}


  public String toString()
  {
    return "["+
            "codigo" + ":" + getCodigo()+ "," +
            "descripcion" + ":" + getDescripcion()+ "]";
  }
}
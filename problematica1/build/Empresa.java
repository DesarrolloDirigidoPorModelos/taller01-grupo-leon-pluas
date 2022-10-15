/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 19 "CodeJava.ump"
public class Empresa
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Empresa Attributes
  private double ruc;
  private String descripcion;
  private String tipo;

  //Empresa Associations
  private Acto acto;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetRuc;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Empresa(double aRuc, String aDescripcion, String aTipo, Acto aActo)
  {
    cachedHashCode = -1;
    canSetRuc = true;
    ruc = aRuc;
    descripcion = aDescripcion;
    tipo = aTipo;
    if (aActo == null || aActo.getEmpresa() != null)
    {
      throw new RuntimeException("Unable to create Empresa due to aActo. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    acto = aActo;
  }

  public Empresa(double aRuc, String aDescripcion, String aTipo, String aCodigoForActo, String aNombreForActo, String aLugarForActo, double aCostoTotalForActo, TipoActo aTipoForActo, TipoActo aTipoActoForActo, Persona aPersonaForActo)
  {
    ruc = aRuc;
    descripcion = aDescripcion;
    tipo = aTipo;
    acto = new Acto(aCodigoForActo, aNombreForActo, aLugarForActo, aCostoTotalForActo, aTipoForActo, this, aTipoActoForActo, aPersonaForActo);
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
  /* Code from template association_GetOne */
  public Acto getActo()
  {
    return acto;
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
  {
    Acto existingActo = acto;
    acto = null;
    if (existingActo != null)
    {
      existingActo.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "ruc" + ":" + getRuc()+ "," +
            "descripcion" + ":" + getDescripcion()+ "," +
            "tipo" + ":" + getTipo()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "acto = "+(getActo()!=null?Integer.toHexString(System.identityHashCode(getActo())):"null");
  }
}
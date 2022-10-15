/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 6 "CodeJava.ump"
public class Acto
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Acto Attributes
  private String codigo;
  private String nombre;
  private String lugar;
  private double costoTotal;
  private TipoActo tipo;

  //Acto Associations
  private Empresa empresa;
  private TipoActo tipoActo;
  private Persona persona;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCodigo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Acto(String aCodigo, String aNombre, String aLugar, double aCostoTotal, TipoActo aTipo, Empresa aEmpresa, TipoActo aTipoActo, Persona aPersona)
  {
    cachedHashCode = -1;
    canSetCodigo = true;
    codigo = aCodigo;
    nombre = aNombre;
    lugar = aLugar;
    costoTotal = aCostoTotal;
    tipo = aTipo;
    if (aEmpresa == null || aEmpresa.getActo() != null)
    {
      throw new RuntimeException("Unable to create Acto due to aEmpresa. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    empresa = aEmpresa;
    if (!setTipoActo(aTipoActo))
    {
      throw new RuntimeException("Unable to create Acto due to aTipoActo. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPersona = setPersona(aPersona);
    if (!didAddPersona)
    {
      throw new RuntimeException("Unable to create acto due to persona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public Acto(String aCodigo, String aNombre, String aLugar, double aCostoTotal, TipoActo aTipo, double aRucForEmpresa, String aDescripcionForEmpresa, String aTipoForEmpresa, TipoActo aTipoActo, Persona aPersona)
  {
    codigo = aCodigo;
    nombre = aNombre;
    lugar = aLugar;
    costoTotal = aCostoTotal;
    tipo = aTipo;
    empresa = new Empresa(aRucForEmpresa, aDescripcionForEmpresa, aTipoForEmpresa, this);
    boolean didAddTipoActo = setTipoActo(aTipoActo);
    if (!didAddTipoActo)
    {
      throw new RuntimeException("Unable to create acto due to tipoActo. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPersona = setPersona(aPersona);
    if (!didAddPersona)
    {
      throw new RuntimeException("Unable to create acto due to persona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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

  public boolean setNombre(String aNombre)
  {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setLugar(String aLugar)
  {
    boolean wasSet = false;
    lugar = aLugar;
    wasSet = true;
    return wasSet;
  }

  public boolean setCostoTotal(double aCostoTotal)
  {
    boolean wasSet = false;
    costoTotal = aCostoTotal;
    wasSet = true;
    return wasSet;
  }

  public boolean setTipo(TipoActo aTipo)
  {
    boolean wasSet = false;
    tipo = aTipo;
    wasSet = true;
    return wasSet;
  }

  public String getCodigo()
  {
    return codigo;
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getLugar()
  {
    return lugar;
  }

  public double getCostoTotal()
  {
    return costoTotal;
  }

  public TipoActo getTipo()
  {
    return tipo;
  }
  /* Code from template association_GetOne */
  public Empresa getEmpresa()
  {
    return empresa;
  }
  /* Code from template association_GetOne */
  public TipoActo getTipoActo()
  {
    return tipoActo;
  }
  /* Code from template association_GetOne */
  public Persona getPersona()
  {
    return persona;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setTipoActo(TipoActo aNewTipoActo)
  {
    boolean wasSet = false;
    if (aNewTipoActo != null)
    {
      tipoActo = aNewTipoActo;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPersona(Persona aPersona)
  {
    boolean wasSet = false;
    if (aPersona == null)
    {
      return wasSet;
    }

    Persona existingPersona = persona;
    persona = aPersona;
    if (existingPersona != null && !existingPersona.equals(aPersona))
    {
      existingPersona.removeActo(this);
    }
    persona.addActo(this);
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Acto compareTo = (Acto)obj;
  
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
  {
    Empresa existingEmpresa = empresa;
    empresa = null;
    if (existingEmpresa != null)
    {
      existingEmpresa.delete();
    }
    tipoActo = null;
    Persona placeholderPersona = persona;
    this.persona = null;
    if(placeholderPersona != null)
    {
      placeholderPersona.removeActo(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "codigo" + ":" + getCodigo()+ "," +
            "nombre" + ":" + getNombre()+ "," +
            "lugar" + ":" + getLugar()+ "," +
            "costoTotal" + ":" + getCostoTotal()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tipo" + "=" + (getTipo() != null ? !getTipo().equals(this)  ? getTipo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "empresa = "+(getEmpresa()!=null?Integer.toHexString(System.identityHashCode(getEmpresa())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "tipoActo = "+(getTipoActo()!=null?Integer.toHexString(System.identityHashCode(getTipoActo())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "persona = "+(getPersona()!=null?Integer.toHexString(System.identityHashCode(getPersona())):"null");
  }
}
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 14 "CodeJava1.ump"
public class Turno
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Turno Attributes
  private String codigo;
  private String descripcion;

  //Turno Associations
  private Tematica tematica;
  private Persona persona;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetCodigo;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Turno(String aCodigo, String aDescripcion, Tematica aTematica, Persona aPersona)
  {
    cachedHashCode = -1;
    canSetCodigo = true;
    codigo = aCodigo;
    descripcion = aDescripcion;
    if (!setTematica(aTematica))
    {
      throw new RuntimeException("Unable to create Turno due to aTematica. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPersona = setPersona(aPersona);
    if (!didAddPersona)
    {
      throw new RuntimeException("Unable to create turno due to persona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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
  /* Code from template association_GetOne */
  public Tematica getTematica()
  {
    return tematica;
  }
  /* Code from template association_GetOne */
  public Persona getPersona()
  {
    return persona;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setTematica(Tematica aNewTematica)
  {
    boolean wasSet = false;
    if (aNewTematica != null)
    {
      tematica = aNewTematica;
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
      existingPersona.removeTurno(this);
    }
    persona.addTurno(this);
    wasSet = true;
    return wasSet;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Turno compareTo = (Turno)obj;
  
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
    tematica = null;
    Persona placeholderPersona = persona;
    this.persona = null;
    if(placeholderPersona != null)
    {
      placeholderPersona.removeTurno(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "codigo" + ":" + getCodigo()+ "," +
            "descripcion" + ":" + getDescripcion()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tematica = "+(getTematica()!=null?Integer.toHexString(System.identityHashCode(getTematica())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "persona = "+(getPersona()!=null?Integer.toHexString(System.identityHashCode(getPersona())):"null");
  }
}
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 27 "CodeJava.ump"
public class Persona
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Persona Attributes
  private String dni;
  private String nombre;

  //Persona Associations
  private List<Acto> actos;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetDni;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Persona(String aDni, String aNombre)
  {
    cachedHashCode = -1;
    canSetDni = true;
    dni = aDni;
    nombre = aNombre;
    actos = new ArrayList<Acto>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDni(String aDni)
  {
    boolean wasSet = false;
    if (!canSetDni) { return false; }
    dni = aDni;
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

  public String getDni()
  {
    return dni;
  }

  public String getNombre()
  {
    return nombre;
  }
  /* Code from template association_GetMany */
  public Acto getActo(int index)
  {
    Acto aActo = actos.get(index);
    return aActo;
  }

  public List<Acto> getActos()
  {
    List<Acto> newActos = Collections.unmodifiableList(actos);
    return newActos;
  }

  public int numberOfActos()
  {
    int number = actos.size();
    return number;
  }

  public boolean hasActos()
  {
    boolean has = actos.size() > 0;
    return has;
  }

  public int indexOfActo(Acto aActo)
  {
    int index = actos.indexOf(aActo);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfActos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Acto addActo(String aCodigo, String aNombre, String aLugar, double aCostoTotal, TipoActo aTipo, Empresa aEmpresa, TipoActo aTipoActo)
  {
    return new Acto(aCodigo, aNombre, aLugar, aCostoTotal, aTipo, aEmpresa, aTipoActo, this);
  }

  public boolean addActo(Acto aActo)
  {
    boolean wasAdded = false;
    if (actos.contains(aActo)) { return false; }
    Persona existingPersona = aActo.getPersona();
    boolean isNewPersona = existingPersona != null && !this.equals(existingPersona);
    if (isNewPersona)
    {
      aActo.setPersona(this);
    }
    else
    {
      actos.add(aActo);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeActo(Acto aActo)
  {
    boolean wasRemoved = false;
    //Unable to remove aActo, as it must always have a persona
    if (!this.equals(aActo.getPersona()))
    {
      actos.remove(aActo);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addActoAt(Acto aActo, int index)
  {  
    boolean wasAdded = false;
    if(addActo(aActo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActos()) { index = numberOfActos() - 1; }
      actos.remove(aActo);
      actos.add(index, aActo);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveActoAt(Acto aActo, int index)
  {
    boolean wasAdded = false;
    if(actos.contains(aActo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfActos()) { index = numberOfActos() - 1; }
      actos.remove(aActo);
      actos.add(index, aActo);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addActoAt(aActo, index);
    }
    return wasAdded;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Persona compareTo = (Persona)obj;
  
    if (getDni() == null && compareTo.getDni() != null)
    {
      return false;
    }
    else if (getDni() != null && !getDni().equals(compareTo.getDni()))
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
    if (getDni() != null)
    {
      cachedHashCode = cachedHashCode * 23 + getDni().hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    canSetDni = false;
    return cachedHashCode;
  }

  public void delete()
  {
    for(int i=actos.size(); i > 0; i--)
    {
      Acto aActo = actos.get(i - 1);
      aActo.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "dni" + ":" + getDni()+ "," +
            "nombre" + ":" + getNombre()+ "]";
  }
}
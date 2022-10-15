/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 30 "CodeJava1.ump"
public class Persona
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Persona Attributes
  private String dni;
  private String nombre;

  //Persona Associations
  private List<Turno> turnos;

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
    turnos = new ArrayList<Turno>();
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
  public Turno getTurno(int index)
  {
    Turno aTurno = turnos.get(index);
    return aTurno;
  }

  public List<Turno> getTurnos()
  {
    List<Turno> newTurnos = Collections.unmodifiableList(turnos);
    return newTurnos;
  }

  public int numberOfTurnos()
  {
    int number = turnos.size();
    return number;
  }

  public boolean hasTurnos()
  {
    boolean has = turnos.size() > 0;
    return has;
  }

  public int indexOfTurno(Turno aTurno)
  {
    int index = turnos.indexOf(aTurno);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTurnos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Turno addTurno(String aCodigo, String aDescripcion, Tematica aTematica)
  {
    return new Turno(aCodigo, aDescripcion, aTematica, this);
  }

  public boolean addTurno(Turno aTurno)
  {
    boolean wasAdded = false;
    if (turnos.contains(aTurno)) { return false; }
    Persona existingPersona = aTurno.getPersona();
    boolean isNewPersona = existingPersona != null && !this.equals(existingPersona);
    if (isNewPersona)
    {
      aTurno.setPersona(this);
    }
    else
    {
      turnos.add(aTurno);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTurno(Turno aTurno)
  {
    boolean wasRemoved = false;
    //Unable to remove aTurno, as it must always have a persona
    if (!this.equals(aTurno.getPersona()))
    {
      turnos.remove(aTurno);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTurnoAt(Turno aTurno, int index)
  {  
    boolean wasAdded = false;
    if(addTurno(aTurno))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTurnos()) { index = numberOfTurnos() - 1; }
      turnos.remove(aTurno);
      turnos.add(index, aTurno);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTurnoAt(Turno aTurno, int index)
  {
    boolean wasAdded = false;
    if(turnos.contains(aTurno))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTurnos()) { index = numberOfTurnos() - 1; }
      turnos.remove(aTurno);
      turnos.add(index, aTurno);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTurnoAt(aTurno, index);
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
    for(int i=turnos.size(); i > 0; i--)
    {
      Turno aTurno = turnos.get(i - 1);
      aTurno.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "dni" + ":" + getDni()+ "," +
            "nombre" + ":" + getNombre()+ "]";
  }
}
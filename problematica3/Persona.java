/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

import java.util.*;

// line 1 "medidor.ump"
public class Persona {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // Persona Attributes
  private String nombre;
  private String apellido;
  private int dni;

  // Persona Associations
  private List<Medidor> medidors;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public Persona(String aNombre, String aApellido, int aDni) {
    nombre = aNombre;
    apellido = aApellido;
    dni = aDni;
    medidors = new ArrayList<Medidor>();
  }

  // ------------------------
  // INTERFACE
  // ------------------------

  public boolean setNombre(String aNombre) {
    boolean wasSet = false;
    nombre = aNombre;
    wasSet = true;
    return wasSet;
  }

  public boolean setApellido(String aApellido) {
    boolean wasSet = false;
    apellido = aApellido;
    wasSet = true;
    return wasSet;
  }

  public boolean setDni(int aDni) {
    boolean wasSet = false;
    dni = aDni;
    wasSet = true;
    return wasSet;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public int getDni() {
    return dni;
  }

  /* Code from template association_GetMany */
  public Medidor getMedidor(int index) {
    Medidor aMedidor = medidors.get(index);
    return aMedidor;
  }

  public List<Medidor> getMedidors() {
    List<Medidor> newMedidors = Collections.unmodifiableList(medidors);
    return newMedidors;
  }

  public int numberOfMedidors() {
    int number = medidors.size();
    return number;
  }

  public boolean hasMedidors() {
    boolean has = medidors.size() > 0;
    return has;
  }

  public int indexOfMedidor(Medidor aMedidor) {
    int index = medidors.indexOf(aMedidor);
    return index;
  }

  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMedidors() {
    return 0;
  }

  /* Code from template association_AddManyToOne */
  public Medidor addMedidor(String aMarca, String aDireccion, double aCosto) {
    return new Medidor(aMarca, aDireccion, aCosto, this);
  }

  public boolean addMedidor(Medidor aMedidor) {
    boolean wasAdded = false;
    if (medidors.contains(aMedidor)) {
      return false;
    }
    Persona existingPersona = aMedidor.getPersona();
    boolean isNewPersona = existingPersona != null && !this.equals(existingPersona);
    if (isNewPersona) {
      aMedidor.setPersona(this);
    } else {
      medidors.add(aMedidor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMedidor(Medidor aMedidor) {
    boolean wasRemoved = false;
    // Unable to remove aMedidor, as it must always have a persona
    if (!this.equals(aMedidor.getPersona())) {
      medidors.remove(aMedidor);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  /* Code from template association_AddIndexControlFunctions */
  public boolean addMedidorAt(Medidor aMedidor, int index) {
    boolean wasAdded = false;
    if (addMedidor(aMedidor)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfMedidors()) {
        index = numberOfMedidors() - 1;
      }
      medidors.remove(aMedidor);
      medidors.add(index, aMedidor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMedidorAt(Medidor aMedidor, int index) {
    boolean wasAdded = false;
    if (medidors.contains(aMedidor)) {
      if (index < 0) {
        index = 0;
      }
      if (index > numberOfMedidors()) {
        index = numberOfMedidors() - 1;
      }
      medidors.remove(aMedidor);
      medidors.add(index, aMedidor);
      wasAdded = true;
    } else {
      wasAdded = addMedidorAt(aMedidor, index);
    }
    return wasAdded;
  }

  public void delete() {
    for (int i = medidors.size(); i > 0; i--) {
      Medidor aMedidor = medidors.get(i - 1);
      aMedidor.delete();
    }
  }

  public String toString() {
    return super.toString() + "[" +
        "nombre" + ":" + getNombre() + "," +
        "apellido" + ":" + getApellido() + "," +
        "dni" + ":" + getDni() + "]";
  }
}
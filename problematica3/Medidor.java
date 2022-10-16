/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

// line 13 "medidor.ump"
public class Medidor {

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // Medidor Attributes
  private String marca;
  private String direccion;
  private double costo;

  // Medidor Associations
  private Persona persona;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------

  public Medidor(String aMarca, String aDireccion, double aCosto, Persona aPersona) {
    marca = aMarca;
    direccion = aDireccion;
    costo = aCosto;
    boolean didAddPersona = setPersona(aPersona);
    if (!didAddPersona) {
      throw new RuntimeException(
          "Unable to create medidor due to persona. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  // ------------------------
  // INTERFACE
  // ------------------------

  public boolean setMarca(String aMarca) {
    boolean wasSet = false;
    marca = aMarca;
    wasSet = true;
    return wasSet;
  }

  public boolean setDireccion(String aDireccion) {
    boolean wasSet = false;
    direccion = aDireccion;
    wasSet = true;
    return wasSet;
  }

  public boolean setCosto(double aCosto) {
    boolean wasSet = false;
    costo = aCosto;
    wasSet = true;
    return wasSet;
  }

  public String getMarca() {
    return marca;
  }

  public String getDireccion() {
    return direccion;
  }

  public double getCosto() {
    return costo;
  }

  /* Code from template association_GetOne */
  public Persona getPersona() {
    return persona;
  }

  /* Code from template association_SetOneToMany */
  public boolean setPersona(Persona aPersona) {
    boolean wasSet = false;
    if (aPersona == null) {
      return wasSet;
    }

    Persona existingPersona = persona;
    persona = aPersona;
    if (existingPersona != null && !existingPersona.equals(aPersona)) {
      existingPersona.removeMedidor(this);
    }
    persona.addMedidor(this);
    wasSet = true;
    return wasSet;
  }

  public void delete() {
    Persona placeholderPersona = persona;
    this.persona = null;
    if (placeholderPersona != null) {
      placeholderPersona.removeMedidor(this);
    }
  }

  public String toString() {
    return super.toString() + "[" +
        "marca" + ":" + getMarca() + "," +
        "costo" + ":" + getCosto() + "]" + System.getProperties().getProperty("line.separator") +
        "  " + "direccion" + "="
        + (getDireccion() != null
            ? !getDireccion().equals(this) ? getDireccion().toString().replaceAll("  ", "    ") : "this"
            : "null")
        + System.getProperties().getProperty("line.separator") +
        "  " + "persona = "
        + (getPersona() != null ? Integer.toHexString(System.identityHashCode(getPersona())) : "null");
  }
}

public class Main
{

    public static void main (String [ ] args) {
        Persona persona = new Persona("0923645634", "José Plúas");
        TipoActo tipoActo = new TipoActo("1", "Tipo1");
        Empresa empresa = new Empresa(1723687412001.0, "Empresa 1", "privada");
        Acto acto = new Acto("1", "Acto1", "Centro", 12.2, empresa, tipoActo, persona);

        System.out.println("ResultingJSONstring = " + acto.toString());
        
    }
}
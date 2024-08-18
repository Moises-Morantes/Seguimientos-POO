package Personas;
import java.util.*;

public class ListaPersonasEj81 {
    Vector listaPersonas;
    
    public ListaPersonasEj81() {
        listaPersonas = new Vector();
    }
    
    public void añadirPersona(PersonaEj81 p) {
        listaPersonas.add(p);
    }

    public void eliminarPersona(int i) {
        listaPersonas.removeElementAt(i);
    }

    public void borrarLista() {
        listaPersonas.removeAllElements();
    }
}

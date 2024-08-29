package Personas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipalEj81 extends JFrame implements ActionListener {
    private ListaPersonasEj81 lista; 
    private Container contenedor;
    private JLabel nombre, apellidos, teléfono, dirección;
    private JTextField campoNombre, campoApellidos, campoTeléfono, campoDirección;
    private JButton añadir, eliminar, borrarLista; // Botones
    private JList listaNombres; // Lista de personas
    private DefaultListModel modelo; // Objeto que modela la lista
    private JScrollPane scrollLista; // Barra de desplazamiento vertical

    
    public VentanaPrincipalEj81(){
        lista = new ListaPersonasEj81(); 
        inicio();
        setTitle("Personas"); // Establece el título de la ventana
        setSize(270,350); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); /* La ventana se posiciona en elcentro de la pantalla */
        // Establece que el botón de cerrar permitirá salir de la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); /* Establece que el tamaño de la ventana no
        se puede cambiar */
    }

    private void inicio() {

        contenedor = getContentPane(); /* Obtiene el panel de contenidos de la ventana */
        contenedor.setLayout(null); /* Establece que el panel no tieneasociado ningún layout */

        // Establece la etiqueta y el campo nombre
        nombre = new JLabel();
        nombre.setText("Nombre:");
        nombre.setBounds(20, 20, 135, 23); /* Establece la posición de la etiqueta nombre */

        campoNombre = new JTextField(); // Establece la posición del campo de texto nombre
        campoNombre.setBounds(105, 20, 135, 23);

        // Establece la etiqueta y el campo apellidos
        apellidos = new JLabel();
        apellidos.setText("Apellidos:"); /* Establece la posición de la etiqueta apellidos */
        apellidos.setBounds(20, 50, 135, 23);

        campoApellidos = new JTextField(); // Establece la posición del campo de texto apellidos
        campoApellidos.setBounds(105, 50, 135, 23);

        // Establece la etiqueta y el campo teléfono
        teléfono = new JLabel();
        teléfono.setText("Teléfono:");
        teléfono.setBounds(20, 80, 135, 23); /* Establece la posición de la etiqueta teléfono */

        // Establece la posición del campo de texto teléfono
        campoTeléfono = new JTextField();
        campoTeléfono.setBounds(105, 80, 135, 23);

        // Establece la etiqueta y el campo dirección
        dirección = new JLabel();
        dirección.setText("Dirección:");
        dirección.setBounds(20, 110, 135, 23); /* Establece la posición de la etiqueta dirección */

        // Establece la posición del campo de texto dirección
        campoDirección = new JTextField();
        campoDirección.setBounds(105, 110, 135, 23);

        // Establece el botón Añadir persona
        añadir = new JButton();
        añadir.setText("«Añadir»");
        añadir.setBounds(105, 150, 100, 23); /* Establece la posición del botón Añadir persona */
        /* Agrega al botón un ActionListener para que gestione eventos del botón */
        añadir.addActionListener(this);

        // Establece el botón Eliminar persona
        eliminar= new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(20, 280, 80, 23); /* Establece la posición del botón Eliminar persona */
        /* Agrega al botón un ActionListener para que gestione eventos del botón */
        eliminar.addActionListener(this);

        // Establece el botón Borrar lista
        borrarLista= new JButton();
        borrarLista.setText("Borrar Lista");
        borrarLista.setBounds(120, 280, 120, 23); /* Establece la posición del botón Borrar lista */
        /* Agrega al botón un ActionListener para que gestione eventos del botón */
        borrarLista.addActionListener(this);

        // Establece la lista gráfica de personas
        listaNombres = new JList();
        /* Establece que se pueda seleccionar solamente un elemento de la lista */
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo = new DefaultListModel();
        // Establece una barra de desplazamiento vertical
        scrollLista = new JScrollPane();
        // Establece la posición de la barra de desplazamiento vertical
        scrollLista.setBounds(20, 190 ,220, 80);
        // Asocia la barra de desplazamiento vertical a la lista de personas
        scrollLista.setViewportView(listaNombres);
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(apellidos);
        contenedor.add(campoApellidos);
        contenedor.add(teléfono);
        contenedor.add(campoTeléfono);
        contenedor.add(dirección);
        contenedor.add(campoDirección);
        contenedor.add(añadir);
        contenedor.add(eliminar);
        contenedor.add(borrarLista);
        contenedor.add(scrollLista);
    }

    /**
     *
     * @param evento
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == añadir) { // Si se pulsa el botón añadir
            añadirPersona(); // Se invoca añadir persona
        }
        if (evento.getSource() == eliminar) { /* Si se pulsa el botón eliminar */
            /* Se invoca el método eliminarNombre que elimina el elemento seleccionado */
            eliminarNombre(listaNombres.getSelectedIndex() );
        }
        if (evento.getSource() == borrarLista) { /* Si se pulsa el botón borrar lista */
            borrarLista(); // Se invoca borrar lista
        }
    }

    private void añadirPersona() {
        /* Se obtienen los campos de texto ingresados y se crea una persona */
        PersonaEj81 p = new PersonaEj81(campoNombre.getText(),
        campoApellidos.getText(),
        campoTeléfono.getText(), campoDirección.getText());
        lista.añadirPersona(p); /* Se añade una persona al vector de
        personas */
        String elemento = campoNombre.getText() + "-" +
        campoApellidos.getText() +
        "-" + campoTeléfono.getText() + "-" + campoDirección.getText();
        modelo.addElement(elemento); /* Se agrega el texto con los
        datos de la persona al JList */
        listaNombres.setModel(modelo);
        // Se colocan todos los campos de texto nulos
        campoNombre.setText("");
        campoApellidos.setText("");
        campoTeléfono.setText("");
        campoDirección.setText("");
    }

    private void eliminarNombre(int indice) {
        if (indice >= 0) { // Si la posición existe
            modelo.removeElementAt(indice); /* Se elimina la persona seleccionada de la lista gráfica */
            lista.eliminarPersona(indice); /* Se elimina la persona seleccionada del vector de personas */
        } else { /* Si no se seleccionó ninguna persona, se genera un mensaje de error */
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento","Error",
            JOptionPane.ERROR_MESSAGE);
        }
    }

    private void borrarLista() {
        lista.borrarLista(); // Se eliminan todas las personas del vector
        modelo.clear(); // Limpia el JList, la lista gráfica de personas
    }
}

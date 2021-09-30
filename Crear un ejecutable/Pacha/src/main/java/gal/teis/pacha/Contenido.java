/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.pacha;

import gal.teis.ficheros.GestionFichero;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Estefania
 */
public class Contenido extends JPanel{
        
    //Colocar barra en la parte superior de la ventana y centrada
    JMenuBar elMenuBar = new JMenuBar();
    Texto elTextoCentral = new Texto();
    JMenuItem opArchivoCrear = new JMenuItem("Nuevo");
    JMenuItem opArchivoGuardar = new JMenuItem("Guardar");
    JMenuItem opArchivoGuardarComo = new JMenuItem("Guardar como");
    JMenuItem opArchivoAbrir = new JMenuItem("Abrir");

    JMenuItem opInfoPalabras = new JMenuItem("Ver nº de palabras");
    JMenuItem opInfoCaracteres = new JMenuItem("Ver nº de caracteres");
    JMenuItem opInfoVocales = new JMenuItem("Ver nº de vocales");
    JMenuItem opInfoLineas = new JMenuItem("Ver nº de líneas");
    JMenuItem opInfoPacha = new JMenuItem("Ver nº de 'Pacha'");

    JMenuItem opVerLineas = new JMenuItem("Añadir nº de línea");
    JMenuItem opOcultarLineas = new JMenuItem("Ocultar nº de línea");
    JMenuItem opQueenPacha = new JMenuItem("Queen Pacha");

    //Crear un JPanel para el menú
    JPanel barraMenu = new JPanel();

    JFileChooser fileChooser;

    Boolean activarGuardar = false;

    //Para detectar si se cambió algo en el JPanel para activar el botón de Guardar
    String textoJPanel = null;

    //Titulo de la ventana cuando el fichero aún no ha sido guardado
    String tituloNoGuardado = "Nuevo archivo-pacha";

    //Nombre de fichero actual
    String filename = "";

    Image img = Toolkit.getDefaultToolkit().getImage("Images/pacha3.jpg");

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 123, 20, this);   
    }

    public Contenido() {

        //Determino el tipo de Layout
        setLayout(new BorderLayout());
        crearMenu();

        //Agreagar el menú al JPanel
        barraMenu.add(elMenuBar);

        //Posicionar el JPanel de la barra de menú en el JPanel Contenido
        add(barraMenu, BorderLayout.NORTH);

        //Cear el panel para el contenido
        add(elTextoCentral, BorderLayout.CENTER);
        elTextoCentral.setVisible(false);

    }

    private void crearMenu() {

        //Creamos las opciones del menú
        JMenu opArchivo = new JMenu("Archivo");
        JMenu opEditar = new JMenu("Editar");
        JMenu opInformacion = new JMenu("Información");
        //Defino un JMenuItem porque un JMenu no permite agregar un detector de eventos 
        JMenuItem opCerrar = new JMenuItem("Salir");

        //Agreagar los elementos de menú a la barra de menú
        elMenuBar.add(opArchivo);
        elMenuBar.add(opEditar);
        elMenuBar.add(opInformacion);
        elMenuBar.add(opCerrar);

        //Desactivo guardar y guardar como para que solo estén activadas cuando 
        //haya un archivo abierto y se den otras opciones
        desactivarOpcionesIniciales();

        //Agrego las opciones que colgarán del menú Archivo
        opArchivo.add(opArchivoCrear);
        opArchivo.add(opArchivoGuardar);
        opArchivo.add(opArchivoGuardarComo);
        opArchivo.add(opArchivoAbrir);

        //Agrego las opciones que colgarán del menú Información
        opInformacion.add(opInfoPalabras);
        opInformacion.add(opInfoCaracteres);
        opInformacion.add(opInfoVocales);
        opInformacion.add(opInfoLineas);
        opInformacion.add(opInfoPacha);

        //Agrego las opciones que colgarán del menú Editar
        opEditar.add(opVerLineas);
        opEditar.add(opOcultarLineas);
        opEditar.add(opQueenPacha);


        opCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //En lugar de guardarlo atumáticamente, pregunto si se quiere guardar. 
                //Abajo dejo comentado el método que lo guardaría automáticamente sin preguntar.
                if (activarGuardar) {
                    int opcion = JOptionPane.showConfirmDialog(
                            Contenido.this,
                            "¿Quieres guardar los cambios antes de abandonar a Pacha?",
                            "Guardar cambios",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (opcion == JOptionPane.YES_OPTION) {
                        fileChooser = new JFileChooser();
                        if (elTextoCentral.isVisible() && obtenerTituloVentana().equals(tituloNoGuardado)) {
                            //Se muestra la ventana de elegir ruta y dar nombre de fichero para guardar
                            FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheros de texto", "txt");
                            fileChooser.setFileFilter(filter);
                            int option = fileChooser.showSaveDialog(Contenido.this);

                            if (option == JFileChooser.APPROVE_OPTION) {
                                filename = fileChooser.getSelectedFile().getPath();
                                try {
                                    GestionFichero.guardar_Fichero(filename, elTextoCentral.getText());
                                    JOptionPane.showMessageDialog(fileChooser, "Pacha ha guardado los cambios", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                                    //Pongo el nombre del fichero en la barra de título de 
                                    cambiarTituloVentana(filename);
                                    //Desactivo el botón guardar  pues se acaba de guardar
                                    desactivarGuardar();
                                } catch (IOException ex) {
                                    //Muestra un mensaje de error si no se puede almacenar elfichero
                                    //Se puede probar sobre una carpeta de solo lectura o una unidad de DVD que no tenga dispositivo
                                    JOptionPane.showMessageDialog(fileChooser, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

                                }
                            } else {
                                JOptionPane.showMessageDialog(fileChooser, "Archivo NO guardado", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else if (elTextoCentral.isVisible() && !obtenerTituloVentana().equals(tituloNoGuardado)) {
                            try {
                                GestionFichero.guardar_Fichero(obtenerTituloVentana(), elTextoCentral.getText());
                                JOptionPane.showMessageDialog(fileChooser, "Pacha ha guardado los cambios", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                                //Desactivo el botón guardar  pues se acaba de guardar
                                desactivarGuardar();
                            } catch (IOException ex) {
                                //Muestra un mensaje de error si no se puede almacenar elfichero
                                //Se puede probar sobre una carpeta de solo lectura o una unidad de DVD que no tenga dispositivo
                                JOptionPane.showMessageDialog(fileChooser, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        System.exit(0);

                    } else if (opcion == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(fileChooser, "Archivo NO guardado", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(fileChooser, "Pacha te dice adiós", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

            }
        });
        opArchivoCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conFicheroAbierto();
                //Añado esto para que cada vez que se le dé a nuevo, aparezca en blanco.
                elTextoCentral.setText("");

            }
        });

        opArchivoGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardar();
            }
        });

        //Para detectar si pulsa una tecla en un fichero que ya se guardó para activar el botón guardar.
        elTextoCentral.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!activarGuardar) {
                    //Al pulsar se activa el botón guardar
                    activarGuardar();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        opArchivoGuardarComo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Se muestra la ventana de elegir ruta y dar nombre de fichero para guardar
                guardarComo();
            }
        }
        );

        opArchivoAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
//                Mostrar la ventana para abrir archivo y recoger la respuesta
//                En el parámetro del showOpenDialog se indica la ventana al que estará asociado.Con el valor this se asocia a la
//                ventana que la abre
                int respuesta = fileChooser.showOpenDialog(Contenido.this);
                //Comprobar si se ha pulsado Aceptar
                if (respuesta == JFileChooser.APPROVE_OPTION) {
                    //Crear un objeto File con el archivo elegido
                    File archivoElegido = fileChooser.getSelectedFile();
                    //Mostrar el nombre del archvivo en la barra de título
                    cambiarTituloVentana(archivoElegido.getPath());
                    conFicheroAbierto();
                    try {

                        elTextoCentral.setText(GestionFichero.leer_Fichero(archivoElegido.getPath()));
                        desactivarGuardar();
                        cambiarTituloVentana(archivoElegido.getPath());
                    } catch (IOException ex) {
                        //Muestra un mensaje de error si no se puede almacenar elfichero
                        //Se puede probar sobre una carpeta de solo lectura o una unidad de DVD que no tenga dispositivo
                        JOptionPane.showMessageDialog(fileChooser, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        opInfoPalabras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(elTextoCentral, "Número de palabras: " + GestionFichero.contarPalabras(elTextoCentral.getText()), "Número de palabras", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        opInfoCaracteres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(elTextoCentral, "Número de caracteres: " + GestionFichero.contarCaracteres(elTextoCentral.getText()), "Número de caracteres", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        opInfoVocales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(elTextoCentral, "Número de vocales: " + GestionFichero.contarVocales(elTextoCentral.getText()), "Número de vocales", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        opInfoLineas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(elTextoCentral, "Número de líneas: " + GestionFichero.contarLineas(elTextoCentral.getText()), "Número de líneas", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        opInfoPacha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(elTextoCentral, "Número de Pachas: " + GestionFichero.contarPachas(elTextoCentral.getText()), "Número de Pachas", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        opVerLineas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                elTextoCentral.setText(GestionFichero.verLineas(elTextoCentral.getText()));
                opVerLineas.setEnabled(false);
                opOcultarLineas.setEnabled(true);

            }
        });

        opOcultarLineas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                elTextoCentral.setText(GestionFichero.ocultarLineas(elTextoCentral.getText()));
                opOcultarLineas.setEnabled(false);
                opVerLineas.setEnabled(true);

            }
        });

        opQueenPacha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                elTextoCentral.setText(GestionFichero.queenPacha(elTextoCentral.getText()));

            }
        });
       
    }

    //Método para usar con los botones opInfoPalabras, opInfoCaracteres y opInfoVocales y los de edición que actualmente están como comentarios
    public String archivoTemporal() throws IOException {
        //Creo un fichero temporal donde se irá sobreescribiendo lo que se encuentra
        //en el texto central. Así puedo usar siempre el mismo archivo al que aplicarle los métodos
        //de ver el número de palabras, caracteres y vocales.
        Writer escrito = null;
        File archivoTemporal = new File("archivoTemporal.txt");

        escrito = new FileWriter(archivoTemporal, false);
        String texto = elTextoCentral.getText();
        escrito.write(texto);

        escrito.close();

        //Hago que el archivoTemporal se borre una vez se cierra el programa
        archivoTemporal.deleteOnExit();

        return "archivoTemporal.txt";
    }

    private void cambiarTituloVentana(String titulo) {
        ((JFrame) SwingUtilities.getRoot(Contenido.this)).setTitle(titulo);
    }

    private String obtenerTituloVentana() {
        return ((JFrame) SwingUtilities.getRoot(Contenido.this)).getTitle();
    }

    private void desactivarGuardar() {
        //Desactivo el botón guardar  pues se acaba de guardar
        //Se activará al modificar algo
        opArchivoGuardar.setEnabled(false);
        //Para volverlo a activar cuando se escriba algo (KeyPressed)
        activarGuardar = false;
    }

    private void activarGuardar() {
        opArchivoGuardar.setEnabled(true);
        activarGuardar = true;
    }

    private void desactivarOpcionesIniciales() {
        //Desactivo guardar y guardar como para que solo estén activadas cuando 
        //haya un archivo abierto y se den otras opciones
        opArchivoGuardar.setEnabled(false);
        opArchivoGuardarComo.setEnabled(false);
        opInfoPalabras.setEnabled(false);
        opInfoCaracteres.setEnabled(false);
        opInfoVocales.setEnabled(false);
        opInfoLineas.setEnabled(false);
        opInfoPacha.setEnabled(false);
        opVerLineas.setEnabled(false);
        opOcultarLineas.setEnabled(false);
        opQueenPacha.setEnabled(false);

    }

    private void guardar() {
        fileChooser = new JFileChooser();
        if (elTextoCentral.isVisible() && obtenerTituloVentana().equals(tituloNoGuardado)) {
            //Se muestra la ventana de elegir ruta y dar nombre de fichero para guardar
            guardarComo();
        } else if (elTextoCentral.isVisible() && !obtenerTituloVentana().equals(tituloNoGuardado)) {
            try {
                GestionFichero.guardar_Fichero(obtenerTituloVentana(), elTextoCentral.getText());
                //Desactivo el botón guardar  pues se acaba de guardar
                desactivarGuardar();
            } catch (IOException ex) {
                //Muestra un mensaje de error si no se puede almacenar elfichero
                //Se puede probar sobre una carpeta de solo lectura o una unidad de DVD que no tenga dispositivo
                JOptionPane.showMessageDialog(fileChooser, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarComo(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Ficheros de texto", "txt");
        fileChooser.setFileFilter(filter);
        int option = fileChooser.showSaveDialog(Contenido.this);

        if (option == JFileChooser.APPROVE_OPTION) {
            filename = fileChooser.getSelectedFile().getPath();
            try {
                GestionFichero.guardar_Fichero(filename, elTextoCentral.getText());
                //Pongo el nombre del fichero en la barra de título de 
                cambiarTituloVentana(filename);
                //Desactivo el botón guardar  pues se acaba de guardar
                desactivarGuardar();
            } catch (IOException ex) {
                //Muestra un mensaje de error si no se puede almacenar elfichero
                //Se puede probar sobre una carpeta de solo lectura o una unidad de DVD que no tenga dispositivo
                JOptionPane.showMessageDialog(fileChooser, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    private void conFicheroAbierto() {
        elTextoCentral.setVisible(true);
        opArchivoGuardar.setEnabled(true);
        opArchivoGuardarComo.setEnabled(true);
        opInfoPalabras.setEnabled(true);
        opInfoCaracteres.setEnabled(true);
        opInfoVocales.setEnabled(true);
        opInfoLineas.setEnabled(true);
        opInfoPacha.setEnabled(true);
        opVerLineas.setEnabled(true);
        opOcultarLineas.setEnabled(false);
        opQueenPacha.setEnabled(true);

        //Cambiar el título de la ventana JFrame que contiene este JPanel
        cambiarTituloVentana(tituloNoGuardado);
    }
    
}

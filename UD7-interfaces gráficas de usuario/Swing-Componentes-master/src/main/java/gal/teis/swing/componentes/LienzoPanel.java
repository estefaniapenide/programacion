/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.swing.componentes;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;


/**
 *
 * @author Esther Ferreiro
 * Basado en https://jnjsite.com/java-swing-6-los-componentes-basicos/
 */
public class LienzoPanel extends JPanel {

    private JTextField elTextField;

    private JLabel elLabel;
    private JComboBox elCombobox;
    private JButton elBoton;
    private JCheckBox elCheckox;
    private JRadioButton elRadioButton1;
    private JRadioButton elRadioButton2;
    private ButtonGroup elRadioGroup;
    private JCheckBox elChecBox1;
    private JCheckBox elChecBox2;
    private ButtonGroup elButtonGroup;
    private JToggleButton elToggleButton;
    private JTextArea elTextArea;
    private JPasswordField elPasswordField;
    private JSpinner elSpinner;
    private JList elList;

    private JSeparator elSeparador;

    private JProgressBar elProgressBar;

    private JScrollBar elScrollBar;
    private JSlider elSlider;

    //Inicializo elementos y los agrego al panel
    public LienzoPanel() {
        //Inicializo la ventana
        setLayout(null);
        //Inicialio el campo de texto 
        inicializarTextField();
        add(elTextField);

        //Etiqueta
        inicializarLabel();
        add(elLabel);

        //Lista desplegable
        inicializarComboBox();
        add(elCombobox);
        
        //Botones de opción
        inicializarRadioButton();
        add(elRadioButton1);
        add(elRadioButton2);

        //Botón
        inicializarBoton();
        add(elBoton);

        //CheckBox aislado
        inicializarCheckBox();
        add(elCheckox);

        //CheckBoxAgrupado
        inicializarCheckBox1();
        add(elChecBox1);
        inicializarCheckBox2();
        add(elChecBox2);
        inicializarButtonGroup();

        //Botón de activación
        inicializarToggleButton();
        add(elToggleButton);

        //TextArea
        inicializarTextArea();
        add(elTextArea);

        //El campo de introducción de password
        inicializarPasword();
        add(elPasswordField);

        //El spinner
        inicializarSpinner();
        add(elSpinner);

        //El separador
        inicializarSeparador();
        add(elSeparador);

        //La barra de progreso
        inicializarBarraProgreso();
        add(elProgressBar);
        add(elScrollBar);
        add(elSlider);

    }

    private void inicializarTextField() {
        elTextField = new JTextField();
        elTextField.setText("Campo de texto");
        elTextField.setBounds(10, 36, 152, 20);
        elTextField.setColumns(10);
    }

    private void inicializarComboBox() {
        // el cuadro combinado
        elCombobox = new JComboBox();
        // los elementos
        elCombobox.setModel(new DefaultComboBoxModel(new String[]{"Elemento 1", "Elemento 2", "Elemento 3"}));
        // comienza seleccionado el elemento 1
        elCombobox.setSelectedIndex(1);
        elCombobox.setBounds(10, 67, 191, 20);
    }

    private void inicializarLabel() {
        elLabel = new JLabel("Etiqueta");
        elLabel.setBounds(10, 11, 67, 14);
    }

    private void inicializarBoton() {
        elBoton = new JButton("Botón");
        LienzoPanel panel = this;
        // cuando se pulsa hace ésto
        elBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(panel, "Ésto es un botón simple.");
            }
        });
        elBoton.setBounds(53, 95, 89, 23);
    }

    private void inicializarCheckBox() {
        elCheckox = new JCheckBox("Casilla de verificaciu00F3n");
        elCheckox.setSelected(true);
        elCheckox.setBounds(10, 125, 191, 23);
    }

    
    private void inicializarRadioButton() {
        // los botones de radio
        elRadioButton1 = new JRadioButton("RadioButton 1");
        elRadioButton1.setBounds(10, 151, 109, 23);

        elRadioButton2 = new JRadioButton("RadioButton 2");
        elRadioButton2.setBounds(10, 177, 109, 23);

        // el grupo para los botones
        elRadioGroup = new ButtonGroup();
        elRadioGroup.add(elRadioButton1);
        elRadioGroup.add(elRadioButton2);
    }

    private void inicializarCheckBox1() {
        elChecBox1 = new JCheckBox("CheckBox 1 agrupado");
        elChecBox1.setBounds(10, 203, 166, 23);
    }

    private void inicializarCheckBox2() {
        elChecBox2 = new JCheckBox("CheckBox 2 agrupado");
        elChecBox2.setBounds(10, 229, 166, 23);
    }

    private void inicializarButtonGroup() {

        elButtonGroup = new ButtonGroup();
        elButtonGroup.add(elChecBox1);
        elButtonGroup.add(elChecBox2);
    }

    private void inicializarToggleButton() {
        // el botón de activación
        elToggleButton = new JToggleButton("Botón de activación");
        // que está seleccionado inicialmente
        elToggleButton.setSelected(true);
        elToggleButton.setBounds(10, 259, 166, 23);
    }

    private void inicializarTextArea() {
        // el área de texto
        elTextArea = new JTextArea();
        // con una linea en el borde
        elTextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
        // tres lineas de texto permitidas
        elTextArea.setRows(3);
        // el texto
        elTextArea.setText("El texto del control TextoArea");
        elTextArea.setBounds(224, 11, 205, 58);
    }

    private void inicializarPasword() {
        // el texto de contrasela
        elPasswordField = new JPasswordField();
        elPasswordField.setBounds(224, 80, 152, 20);
        // contraseña inicial
        elPasswordField.setText("supercontraseña");
    }

    private void inicializarSpinner() {
        elSpinner = new JSpinner();
        elSpinner.setBounds(224, 111, 101, 20);
    }

    private void inicializarLista() {
        // la lista 
        elList = new JList();
        // la declaración de los elementos
        elList.setModel(new AbstractListModel() {
            String[] values = new String[]{"Elemento 1", "Elemento 2", "Elemento 3"};

            //Función que devuelve el número de elementos
            public int getSize() {
                return values.length;
            }
            //Devuelve el elemento de un índice
            //Si elList.getModel().getElementAt(1) podemos acceder a los elementos

            public Object getElementAt(int index) {
                return values[index];
            }
        });
        elList.setSelectedIndex(1);
        elList.setBounds(224, 142, 67, 52);
    }

    private void inicializarSeparador() {
        elSeparador = new JSeparator();
        elSeparador.setOrientation(SwingConstants.VERTICAL);
        elSeparador.setBounds(211, 11, 2, 297);
    }

    private void inicializarBarraProgreso() {
        // inicializacion de la barra de progreso,
        // la barra de desplazamiento y el deslizador.
        // los he puesto aquí juntos porque los uso
        // después y era necesario.
        elProgressBar = new JProgressBar();
        elSlider = new JSlider();
        elScrollBar = new JScrollBar();
        // configuraciones de la barra de progreso
        elProgressBar.setValue(50);
        elProgressBar.setBounds(224, 203, 205, 14);

        // la barra de desplazamiento
        elScrollBar.addAdjustmentListener(new AdjustmentListener() {

            public void adjustmentValueChanged(AdjustmentEvent arg0) {
                // mueve a la vez la barra de progreso y el deslizador 
                elProgressBar.setValue(elScrollBar.getValue());
                elSlider.setValue(elScrollBar.getValue());
            }
        });
        // valor inicial
        elScrollBar.setValue(50);
        elScrollBar.setOrientation(JScrollBar.HORIZONTAL);
        elScrollBar.setBounds(224, 233, 205, 23);
        // el deslizador, capturando evento
        elSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                // mueve la barra de progreso y la de desplazamiento
                // cada vez que se mueve el deslizador.
                elProgressBar.setValue(elSlider.getValue());
                elScrollBar.setValue(elSlider.getValue());
            }
        });
        // valores para que salga la regla numerada
        elSlider.setMinorTickSpacing(1);
        elSlider.setMajorTickSpacing(10);
        elSlider.setToolTipText("");
        elSlider.setPaintTicks(true);
        elSlider.setPaintLabels(true);
        elSlider.setBounds(224, 267, 200, 52);
    }

}

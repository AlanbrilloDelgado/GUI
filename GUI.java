
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI {
    public static void main(String args[]) {

        // Creando el Marco
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Creando MenuBar y agregando componentes
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("OPERACIONES");
        mb.add(m1);
        JMenuItem m11 = new JMenuItem("Suma"); //SubPanel de suma
        JMenuItem m12 = new JMenuItem("Resta"); //SubPanel de resta
        JMenuItem m13 = new JMenuItem("Multiplicacion"); //SubPanel de Multiplicacion
        JMenuItem m14 = new JMenuItem("Division"); //SubPanel de Division
        JMenuItem m15 = new JMenuItem("Raiz Cuadrada"); //SubPanel de Raiz
        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m1.add(m14);
        m1.add(m15);
        

        // Crear panel y componentes
        JPanel panel = new JPanel();
        JLabel text1 = new JLabel("Ingrese el primer valor:"); //Lineas alado del cuadro de texto
        JTextField tf1 = new JTextField(10); //Cuadro de texto
        JLabel text2 = new JLabel("Ingrese el segundo valor:"); //Lineas alado del cuadro de texto
        JTextField tf2 = new JTextField(10); // Segundo cuadro de texto
        JButton enviar = new JButton("ENVIAR"); //Boton enviar
        JButton borrar = new JButton("BORRAR"); //Boton borrar
        panel.add(text1);
        panel.add(tf1);
        panel.add(text2);
        panel.add(tf2);
        panel.add(enviar);
        panel.add(borrar);
       
        
        JTextArea ta = new JTextArea();
        ta.setEditable(false); // Para evitar la edición del área de texto

        // Agregar componentes al marco.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        

        frame.setVisible(true);

        // Agregar eventos a los elementos del menú
        m11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("Suma", ta, tf1, tf2);
            }
        });

        m12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("Resta", ta, tf1, tf2);
            }
        });

        m13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("Multiplicacion", ta, tf1, tf2);
            }
        });

        m14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("Division", ta, tf1, tf2);
            }
        });

        m15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarOperacion("Raiz Cuadrada", ta, tf1, tf2);
            }
        });

        // Agregar evento al botón "ENVIAR"
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entrada1 = tf1.getText();
                String entrada2 = tf2.getText();
                ta.append("Valores ingresados: " + entrada1 + " y " + entrada2 + "\n");
            }
        });

        // Agregar evento al botón "BORRAR"
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                tf2.setText("");
                ta.setText("");
            }
        });
    }

    // Método para realizar la operación seleccionada
    private static void realizarOperacion(String operacion, JTextArea ta, JTextField tf1, JTextField tf2) {
        try {
            double valor1 = Double.parseDouble(tf1.getText());
            double valor2 = Double.parseDouble(tf2.getText());
            double resultado = 0;

            switch (operacion) {
                case "Suma":
                    resultado = valor1 + valor2;
                    break;
                case "Resta":
                    resultado = valor1 - valor2;
                    break;
                case "Multiplicacion":
                    resultado = valor1 * valor2;
                    break;
                case "Division":
                    if (valor2 != 0) {
                        resultado = valor1 / valor2;
                    } else {
                        ta.append("No es posible dividir entre cero.\n");
                        return;
                    }
                    break;
                case "Raiz Cuadrada":
                    resultado = Math.sqrt(valor1);
                    break;
                default:
                    break;
            }

            ta.append("Operación " + operacion + ": " + valor1 + " y " + valor2 + " = " + resultado + "\n");
        } catch (NumberFormatException ex) {
            ta.append("Error al procesar la entrada. Ingresa valores numéricos válidos.\n");
        }
    }
}
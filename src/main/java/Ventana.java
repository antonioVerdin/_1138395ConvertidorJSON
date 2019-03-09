
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {


    private JTextArea entrada;
    private JTextArea salida;
    private JScrollPane scroll1;
    private JScrollPane scroll2;
    JScrollPane scrollPane;
    JComboBox selector;

    public Ventana(){

        entrada = new JTextArea();
        salida = new JTextArea();
            //Boton ---
        JButton botonParaConvertir = new JButton("Convertir");
        botonParaConvertir.setBounds(300,200,100,30);
        botonParaConvertir.addActionListener(this);
        this.add(botonParaConvertir);
            //Caja de opcioones ---
        selector = new JComboBox();
        selector.setBounds(300,250,100,30);
        selector.addItem("XML");
        selector.addItem("JAVA");
        this.add(selector);
            // Cuadros de texto ---
        scroll1 = new JScrollPane(entrada);
        scroll1.setBounds(10,10,280,400);
        scroll1.setVerticalScrollBarPolicy(20);
        scroll1.setHorizontalScrollBarPolicy(30);

        salida.setEditable(false);
        scroll2 = new JScrollPane(salida);
        scroll2.setBounds(410,10,280,400);
        scroll2.setVerticalScrollBarPolicy(20);
        scroll2.setHorizontalScrollBarPolicy(30);

        this.add(scroll1);
        this.add(scroll2);

            // FRame ---
        this.setSize(new Dimension(710,500));
                //El tamaño de la ventana no se puede modificar
        this.setResizable(false);
                // el programa se detiene al cerrar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
            //para que la ventana sea visible
        ventana.setVisible(true);

    }

    private Convertidor convertidor;
    private String textoConvertido;

    public void actionPerformed(ActionEvent e) {
        String textoEntrada = entrada.getText();
        convertidor = new Convertidor();

        if(textoEntrada.trim().length()==0){
            JOptionPane.showMessageDialog(
            this, "No hay texto", "Texto vacio!!!", JOptionPane.WARNING_MESSAGE);
        }else{
            if(selector.getSelectedItem().toString() == "XML"){
                textoConvertido = convertidor.convertirXmlToJson(textoEntrada, 4);
            }

            if(selector.getSelectedItem().toString() == "JAVA"){
                textoConvertido = convertidor.convertirClaseToJson(textoEntrada);
            }

            salida.setText("");
            salida.setText(textoConvertido);
        }
    }
}

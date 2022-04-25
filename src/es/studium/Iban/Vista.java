package es.studium.Iban;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Vista
{
	Frame ventana = new Frame("Calcular IBAN");
	Dialog d = new Dialog(ventana, "Error", true);
	Label lbEntidad = new Label("Entidad");
    Label lbSucursal = new Label("Sucursal");
    Label lbDc = new Label("DC ");
    Label lbNCuenta = new Label("Nº Cuenta ");
    Label lbMensaje = new Label("Error: La cuenta no es correcta");
    TextField txEntidad = new TextField("",4);
    TextField txSucursal = new TextField("",4);
    TextField txDc = new TextField("",2);
    TextField txNCuenta = new TextField("",10);
    TextField txIban = new TextField("",24);
    Button btCalcularIban = new Button("Calcular IBAN");
    Button btAceptar = new Button("Aceptar");
    
    public Vista()
    {
    	ventana.setLayout(new FlowLayout());
    	ventana.add(lbEntidad);
    	ventana.add(lbSucursal);
    	ventana.add(lbDc);
    	ventana.add(lbNCuenta);
    	ventana.add(txEntidad);
    	ventana.add(txSucursal);
    	ventana.add(txDc);
    	ventana.add(txNCuenta);
    	ventana.add(btCalcularIban);
        txIban.setEditable(false);
        ventana.add(txIban);
        ventana.setSize(300,150);
        ventana.setResizable(false);
        ventana.setVisible(true);

        d.setLayout(new FlowLayout());
        d.setSize(200,120);
        d.add(lbMensaje);
        d.add(btAceptar);
    }
}

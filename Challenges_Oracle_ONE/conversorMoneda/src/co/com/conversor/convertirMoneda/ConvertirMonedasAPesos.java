package co.com.conversor.convertirMoneda;

import javax.swing.*;

public class ConvertirMonedasAPesos {
    public void ConvertirDolaresAPesos(double cantidad){
        double modedaDolar = cantidad*4074.32;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirEurosAPesos(double cantidad){
        double modedaDolar = cantidad*4074.32;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirLibrasEsterlinasAPesos(double cantidad){
        double modedaDolar = cantidad*4074.32;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirYenJaponesAPesos(double cantidad){
        double modedaDolar = cantidad*4074.32;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirWonSulCoreanoAPesos(double cantidad){
        double modedaDolar = cantidad*4074.32;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }
}

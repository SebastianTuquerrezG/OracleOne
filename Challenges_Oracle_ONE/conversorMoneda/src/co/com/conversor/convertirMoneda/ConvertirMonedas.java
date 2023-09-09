package co.com.conversor.convertirMoneda;

import javax.swing.*;

public class ConvertirMonedas {
    //TODO: API que este atento al cambio del precio del dolar en tiempo real
    public void ConvertirPesosADolares(double cantidad){
        double modedaDolar = cantidad/4074.32;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirPesosAEuros(double cantidad){
        double modedaDolar = cantidad*4074.32;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirPesosALibrasEsterlinas(double cantidad){
        double modedaDolar = cantidad/4309.38;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirPesosAYenJapones(double cantidad){
        double modedaDolar = cantidad/27.35;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirPesosAWonSulCoreano(double cantidad){
        double modedaDolar = cantidad/9.06;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }
}

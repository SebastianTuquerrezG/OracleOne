package co.com.conversor.convertirMoneda;

import javax.swing.*;

public class ConvertirMonedasAPesos {
    public void ConvertirDolaresAPesos(double cantidad){
        double modedaDolar = cantidad*4019.50;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " dólares");
    }

    public void ConvertirEurosAPesos(double cantidad){
        double monedaEuro = cantidad*4306.29;
        monedaEuro = (double) Math.round(monedaEuro*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + monedaEuro + " Euros");
    }

    public void ConvertirLibrasEsterlinasAPesos(double cantidad){
        double monedaLibraEsterlina = cantidad*5010.30;
        monedaLibraEsterlina = (double) Math.round(monedaLibraEsterlina*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + monedaLibraEsterlina + " Libra Esterlina");
    }

    public void ConvertirYenJaponesAPesos(double cantidad){
        double monedaYenJapones = cantidad*27.19;
        monedaYenJapones = (double) Math.round(monedaYenJapones*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + monedaYenJapones + " Yen Japones");
    }

    public void ConvertirWonSulCoreanoAPesos(double cantidad){
        double monedaWonSulCoreano = cantidad*3.01;
        monedaWonSulCoreano = (double) Math.round(monedaWonSulCoreano*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + monedaWonSulCoreano + " Won Sur Coreano");
    }
}

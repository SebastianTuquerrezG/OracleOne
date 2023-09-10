package co.com.conversor.convertirMoneda;

import javax.swing.*;

public class ConvertirMonedas {
    //TODO: API que este atento al cambio del precio del dolar en tiempo real
    public void ConvertirPesosADolares(double cantidad){
        double modedaDolar = cantidad/4074.32;
        modedaDolar = (double) Math.round(modedaDolar*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaDolar + " Dolares");
    }

    public void ConvertirPesosAEuros(double cantidad){
        double monedaEuro = cantidad/4306.29;
        monedaEuro = (double) Math.round(monedaEuro*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + monedaEuro + " Euros");
    }

    public void ConvertirPesosALibrasEsterlinas(double cantidad){
        double monedaLibraEsterlina = cantidad/5010.30;
        monedaLibraEsterlina = (double) Math.round(monedaLibraEsterlina*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + monedaLibraEsterlina + " Libras Esterlinas");
    }

    public void ConvertirPesosAYenJapones(double cantidad){
        double modedaYenJapones = cantidad/27.19;
        modedaYenJapones = (double) Math.round(modedaYenJapones*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + modedaYenJapones + " Yen Japones");
    }

    public void ConvertirPesosAWonSulCoreano(double cantidad){
        double monedaWonSulCoreano = cantidad/3.01;
        monedaWonSulCoreano = (double) Math.round(monedaWonSulCoreano*100d)/100;
        JOptionPane.showMessageDialog(null, "La cantidad de $" + cantidad + " pesos es equivalente a $" + monedaWonSulCoreano + " Won Sul Coreanos");
    }
}

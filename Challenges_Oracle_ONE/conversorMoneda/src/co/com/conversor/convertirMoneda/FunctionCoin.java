package co.com.conversor.convertirMoneda;

import javax.swing.*;

public class FunctionCoin {
    ConvertirMonedas monedas = new ConvertirMonedas();
    ConvertirMonedasAPesos monedasAPesos = new ConvertirMonedasAPesos();

    public void convertirMoneda(double cantidad){
        String opcion = (JOptionPane.showInputDialog(null,
                "Elige la moneda a la que desea convertir: ",
                "Monedas", JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"De Pesos a Dolares",
                        "De Pesos a Euros",
                        "De Pesos a Libras Esterlinas",
                        "De Pesos a Yen Japones",
                        "De Pesos a Won Sul Coreano"},
                "Seleccion")).toString();

        switch (opcion) {
            case "De Pesos a Dolares":
                monedas.ConvertirPesosADolares(cantidad);
                break;
            case "De Pesos a Euros":
                monedas.ConvertirPesosAEuros(cantidad);
                break;
            case "De Pesos a Libras Esterlinas":
                monedas.ConvertirPesosALibrasEsterlinas(cantidad);
                break;
            case "De Pesos a Yen Japones":
                monedas.ConvertirPesosAYenJapones(cantidad);
                break;
            case "De Pesos a Won Sul Coreano":
                monedas.ConvertirPesosAWonSulCoreano(cantidad);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }

    public void convertirMonedaAPesos(double cantidad){
        String opcion = (JOptionPane.showInputDialog(null,
                "Elige la moneda a la que desea convertir: ",
                "Monedas", JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"De dolares a Pesos",
                        "De Euros a Pesos",
                        "De Libras Esterlinas a Pesos",
                        "De Yen Japones a Pesos",
                        "De Won Sul Coreano a Pesos"},
                "Seleccion")).toString();

        switch (opcion) {
            case "De dolares a Pesos":
                monedasAPesos.ConvertirDolaresAPesos(cantidad);
                break;
            case "De Euros a Pesos":
                monedasAPesos.ConvertirEurosAPesos(cantidad);
                break;
            case "De Libras Esterlinas a Pesos":
                monedasAPesos.ConvertirLibrasEsterlinasAPesos(cantidad);
                break;
            case "De Yen Japones a Pesos":
                monedasAPesos.ConvertirYenJaponesAPesos(cantidad);
                break;
            case "De Won Sul Coreano a Pesos":
                monedasAPesos.ConvertirWonSulCoreanoAPesos(cantidad);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
                break;
        }
    }
}

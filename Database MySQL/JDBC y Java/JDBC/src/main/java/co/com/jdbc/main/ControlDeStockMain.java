package co.com.jdbc.main;

import javax.swing.JFrame;

import co.com.jdbc.view.ControlDeStockFrame;

import java.sql.SQLException;

public class ControlDeStockMain {
    public static void main(String[] args) throws SQLException {
        ControlDeStockFrame frame = new ControlDeStockFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
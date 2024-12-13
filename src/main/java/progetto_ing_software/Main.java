/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

/**
 *
 * @author cerro
 */
import Interfaccia.RubricaGUI;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(RubricaGUI::new);
    }
}

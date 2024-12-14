/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto_ing_software;

/**
 * @file Main.java
 * @brief Questo file è il Main di tutto il programma.
 *
 * Questa classe avvia la GUI del programma.
 *
 * @version 1.0
 * @author Gruppo 23
 * @date 12/12/2024
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

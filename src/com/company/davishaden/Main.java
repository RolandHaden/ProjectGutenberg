/*
Name: Davis Haden
Date: 8/4/2021
Desc: The main class for the program.
 */
package com.company.davishaden;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Project Gutenberg");
        String location = "Files/LMDA.txt";
        GUIPanel panel = new GUIPanel(location);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

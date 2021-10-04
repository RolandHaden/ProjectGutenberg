/*
Name: Davis Haden
Date: 8/4/2021
Desc: The GUI Panel for the Project Gutenberg Project. This also contains methods for the certain scanner functions.
 */
package com.company.davishaden;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GUIPanel extends JPanel {
    private final String fileLocation;
    private final JButton wordCountButton, customWordCountButton, sentenceCountButton;
    private final JLabel wordCountText,customWordCountText, sentenceCountText;
    private final JTextField customWordInput;
    public GUIPanel() throws IOException {
        //Declaring some variables
        fileLocation = "Files/LMDA.txt";
        //Image On Top
        BufferedImage bufferedImage = ImageIO.read(new File("Images/logo.png"));
        Image icon = bufferedImage.getScaledInstance(180, 108, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(icon);
        JLabel logoImage = new JLabel(finalImage);
        //Word Count Panel
        JPanel wordCount = new JPanel();
        JLabel wordCountTitle = new JLabel("Word Count");
        wordCountTitle.setAlignmentX(CENTER_ALIGNMENT);
        wordCountTitle.setForeground(Color.white);
        wordCountText = new JLabel("Number of Words in Text : 0");
        wordCountText.setAlignmentX(CENTER_ALIGNMENT);
        wordCountText.setForeground(Color.white);
        wordCountButton = new JButton("Get Word Count");
        wordCountButton.addActionListener(new ButtonListener());
        wordCountButton.setAlignmentX(CENTER_ALIGNMENT);
        wordCount.add(wordCountTitle);
        wordCount.add(wordCountText);
        wordCount.add(wordCountButton);
        wordCount.setBackground(Color.pink);
        wordCount.setLayout(new BoxLayout(wordCount, BoxLayout.PAGE_AXIS));
        wordCount.setPreferredSize(new Dimension(250,75));
        //Sentence Count Panel
        JPanel sentenceCount = new JPanel();
        JLabel sentenceCountTitle = new JLabel("Sentence Count");
        sentenceCountTitle.setAlignmentX(CENTER_ALIGNMENT);
        sentenceCountTitle.setForeground(Color.white);
        sentenceCountText = new JLabel("Number of Sentences in Text : 0");
        sentenceCountText.setAlignmentX(CENTER_ALIGNMENT);
        sentenceCountText.setForeground(Color.white);
        sentenceCountButton = new JButton("Get Sentence Count");
        sentenceCountButton.addActionListener(new ButtonListener());
        sentenceCountButton.setAlignmentX(CENTER_ALIGNMENT);
        sentenceCount.add(sentenceCountTitle);
        sentenceCount.add(sentenceCountText);
        sentenceCount.add(sentenceCountButton);
        sentenceCount.setBackground(Color.pink);
        sentenceCount.setLayout(new BoxLayout(sentenceCount, BoxLayout.PAGE_AXIS));
        sentenceCount.setPreferredSize(new Dimension(250,75));
        //Specified Word Panel
        JPanel customWordCount = new JPanel();
        JLabel customWordCountTitle = new JLabel("Custom Word Count");
        customWordCountTitle.setAlignmentX(CENTER_ALIGNMENT);
        customWordCountTitle.setForeground(Color.white);
        customWordCountText = new JLabel("Number of Words in Text : 0");
        customWordCountText.setAlignmentX(CENTER_ALIGNMENT);
        customWordCountText.setForeground(Color.white);
        customWordCountButton = new JButton("Get Word Count");
        customWordCountButton.addActionListener(new ButtonListener());
        customWordCountButton.setAlignmentX(CENTER_ALIGNMENT);
        customWordInput = new JTextField("Enter word here");
        customWordInput.setAlignmentX(CENTER_ALIGNMENT);
        customWordCount.add(customWordCountTitle);
        customWordCount.add(customWordCountText);
        customWordCount.add(customWordInput);
        customWordCount.add(customWordCountButton);
        customWordCount.setBackground(Color.pink);
        customWordCount.setLayout(new BoxLayout(customWordCount, BoxLayout.PAGE_AXIS));
        customWordCount.setPreferredSize(new Dimension(250,100));
        //Finilazing Panel
        add(logoImage);
        add(wordCount);
        add(sentenceCount);
        add(customWordCount);
        setBackground(new Color(248, 155, 155));
        setPreferredSize(new Dimension(280,500));
    }
    //Returns the number of words in a txt file
    public int GetWordCount() throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(fileLocation));
        int wordCount=0;
        while(scan.hasNext()){
            wordCount++;
            scan.next();
        }
        scan.close();
        return wordCount;
    }
    //Returns the number of custom words in a txt file
    public int GetCustomWordCount(String input) throws FileNotFoundException {
        int wordCount=0;
        Scanner scan = new Scanner(new FileReader(fileLocation));
        while(scan.hasNext()){
            if(scan.next().contains(input)){
                wordCount++;
            }
        }
        scan.close();
        return wordCount;
    }
    //Returns the number of sentences in a txt file
    public int GetNumOfSentences() throws FileNotFoundException {
        Scanner scan = new Scanner(new FileReader(fileLocation));
        int sentenceCount=0;
        while(scan.hasNext()){
                if(scan.next().contains(".")){
                    sentenceCount++;
                }
        }
        scan.close();
        return sentenceCount;
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Word Count for File
            if(e.getSource() == wordCountButton){
                try {
                    wordCountText.setText("Number of Words in Text : " + GetWordCount());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
            //Custom Word Count for File
            if(e.getSource() == customWordCountButton){
                try {
                    customWordCountText.setText("Number of Words in Text : " + GetCustomWordCount(customWordInput.getText()));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
            //Sentence Count for File
            if(e.getSource() == sentenceCountButton){
                try {
                    sentenceCountText.setText("Number of Sentences in Text : " + GetNumOfSentences());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }
    }
}

package org.se1.anttest.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.se1.anttest.database.DatabaseReader;
import org.se1.anttest.model.Lecture;

public class LectureJFrame {

    private static final Log log = LogFactory.getLog(LectureJFrame.class);
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Lecture l = (Lecture)DatabaseReader.loadCourse(1234);
        log.info("lecture loaded");
        
        JFrame frame = new JFrame("Lecture");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel("SE1: Ant-Uebung erfolgreich geloest!",JLabel.CENTER), BorderLayout.CENTER);
        frame.setBounds(100,100,500,500);
        //frame.pack();
        
        frame.setVisible(true);
        log.info("finished");
    }

}

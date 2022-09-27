package org.se1.anttest.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.se1.anttest.database.DatabaseReader;
import org.se1.anttest.database.DatabaseWriter;
import org.se1.anttest.model.Person;

public class PersonJFrame {

    private static final Log log = LogFactory.getLog(PersonJFrame.class);

    /**
     * @param args
     */
    public static void main(String[] args) {

        Person l = DatabaseReader.loadPerson(2345);
        log.info("person loaded");
        
        JFrame frame = new JFrame("Person");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JLabel("Donald Duck",JLabel.CENTER), BorderLayout.CENTER);
        frame.setBounds(100,100,500,500);
        //frame.pack();
        
        frame.setVisible(true);
        log.info("finished");        
    }

}

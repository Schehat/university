package org.se1.anttest.database;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.se1.anttest.model.Course;
import org.se1.anttest.model.Person;
import org.se1.anttest.model.Registration;

public class DatabaseReader {

    private static final Log log = LogFactory.getLog(DatabaseReader.class);
    
    
    public static Person loadPerson(int id) {
        log.info("loadPerson()");
        return null;
    }
    
    public static Course loadCourse(int id) {
        log.info("loadCourse()");
        return null;        
    }
    
    public static Registration loadRegistration(int id) {
        log.info("loadRegistration()");
        return null;        
    }    
    
}

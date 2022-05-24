package org.se1.anttest.database;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.se1.anttest.model.Course;
import org.se1.anttest.model.Person;
import org.se1.anttest.model.Registration;

public class DatabaseWriter {

    private static final Log log = LogFactory.getLog(DatabaseWriter.class);
        
    public static int savePerson(Person person) {
        log.info("savePerson()");
        return 1;
    }
    
    public static int saveCourse(Course course) {
        log.info("saveCourse()");
        return 2;
    }
    
    public static int saveRegistration(Registration registration) {
        log.info("saveRegistration()");
        return 3;
    }

}

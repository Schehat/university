package entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "ue08Person")
public class Person {

    @Version
    @Id
    @Column(name = "personId") @GeneratedValue
    private Long personId;
    
    @Column(name = "name", unique = true)
    private String name;
    
    @Column(name = "sex")
    private String sex;
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private ArrayList<MovieCharacter> movChars = new ArrayList<MovieCharacter>();
    
    /**
     * constructor with parameters
     * @param personId
     * @param name
     * @param sex
     */
    public Person (Long personId, String name, String sex, ArrayList<MovieCharacter> movChars) {
        setPersonId(personId);
        setName(name);
        setSex(sex);
        setMovChars(movChars);
    }
    
    /**
     * empty constructor
     */
    public Person() {
        
    }
    
    /**
     * 
     * @param personId
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    
    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    /**
     * 
     * @param movChars
     */
    public void setMovChars(ArrayList<MovieCharacter> movChars) {
        this.movChars = (ArrayList<MovieCharacter>) movChars.clone();
    }
    
    /**
     * 
     * @return personId
     */
    public Long getPersonId() {
        return personId;
    }
    
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return sex
     */
    public String getSex() {
        return sex;
    }
    
    /**
     * 
     * @return movChars
     */
    public ArrayList<MovieCharacter> getMovChars() {
        return movChars;
    }
}

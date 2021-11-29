package entities;

import java.util.HashSet;
import java.util.Set;

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
    private Set<MovieCharacter> movChars = new HashSet<MovieCharacter>();
    
    /**
     * constructor with parameters
     * @param personId
     * @param name
     * @param sex
     */
    public Person (Long personId, String name, String sex, Set<MovieCharacter> movChars) {
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
    public void setMovChars(Set<MovieCharacter> movChars) {
        this.movChars = new HashSet<MovieCharacter>(movChars);
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
    public Set<MovieCharacter> getMovChars() {
        return movChars;
    }
}

package de.hsh.steam.entities;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Enum Score
 */
@XmlRootElement
public enum Score implements Serializable {

    bad,
    mediocre,
    good,
    very_good;
    
}

package de.fhhannover.inform.persistence;

/**
 *
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 * @author J�rgen Dunkel
 * @version 1.1
 * Title:
 * Description:  zentrales Interface, das jede Klasse, die persistent
 *                abgespeichert werdensoll implementieren mu�
 */

public interface Persistent {
    public String getOid();
    public void setOid(String oid);
}
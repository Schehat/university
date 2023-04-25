/**
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 *
 * @author JŸrgen Dunkel
 * @version 1.1
 * <p>
 * Title:        OidGenerator<p>
 * Description:  erzeugt eindeutige Objekt-ID's mit Hilfer von java.rmi.UID<p> oder
 * einer OracleSequence myID -> muss erzeugt werden mit:
 * 'create sequence myID'
 */

package de.fhhannover.inform.persistence;

import java.sql.*;

/**
 *
 * Copyright:    Copyright (c) <p>
 * Company:      FBI<p>
 * @author Persistenz-Gruppe
 * @version 1.0
 * OidGenerator
 *
 * Der OID-Generator dient zur Erzeugung einer eindeutige OID
 *
 */

public class OidGenerator {

    /**
     * bei useSequence=true wird eine Sequence genutzt
     */
    static private boolean useSequence = true;

    /**
     *  erzeugt die Oid als String und gibt diese als String zurück.
     *  dazu wird die Klasse UID aus dem Paket java.rmi.server benutzt
     */
    static public String getOid() {
        if (useSequence)
            return getOidBySequence();
        java.rmi.server.UID uid = new java.rmi.server.UID();
        return uid.toString();
    }

    private static String getOidBySequence() {
        // Generieren der OIds ueber eine Oracle-Sequence myId
        // wirg genutzt wenn d
        String oid = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            Statement stmt = conn.createStatement();
            // myID ist Sequence, dual ist Standard-Tabelle mit einer Zeile
            ResultSet rs = stmt.executeQuery("SELECT NEXT VALUE FOR MYID as nextval;");
            rs.next();
            oid = rs.getString("nextval");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return oid;
    }

}

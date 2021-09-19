package application;

import java.io.Serializable;

public class X implements Serializable { 
    public X v; 
    private X w; /**Konstrukter usw als vorhanden gesehen*/
    public X getV() {
        return v;
    }
    public void setV(X v) {
        this.v = v;
    }
}

package org.hbrs.se1.ws23.uebung9;


/*
* Leaf Object
* */
public abstract class CoreDocument implements Document{

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}



package org.hbrs.se1.ws23.uebung9;

/*
 * Leaf Object
 * */

public class GraphicDocument extends CoreDocument{

    private String url;

    public GraphicDocument(String url) {
        this.url = url;
    }

    @Override
    public int size() {
        return 1200;
    }


}

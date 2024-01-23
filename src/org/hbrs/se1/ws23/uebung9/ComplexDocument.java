package org.hbrs.se1.ws23.uebung9;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/*
* Our Composite object
* */

public class ComplexDocument implements Document{

    private ArrayList<Document> documentArrayList = new ArrayList<Document>();

    public void add(Document document) {
        documentArrayList.add(document);
    }

    public void remove(Document document) {
        documentArrayList.remove(document);
    }

    @Override
    public int size() throws UnsupportedEncodingException {
        int size = 0;
        for (Document document: documentArrayList) {
            size += document.size();
        }
        return size;
    }
}

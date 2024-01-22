package org.hbrs.se1.ws23.uebung8;
import org.hbrs.se1.ws23.uebung8.Encoding;

import java.io.UnsupportedEncodingException;

import static org.hbrs.se1.ws23.uebung8.Encoding.UTF16;
import static org.hbrs.se1.ws23.uebung8.Encoding.UTF8;

public class ClientTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        TextDocument document = new TextDocument("Ein Text!", UTF16);
        TextDocument document2 = new TextDocument("Ein Text2!", UTF16);
        GraphicDocument document3 = new GraphicDocument("localhost:8080");
        ComplexDocument aComplexDocument = new ComplexDocument();
        aComplexDocument.add(document);
        aComplexDocument.add(document2);
        aComplexDocument.add(document3);
        System.out.println(document2.size());
        System.out.println(document.size());
        System.out.println(aComplexDocument.size());
    }

}

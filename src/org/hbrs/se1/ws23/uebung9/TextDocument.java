package org.hbrs.se1.ws23.uebung9;


import java.io.UnsupportedEncodingException;

/*
* Leaf Object
* */
public class TextDocument extends CoreDocument{

    private String text;
    private Encoding encoding;

    public TextDocument(String s, Encoding encoding) {
        this.text = s;
        this.encoding = encoding;
    }
    @Override
    public int size() throws UnsupportedEncodingException {
        byte[] bytes =  this.text.getBytes(String.valueOf(this.encoding));
        return bytes.length;
    }
}

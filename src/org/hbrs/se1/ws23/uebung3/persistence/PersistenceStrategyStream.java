package org.hbrs.se1.ws23.uebung3.persistence;

import org.hbrs.se1.ws23.uebung2.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    ObjectInputStream ois;
    FileInputStream fis;
    ObjectOutputStream ous;
    FileOutputStream fos;
    List newListe = new ArrayList<>();

    // URL of file, in which the objects are stored
    private String location = "C:\\Users\\Theodor\\Desktop\\test.txt";

    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation (String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
    public void openConnection() throws PersistenceException, IOException {

    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException, IOException {

    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> l) throws PersistenceException, IOException {
            fos = new FileOutputStream(location);
            ous = new ObjectOutputStream(fos);
            ous.writeObject(l);
            ous.close();
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException, IOException, ClassNotFoundException {
        try {
            fis = new FileInputStream(location);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                newListe = (List) obj;
            }
            ois.close();
        }  catch (EOFException e) {
            System.out.println("End of file reached");
        }
        return (List<E>) newListe;
        // Some Coding hints ;-)

        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );

        // Tipp: Use a directory (ends with "/") to implement a negative test case ;-)
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
    }
}

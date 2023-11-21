package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Container {
    private PersistenceStrategy persistenceStrategy;
    private List<UserStory> userStories = new ArrayList<>();
    private static Container container;

    private Container () {

    }

    public void setPersistenceStrategy(PersistenceStrategy p) {
        this.persistenceStrategy = p;
    }

    //Methode zum zurückgeben eines Containers, Synchronized bietet nur einen Zugriff zur Laufzeit an
    public static synchronized Container getInstance() {
        if (container == null) {
            container = new Container();
        }
        return container;
    }

    public void addUserStory(UserStory userStory) throws org.hbrs.se1.ws23.uebung4.ContainerException {
        for (UserStory i: userStories) {
            if ((userStory.getId() == i.getId())) {
                throw new org.hbrs.se1.ws23.uebung4.ContainerException(userStory);
            }
        }
        userStories.add(userStory);
    }

    public String deleteMember(int id) {
        for (UserStory i: userStories) {
            if (id == i.getId()) {
                userStories.remove(i);
                return "erfolgreich gelöscht";
            }
        }
        return "id nicht vorhanden";
    }
    /*d
     * Ohne Rückgabe einer konkreten Exception kann unter Umständen nicht direkt nachvollzogen werden
     * wo ein Fehler liegt
     * */


    public int size() {
        return userStories.size();
    }

    public void store() throws PersistenceException, IOException {
        persistenceStrategy.save(userStories);
    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {
        userStories = persistenceStrategy.load();
    }

    public List<UserStory> getCurrentList() {
        return userStories;
    }
}

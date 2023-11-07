package org.hbrs.se1.ws23.uebung2;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Container {

    private PersistenceStrategy persistenceStrategy;
    private List<Member> members = new ArrayList<>();
    private static Container container;

    private Container () {

    }

    public void setPersistenceStrategy(PersistenceStrategy p) {
        this.persistenceStrategy = p;
    }

    public static Container getInstance() {
        if (container == null) {
            container = new Container();
        }
        return container;
    }

    public void addMember(Member member) throws ContainerException {
            for (Member i: members) {
                if ((member.getID() == i.getID())) {
                    throw new ContainerException(member);
                }
            }
        members.add(member);
    }

    public String deleteMember(int id) {
        for (Member i: members) {
            if (id == i.getID()) {
                members.remove(i);
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
        return members.size();
    }

    public void store() throws PersistenceException, IOException {
        persistenceStrategy.save(members);
    }

    public void load() throws PersistenceException, IOException, ClassNotFoundException {
        members = persistenceStrategy.load();
    }

    public List<Member> getCurrentList() {
        return members;
    }
}

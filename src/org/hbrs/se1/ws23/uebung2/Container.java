package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;
import java.util.Objects;

public class Container {

    private ArrayList<Member> members;

    public Container () {
        this.members = new ArrayList<>();
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

    public void dump() {
        for (Member i: members) {
            System.out.println(i.toString());
        }
    }

    public int size() {
        return members.size();
    }
}

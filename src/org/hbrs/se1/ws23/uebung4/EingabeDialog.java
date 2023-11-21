package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EingabeDialog {

    public static void startEingabe() throws PersistenceException, IOException, ClassNotFoundException, ContainerException {

        org.hbrs.se1.ws23.uebung4.Container container = Container.getInstance();

        String strInput = null;

        Scanner scanner = new Scanner(System.in);

        PersistenceStrategyStream persistenceStrategyStream = new PersistenceStrategyStream();

        container.setPersistenceStrategy(persistenceStrategyStream);

        while (true) {

            System.out.print("> ");

            strInput = scanner.nextLine();

            // Extrahiert ein Array aus der Eingabe
            String[] strings = strInput.split(" ");

            // 	Falls 'help' eingegeben wurde, werden alle Befehle ausgedruckt
            if (strings[0].equals("help")) {
                System.out.println("Folgende Befehle stehen zur Verfuegung: help, dump, enter, store, load, " +
                        "search, exit");
            }
            if (strings[0].equals("dump")) {
                UserStoryView.dump(container.getCurrentList());

            }
            if (strings[0].equals("enter")) {
                org.hbrs.se1.ws23.uebung4.UserStory userStory = new UserStory(Integer.parseInt(strings[1]),
                        strings[2], Integer.parseInt(strings[3]), Integer.parseInt(strings[4]),
                        Integer.parseInt(strings[5]), Integer.parseInt(strings[6]), strings[7]);
                container.addUserStory(userStory);
            }
            if (strings[0].equals("store")) {
                    container.store();
            }
            if (strings[0].equals("load")) {
                container.load();
            }
            if (strings[0].equals("search")) {
                String suchwort = strings[1];
                ArrayList<UserStory> liste = (ArrayList<UserStory>) container.getCurrentList();
                String s = liste.stream()
                        .filter(p -> p.getProject() == suchwort)
                        .map(p -> p.getProject())
                        .reduce( "", ( s1, s2 ) -> (s1.isEmpty()) ? s2 : s1 + ", " + s2 );
            }
            if (strings[0].equals("exit")) {
                System.exit(0);
                scanner.close();
            }
        }

    }
}

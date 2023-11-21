package org.hbrs.se1.ws23.uebung4;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserStoryView {
        public static void dump(List<UserStory> userStoryList) {
            Collections.sort(userStoryList);
            for (UserStory i: userStoryList) {
                System.out.println(i.toString());
            }
        }

}

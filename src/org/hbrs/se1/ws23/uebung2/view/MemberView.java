package org.hbrs.se1.ws23.uebung2.view;

import org.hbrs.se1.ws23.uebung2.Member;

import java.util.List;

public class MemberView {
    public void dump(List<Member> memberList) {
        for (Member i: memberList) {
            System.out.println(i.toString());
        }
    }
}

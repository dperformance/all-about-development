package job;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
//        Memberr member1 = new Memberr("member1", "회원1");
//        Memberr member2 = new Memberr("member2", "회원2");
//
//        Team team = new Team("team1","팀1");
//
//        member1.setTeam(team);
//        member2.setTeam(team);
//
//        Team findTeam = member1.getTeam();
//
//        System.out.println(findTeam.toString());

        Team team1 = new Team("team1", "팀1");
        Memberr member1 = new Memberr("member1", "회원1");
        Memberr member2 = new Memberr("member2", "회원2");

        member1.setTeam(team1);          // 연관관계 설정 member1 -> team1
        member2.setTeam(team1);          // 연관관계 설정 member2 -> team1

        team1.getMembers().add(member1); // 연관관계 설정 team1 -> member1
        team1.getMembers().add(member2); // 연관관계 설정 team1 -> member2

        List<Memberr> members = team1.getMembers();

        System.out.println("members.size = " + members.size());





    }
}

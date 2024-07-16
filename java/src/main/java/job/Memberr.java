package job;

public class Memberr {
    private String id;
    private String name;

    private Team team;

    public Memberr(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}

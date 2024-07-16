package job;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Team {
    private String id;
    private String name;
    private List<Memberr> members = new ArrayList<>();

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }



}

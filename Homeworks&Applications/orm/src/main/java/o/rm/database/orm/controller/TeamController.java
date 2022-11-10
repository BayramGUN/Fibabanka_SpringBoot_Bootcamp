package o.rm.database.orm.controller;

import o.rm.database.orm.Entity.relation.Player;
import o.rm.database.orm.Entity.relation.Team;
import o.rm.database.orm.repository.PlayerRepository;
import o.rm.database.orm.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sports")
public class TeamController {
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    public TeamController(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @GetMapping("/team/insert")
    @ResponseBody
    public String insertTeam() {
        Team teamA = new Team(0, "Godoro FC");
        teamA.setPlayerList(new ArrayList<>());
        Player playerOne = new Player(0, "Edinny Troure", 1.2);
        playerOne.setTeam(teamA);
        teamA.getPlayerList().add(playerOne);
        Player playerTwo = new Player(0, "Musa Traure", 2.2);
        playerTwo.setTeam(teamA);
        teamA.getPlayerList().add(playerTwo);
        teamRepository.save(teamA);
        return "sokuldu: ";
    }

    @GetMapping("/players/byteam")
    @ResponseBody
    public double getPlayersByTeam() {
        long teamId = 1;
        double totalScore = 0;
        List<Player> players = playerRepository.findAllByTeamId(teamId);
        for (var player : players) {
            totalScore += player.getAverageScore();
        }
        return totalScore / players.size();
    }
}

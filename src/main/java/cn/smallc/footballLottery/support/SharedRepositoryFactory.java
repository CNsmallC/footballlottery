package cn.smallc.footballLottery.support;

import cn.smallc.footballLottery.entity.MatchResult;
import cn.smallc.footballLottery.repository.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SharedRepositoryFactory {


    /**
     * 联赛分类仓储
     */
    private static LeagueTypeRepository leagueTypeRepository;

    /**
     * 联赛分类仓储
     */
    private static MatchRepository matchRepository;

    /**
     * 联赛分类仓储
     */
    private static ScoreRepository scoreRepository;


    /**
     * 联赛分类仓储
     */
    private static TeamRepository teamRepository;

    /**
     * 用户仓储
     */
    private static UserRepository userRepository;

    /**
     * 权限仓储
     */
    private static RoleRepository roleRepository;

    /**
     * 赛果仓储
     */
    private static MatchResultRepository matchResultRepository;

    public static MatchResultRepository getMatchResultRepository() {
        return matchResultRepository;
    }

    @Autowired
    public void setMatchResultRepository(MatchResultRepository matchResultRepository) {
        SharedRepositoryFactory.matchResultRepository = matchResultRepository;
    }

    public static RoleRepository getRoleRepository() {
        return roleRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        SharedRepositoryFactory.roleRepository = roleRepository;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        SharedRepositoryFactory.userRepository = userRepository;
    }

    public static ScoreRepository getScoreRepository() {
        return scoreRepository;
    }

    @Autowired
    public void setScoreRepository(ScoreRepository scoreRepository) {
        SharedRepositoryFactory.scoreRepository = scoreRepository;
    }


    public static LeagueTypeRepository getLeagueTypeRepository() {
        return leagueTypeRepository;
    }

    @Autowired
    public void setLeagueTypeRepository(LeagueTypeRepository leagueTypeRepository) {
        SharedRepositoryFactory.leagueTypeRepository = leagueTypeRepository;
    }

    public static MatchRepository getMatchRepository() {
        return matchRepository;
    }

    @Autowired
    public void setMatchRepository(MatchRepository matchRepository) {
        SharedRepositoryFactory.matchRepository = matchRepository;
    }

    public static TeamRepository getTeamRepository() {
        return teamRepository;
    }

    @Autowired
    public void setTeamRepository(TeamRepository teamRepository) {
        SharedRepositoryFactory.teamRepository = teamRepository;
    }

}

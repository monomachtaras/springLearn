package par.service;

import java.util.List;

import par.entity.Match;

public interface MatchService {
	
	void addMatch(int p1set, int p2set);
	Match getMatchByID(int id);
	List<Match> getAllMatches();

}

package models;

public class Team {
	 private String TeamName,TeamLeader;
	 private int CompetitionId,TeamId;
	 
	 public Team( String teamName,
			 String teamLeader
			 
			
            
) { 
		 TeamName=teamName;
		 TeamLeader=teamLeader;
		

}
	 public Team( int teamId,
			 String teamName,
			 String teamLeader
			
			
            
) { 
		 TeamId=teamId;
		 TeamName=teamName;
		 TeamLeader=teamLeader;
		

}

	public String getTeamLeader() {
		return TeamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		TeamLeader = teamLeader;
	}

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	public int getCompetitionId() {
		return CompetitionId;
	}

	public void setCompetitionId(int competitionId) {
		CompetitionId = competitionId;
	}

	public int getTeamId() {
		return TeamId;
	}

	public void setTeamId(int teamId) {
		TeamId = teamId;
	}

}

package models;

public class TeamsCompetition {
	
	
	 private int TeamId,CompetitionId,TeamsCompetitionId;
	 private Student StudentNumber;
	 
	 public TeamsCompetition(
			  int teamId,
			  int competitionId
			
           
) { 
 
		 TeamId=teamId;
		 CompetitionId=competitionId;

}
	 public TeamsCompetition( int teamsCompetitionId,
			  int teamId,
			  int competitionId
			
          
) { 
		 TeamsCompetitionId=teamsCompetitionId;
		 TeamId=teamId;
		 CompetitionId=competitionId;

}

	public int getTeamId() {
		return TeamId;
	}

	public void setTeamId(int teamId) {
		TeamId = teamId;
	}

	public int getCompetitionId() {
		return CompetitionId;
	}

	public void setCompetitionId(int competitionId) {
		CompetitionId = competitionId;
	}

	public int getTeamsCompetitionId() {
		return TeamsCompetitionId;
	}

	public void setTeamsCompetitionId(int teamsCompetitionId) {
		this.TeamsCompetitionId = teamsCompetitionId;
	}
	public Student getStudentNumber() {
		return StudentNumber;
	}
	public void setStudentNumber(Student studentNumber) {
		StudentNumber = studentNumber;
	}

}

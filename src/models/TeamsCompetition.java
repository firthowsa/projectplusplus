package models;

public class TeamsCompetition {
	
	
	 private int TeamId,CompetitionId,TeamsCompetitionId,Point;
	 private Student StudentNumber;
	 private String Solution;
	 
	 public TeamsCompetition(
			  int teamId,
			  int competitionId
			
           
) { 
 
		 TeamId=teamId;
		 CompetitionId=competitionId;

}
	 public TeamsCompetition( 
			  int teamId,
			  int competitionId,
			  String solution,
			  int point
			
          
) { 
		 
		 TeamId=teamId;
		 CompetitionId=competitionId;
		 Solution=solution;
		 Point=point;
		 

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
	public int getPoint() {
		return Point;
	}
	public void setPoint(int point) {
		Point = point;
	}
	public String getSolution() {
		return Solution;
	}
	public void setSolution(String solution) {
		Solution = solution;
	}

}

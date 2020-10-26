package models;

public class TeamMembers {
	 private String StudentNumber;
	 private int TeamId;
	 
	
	 public TeamMembers(
		 int teamId,
			 String studentNumber
            
) {TeamId=teamId;
  StudentNumber=studentNumber;

}

	public String getStudentNumber() {
		return StudentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		StudentNumber = studentNumber;
	}

	public int getTeamId() {
		return TeamId;
	}

	public void setTeamId(int teamId) {
		TeamId = teamId;
	}

	

}

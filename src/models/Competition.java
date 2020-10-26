package models;

import java.sql.Date;

import dao.TeamsCompetitionDAO;

public class Competition {
	
	private String Title, Category , Description , Rules , Prize ;
    private Date Deadline;
    private int CompetitionId ;

    public Competition(int competitionId,
    		       String title,
                   String category,
                   String description,
                   String rules,
                   String prize,
                   Date deadline
                   
    ) {
    	setCompetitionId(competitionId);
    	setTitle(title);
    	setCategory(category);
    	setDescription(description);
    	setRules(rules);
    	setPrize(prize);
    	setDeadline(deadline);
        
    }

    public Competition(
		       String title,
            String category,
            String description,
            String rules,
            String prize,
            Date deadline
            
) {
	
	setTitle(title);
	setCategory(category);
	setDescription(description);
	setRules(rules);
	setPrize(prize);
	setDeadline(deadline);
 
}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getRules() {
		return Rules;
	}

	public void setRules(String rules) {
		Rules = rules;
	}

	public Date getDeadline() {
		return Deadline;
	}

	public void setDeadline(Date deadline) {
		Deadline = deadline;
	}

	public int getCompetitionId() {
		return CompetitionId;
	}

	public void setCompetitionId(int competitionId) {
		CompetitionId = competitionId;
	}

	public String getPrize() {
		return Prize;
	}

	public void setPrize(String prize) {
		Prize = prize;
	}
	
	public boolean studentParticipating(String sId) {
		return TeamsCompetitionDAO.studentInCompetition(sId, CompetitionId);
	}
	
	public int countTeamSummissions(String sId) {
		return TeamsCompetitionDAO.countTeamSubmissions(sId, CompetitionId);
	}
}

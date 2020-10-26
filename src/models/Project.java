package models;

public class Project {
	private int projectId;
	private String level;
	private String category;
	private String description;
	private String title;
	public Project(){
		
	}
  public Project(int projectId,String title,String category,String level,String description){
	  this.level=level;
	  this.category=category;
	  this.description=description;
	  this.title=title;
	  this.projectId=projectId;
  }
  public Project(String title,String category,String level,String description){
	  this.level=level;
	  this.category=category;
	  this.description=description;
	  this.title=title;
	
  }
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

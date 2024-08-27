package practiceSerialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project1 {

	String projectName;
	String projectstatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;


	public Project1(String projectName, String projectstatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectName() {
		return projectName;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}
	public String getProjectstatus() {
		return projectstatus;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}
	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}
	public ProjectManager getProjectManager() {
		return projectManager;
	}

}

class ProjectManager {


	String name;
	String empId;


	public ProjectManager(String name, String empId) {
		super();
		this.name = name;
		this.empId = empId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpId() {
		return empId;
	}
}

public class Run3_POJO {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		
		List<String> lst=new ArrayList<String>();
		lst.add("Jhon");
		lst.add("devid");
		lst.add("steve");
		ProjectManager pm=new ProjectManager("sagar","tp01");
		Project1 projectObj=new Project1("Nisha","Created",9,lst,pm);
       ObjectMapper objM=new ObjectMapper();
       objM.writeValue(new File("./project1.json"), projectObj);
	}

}

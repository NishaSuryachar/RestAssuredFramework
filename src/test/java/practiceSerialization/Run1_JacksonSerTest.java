package practiceSerialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
	value= {  "createdBy",
			  "projectName",
			  "teamSize",
			  "status"	
	
} )

@JsonIgnoreProperties(
		
		value= { "teamSize"
				
				
		},allowSetters = true)
	

class project {     //POJO class[Plain old java Object]
	private String projectName;
	@JsonProperty(value = "created By")
	
	private String createdBy;
	private int teamSize;
	private String status;
	private project() {}
	public project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
public class Run1_JacksonSerTest {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		project pObj=new project("RP01","Nisha",10,"Created");
		//conversion is taking care by ObjectMapper
		ObjectMapper objM=new ObjectMapper();
		objM.writeValue(new File("./project.json"),pObj);
		System.out.println("====END====");
		
	}

}
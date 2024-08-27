package practiceSerialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run3_Jackson_deserTest {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		ObjectMapper objM=new ObjectMapper();
		project pObj = objM.readValue(new File("./project.json"), project.class);
		System.out.println(pObj.getProjectName());
		System.out.println(pObj.getCreatedBy());
		System.out.println(pObj.getStatus());
		System.out.println(pObj.getTeamSize());
	}

}

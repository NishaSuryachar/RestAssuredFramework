package practiceSerialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run1_deserTest{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fileIn=new FileInputStream("./N.txt");
		
		ObjectInputStream objIn=new ObjectInputStream(fileIn);
		NFSGame user1Obj=(NFSGame) objIn.readObject();
		
		System.out.println(user1Obj.name);
		System.out.println(user1Obj.level);
		System.out.println(user1Obj.score);
		System.out.println(user1Obj.life);
	}

}

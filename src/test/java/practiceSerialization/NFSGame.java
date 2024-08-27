package practiceSerialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NFSGame implements Serializable
{
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	public static void main(String[] args) throws Throwable  {
		NFSGame user1Obj=new NFSGame("Nisha",15,60000,1);
		FileOutputStream fileOut=new FileOutputStream("./N.txt");
        //converting java Object to binary data
		ObjectOutputStream objOut=new ObjectOutputStream(fileOut);
		objOut.writeObject(user1Obj);
		System.out.println("====END====");
	}
}

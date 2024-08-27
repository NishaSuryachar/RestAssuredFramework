package encryption;

import org.testng.annotations.Test;

public class AESEnpTest {

	@Test
	public void sampleTest() throws Exception
	{
		String privateKey="Ac03tEam@j!tu_#1";
		String data="{\r\n"
				+ "  \"name\":\"nisha\",\r\n"
				+ "  \"id\":\"tp-01\"\r\n"
				+ "}";
				
		EncrypAndDecryptUtility ed=new EncrypAndDecryptUtility();
//		System.out.println(ed.encrypt(data,privateKey));
		
		System.out.println(ed.decrypt("PARPBINXVULoCmjt1wC8qoFr7fZA978XSRi4j4a1LPKIDyjsLFiiJPxUGXVFFoLd", privateKey));
	}
}

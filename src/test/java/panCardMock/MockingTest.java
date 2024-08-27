package panCardMock;

import org.mockito.Mockito;

class PANCard{
	public String isValid(String pancard)
	{
		if(pancard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true){
			return "is valid pan";
	}else{
			return "is invalid pan";
		}
	}
	
	public static PANCard getMockObject()
	{
		PANCard mockObj=Mockito.mock(PANCard.class);
		Mockito.when(mockObj.isValid("ABCDE1234Q")).thenReturn("valid PAN card");
		Mockito.when(mockObj.isValid("ABCDE1234W")).thenReturn("valid PAN card");
		Mockito.when(mockObj.isValid("ABCDE1234E")).thenReturn("valid PAN card");
		return mockObj;
	}
}

public class MockingTest {

	public static void main(String[] args) {
		PANCard pObj= PANCard.getMockObject();
		System.out.println(pObj.isValid("ABCDE1234M"));
	}
}

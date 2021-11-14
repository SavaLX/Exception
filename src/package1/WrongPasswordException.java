package package1;

public class WrongPasswordException extends RuntimeException{

	public WrongPasswordException() {

	}

	public WrongPasswordException(String message) {
		System.out.println(message);
	}
}

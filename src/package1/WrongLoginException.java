package package1;

public class WrongLoginException extends RuntimeException {

	public WrongLoginException() {

	}

	public WrongLoginException(String message) {
		System.out.println(message);
	}
}

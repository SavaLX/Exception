package package1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionDemo {
	
	private final static int MAX_STRING_LENGTH = 20;
	private final static String REGEX = "[^\\w]";

	public static boolean isDataInCorrect(String login, String password, String confirmPassword){

		try {
			checkLogin(login);
			checkPassword(password);
			if(!password.equals(confirmPassword)) {
				throw new WrongPasswordException("The ConfirmPasswords don't match");
			}
		} catch (WrongLoginException | WrongPasswordException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	public static void checkLogin(String login) throws WrongLoginException {

		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(login);

		if (login == null || login.length() > MAX_STRING_LENGTH) {
			throw new WrongLoginException("Exception - login is too long");
		} else if (matcher.find()) {
			throw new WrongLoginException("Exception - login contains wrong symbols");
		} else {
			System.out.println("The login is correct");
		}
	}

	public static void checkPassword (String password) throws WrongPasswordException {

		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(password);
		

		if (password == null || password.length() > MAX_STRING_LENGTH) {
			throw new WrongPasswordException("Ecxeption - password is too long");
		} else if (matcher.find()) {
			throw new WrongPasswordException("Exception - password contains wrong symbols");
		} else {
			System.out.println("The password is correct");
		}
	}

}

package exceptions;

public class InvalidDataException extends NumberFormatException {
	
	String data ; 
	InvalidDataException(String line) {
		this.data = line ; 
		
	}
	
	public String getInvalidFormat() {
		return data ; 
	}

}

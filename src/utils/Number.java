package utils;

public class Number {
	private int number;
	
	public Number(String number) {
		this.number = parseNumber(number);
	}
	
	private int parseNumber(String number) {
		try {
			return Integer.parseInt(number);
		} catch(NumberFormatException e) {
			Common.errorMessage("숫자로 입력해 주세요.");
		}
		return 0;
	}
	
	public static Number from(String number) {
		return new Number(number);
	}
}

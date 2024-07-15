package common;

public class Calculator {
	private int result;
	
	
	
	public int getResult() {
		return result;
	}



	public Calculator(int no1, int no2, String operator) {
		switch(operator) {
		case "+":
			result = no1 + no2 ;
			break;
		case "-":
			result = no1 - no2;
			break;
		case "*":
			result = no1 * no2;
			break;
		default :
			result = no1 / no2;
			//break;없어도됨 디폴트가 끝이기때문
		}
		
		
		
		
	}
	
}

package chapter08.exam;

public class CalculatorImpl implements Calculator {

	@Override
	public long add(long n1, long n2) {
		return n1+n2;
	}

	@Override
	public long substract(long n1, long n2) {
		return n1-n2;
	}

	@Override
	public long multiply(long n1, long n2) {
		return n1*n2;
	}

	@Override
	public double divide(double n1, double n2) {
		return n1/n2;
	}

	public static void main(String[] args) {
		
		
		CalculatorImpl cal1 = new CalculatorImpl();
		Calculator cal2 = new CalculatorImpl();	// 인터페이스를 구현한 클래스 타입의 인스턴스를 참조하는 코드 작성
		
		Calculator cal3 = new Calculator() {	// 익명클래스 ; 오버라이딩 된 코드는 이 시점(인스턴스 만들 때)에 한 번 쓰고 끝나는 것 -> 별도 클래스 안 만들어도 된다
			
			@Override
			public long substract(long n1, long n2) {
				return n1+n2;
			}
			
			@Override
			public long multiply(long n1, long n2) {
				return n1-n2;
			}
			
			@Override
			public double divide(double n1, double n2) {
				return n1*n2;
			}
			
			@Override
			public long add(long n1, long n2) {
				return n1/n2;
			}
		};
	}
	
}

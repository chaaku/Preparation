abstract class Account {

	Account(int data) {
		System.out.print("Account is created with Balance :" + data);
	}
	abstract void closed();
	void name() {
		System.out.println(" and name is chandan");
	}
}

class Bank extends Account {

	Bank(int data) {
		super(data);
	}

	@Override
	void closed() {
		System.out.println("Bank Account is closed");
	}

}

class AbstractClass {
	public static void main(String[] args) {

		Account ob = new Bank(100);
		ob.name();
		ob.closed();
	}

}

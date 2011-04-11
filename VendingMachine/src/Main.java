//import VendingMachine;
//import VendingMachineItem;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VendingMachine vending = new VendingMachine();
		VendingMachineItem pepsi = new VendingMachineItem("pepsi", 1.25);
		vending.addItem(pepsi, "A");
		System.out.println("testing if the prog wroks while main class is there");
	}

}
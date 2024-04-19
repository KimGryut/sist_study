
public class Customer {
	String name;
	int type;
	int money;
	
	public Customer(String name, int type, int money) {
		this.name = name;
		this.type = type;
		this.money = money;
	}
	
	public Customer() {};
	
	public double getPrice() {
		double price=0;
		if (type==3) {
			price = 300000-((350000-money)*0.83); 
		} else if (type ==5) {
			price = 500000-((600000-money)*0.8);
		}
		return price;
	}
}


	

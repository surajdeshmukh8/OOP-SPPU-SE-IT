/**5.Interface -- CO1, CO3
Design and develop a context for given case study and implement an interface for Vehicles
Consider the example of vehicles like bicycle, car and bike. All Vehicles have common
functionalities such as Gear Change, Speed up and apply breaks. Make an interface and put all
these common functionalities. Bicycle, Bike, Car classes should be implemented for all these
functionalities in their own class in their own way. */

interface Vehicles {
	public void Speed_Up(int a);
	public void Gear_Change(int b);
	public void Apply_Break();
}

class Bicycle implements Vehicles {
	private int speed;
	int gear;

	public int getspeed() {
		return this.speed;
	}

	public void setspeed(int speed) {
		this.speed = speed;
	}

	public void Speed_Up(int increment) {
		speed = speed + increment;
	}

	public void Gear_Change(int change) {
		gear = change;
	}

	public void Apply_Break() {
		speed = speed - speed;
	}

	public void Display() {
		System.out.println("\n\nBicycle Status");
		System.out.println("Speed of the Bicycle is = " + speed + "km/hr");
		System.out.println("Gear of the Bicycle is = " + gear);
	}
}

class Car implements Vehicles {
	private int speed;
	int gear;

	public int getspeed() {
		return this.speed;
	}

	public void setspeed(int speed) {
		this.speed = speed;
	}

	public void Speed_Up(int increment) {
		speed = speed + increment;
	}

	public void Gear_Change(int change) {
		gear = change;
	}

	public void Apply_Break() {
		speed = speed - speed;
	}

	public void Display() {
		System.out.println("\n\nCar Status");
		System.out.println("Speed of the Car is = " + speed + "km/hr");
		System.out.println("Gear of the Car is = " + gear);
	}
}

class Bike implements Vehicles {
	private int speed;
	int gear;

	public void setspeed(int speed) {
		this.speed = speed;
	}

	public int getspeed() {
		return this.speed;
	}

	public void Speed_Up(int increment) {
		speed = speed + increment;
	}

	public void Gear_Change(int change) {
		gear = change;
	}

	public void Apply_Break() {
		speed = speed - speed;
	}

	public void Display() {
		System.out.println("\n\nBike Status");
		System.out.println("Speed of the Bike is = " + speed + "km/hr");
		System.out.println("Gear of the Bike is = " + gear);
	}
}

class Interface1 {
	public static void main(String[] args) {
		Bicycle obj1 = new Bicycle();
		obj1.setspeed(20);
		obj1.getspeed();
		obj1.Speed_Up(8);
		obj1.Gear_Change(4);
		obj1.Display();
		obj1.Apply_Break();
		obj1.Display();

		Car obj2 = new Car();
		obj2.setspeed(78);
		obj2.getspeed();
		obj2.Speed_Up(7);
		obj2.Gear_Change(3);
		obj2.Display();
		obj2.Apply_Break();
		obj2.Display();

		Bike obj3 = new Bike();
		obj3.setspeed(40);
		obj3.getspeed();
		obj3.Speed_Up(3);
		obj3.Gear_Change(2);
		obj3.Display();
		obj3.Apply_Break();
		obj3.Display();
	}
}

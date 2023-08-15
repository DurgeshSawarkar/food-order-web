package ashok.it;

import java.io.Serializable;

public class User implements Serializable {
	
private String name;
private long mobilenumber;
private String city;
private String item;
private double price;
private int qty;
private double totalPrice;

public User(){
	
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public long getMobilenumber() {
	return mobilenumber;
}

public void setMobilenumber(long mobilenumber) {
	this.mobilenumber = mobilenumber;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getItem() {
	return item;
}

public void setItem(String item) {
	this.item = item;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}


public int getQty() {
	return qty;
}

public void setQty(int qty) {
	this.qty = qty;
}

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

@Override
public String toString() {
	return "User [name=" + name + ", mobilenumber=" + mobilenumber + ", city=" + city + ", item=" + item + ", price="
			+ price + ", qty=" + qty + ", totalPrice=" + totalPrice + "]";
}






}

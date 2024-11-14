/**2. Polymorphism -- CO3
Identify commonalities and differences between Publication, Book and Magazine classes. Title,
Price, Copies are common instance variables and saleCopy is common method. The differences
are, Bookclass has author and orderCopies(). Magazine Class has methods orderQty, Current issue,
receiveissue().Write a program to find how many copies of the given books are ordered and
display total sale of publication. **/

public class Publication {
    private String title;
    private double price;
    private int copies;

    public int getCopies() {
        return this.copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void sellCopy(int qty) {
        System.out.println("Total Publication sell: $" + (qty * price));
    }
}

class Book extends Publication {
    private String author;

    public void orderCopies(int pCopies) {
        setCopies(getCopies() + pCopies);
        System.out.println("Total Order Copies: " + getCopies());
    }

    @Override
    public void sellCopy(int qty) {
        System.out.println("Total Book sell: $" + (qty * getPrice()));
    }
}

class Magazine extends Publication {
    private int orderQty;
    private String currIssue;

    public void recvNewIssue(String pNewIssue) {
        setCopies(orderQty);
        currIssue = pNewIssue;
    }

    @Override
    public void sellCopy(int qty) {
        System.out.println("Total Magazine sell: $" + (qty * getPrice()));
    }
}

 class Polymorphism {
    public static void main(String[] args) {
        Book obj1 = new Book();
        obj1.setPrice(10);
        obj1.orderCopies(3);

        Publication obj2 = new Book();
        obj2.setPrice(10);
        obj2.sellCopy(3);

        Publication obj3 = new Publication();
        obj3.setCopies(3);
        System.out.println("Copies available: " + obj3.getCopies());
        obj3.setPrice(20.3);
        System.out.println("Price: $" + obj3.getPrice());
        obj3.sellCopy(2);

        Magazine obj4 = new Magazine();
        obj4.setPrice(20.3);
        obj4.sellCopy(6);
    }
}

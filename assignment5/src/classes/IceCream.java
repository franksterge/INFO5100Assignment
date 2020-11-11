package classes;

public class IceCream extends DessertItem{
    protected int price;

    public IceCream(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int getCost() {
        return this.price;
    }
}


public class ItemCalculator implements Visitor {
    private double price;
    private String instructions;
    private String name;

    public void visitGlass(Glass g) {
        this.name = g.getName();
        int height = g.getHeight() + 1;
        int width = g.getWidth() + 1;
        int length = g.getLenght() + 1;
        this.instructions = "should be packed in a box with a dimension: " + height + "x" + length + "x"
                + width + " and filled with Bubble wraps.";
        length--;
        switch (g.getTickness()) {

            case 1:
                this.price = 2.0 * length / 100.0;
                break;
            case 2:
                this.price = 1.2 * length / 100.0;
                break;
            case 3:
                this.price = 0.7 * length / 100.0;
                break;
        }
    }

    public void visitFurniture(Furniture f) {
        this.name = f.getName();
        this.instructions = "should be covered with waterproof covers of: " + f.getLenght() + "x" + f.getWidth();
        this.price = 5.0 * f.getWeight() / 20.0;
    }

    public void visitElectronic(Electronic e) {
        this.name = e.getName();
        int height = e.getHeight() + 1;
        int width = e.getWidth() + 1;
        int length = e.getLenght() + 1;
        this.instructions = "should be covered with Polyethylene foam film and packed in a box with a dimension of "
                + height + "x" + length + "x"
                + width;
        this.price = e.fragile ? (5.0 * e.getWeight()) / 10.0 : (5.0 * e.getWeight()) / 15.0;
    }

    public void getResult(HouseholdItem h) {
        price = 0;
        instructions = "";
        h.accept(this);
        System.out.println("Total Cost for " + name + " is: " + price + " Euro");
        System.out.println(name + ":\n " + instructions);
    }
}

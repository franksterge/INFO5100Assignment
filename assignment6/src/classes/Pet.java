package classes;

public class Pet {
    private String name;
    private String ownerName;
    private String color;
    protected int sex;
    private static String[] POSSIBLE_SEXES = {"male", "female", "spayed", "neutered"};

    public Pet(String name, String ownerName, String color) {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return this.name;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getColor() {
        return this.color;
    }

    public String getSex() {
        try {
            return POSSIBLE_SEXES[this.sex];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Bad sexId";
        }
    }

    public void setSex(int sexid) {
        this.sex = sexid;
    }

    @Override
    public String toString() {
        String result = "";
        result += this.name + " owned by " + this.ownerName + "\n";
        result += "Color: " + this.color + "\n";
        result += "Sex: " + this.getSex();
        return result;
    }
}

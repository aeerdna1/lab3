import java.lang.Math;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;

class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox(){}

    public CandyBox(String flavor, String origin){
        this.flavor = flavor;
        this.origin = origin;
    }
    public float getVolume(){
        return 0;
    }

    @Override
    public String toString() {
        return "flavor='" + flavor + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    public String getOrigin() {

        return origin;
    }

    public void setOrigin(String origin) {

        this.origin = origin;
    }

    public String getFlavor() {

        return flavor;
    }

    public void setFlavor(String flavor) {

        this.flavor = flavor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyBox candyBox = (CandyBox) o;
        return Objects.equals(flavor, candyBox.flavor) && Objects.equals(origin, candyBox.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flavor, origin);
    }

    public void noInstanceof(){
    }
}

class Lindt extends CandyBox{
    float length;
    float width;
    float height;

    public Lindt(){}

    public Lindt(String flavor, String origin, float length,float width, float height){
        super.setFlavor(flavor);
        super.setOrigin(origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public float getVolume(){
        return length * width * height;
    }

    @Override
    public String toString() {
        return "The " + getOrigin() + " " +
                " " + getFlavor() + " " +
                "has volume " +getVolume() + " " + '}';
    }
    public String printLindtDim(Lindt cutie){
        return cutie.length + "," + cutie.width + "," + cutie.height;
    }

    public void noInstanceof(){
        System.out.println("Lindt bomboane fara instanceof");
    }
}

class Baravelli extends CandyBox {
    float radius;
    float height;

    public Baravelli() {
    }

    public Baravelli(String flavor, String origin, float radius, float height) {
        super.setFlavor(flavor);
        super.setOrigin(origin);
        this.radius = radius;
        this.height = height;
    }

    public float getVolume() {

        return (float) Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return "The " + getOrigin() + " " +
                " " + getFlavor() + " " +
                "has volume " + getVolume() + " " + '}';
    }

    public String printBaravelliDim(Baravelli cutie) {
        return cutie.radius + "," + cutie.height;
    }
    public void noInstanceof(){
        System.out.println("Baravelli bomboane fara instanceof");
    }
}


class ChocAmor extends CandyBox {
        float length;

        public ChocAmor() {
        }

        public ChocAmor(String flavor, String origin, float length) {
            super.setFlavor(flavor);
            super.setOrigin(origin);
            this.length = length;
        }

        public float getVolume() {
            return length * length * length;
        }

        @Override
        public String toString() {
            return "The " + getOrigin() + " " +
                     getFlavor() + " " +
                    "has volume " + getVolume() + " " + '}';
        }
        public float printChocAmorDim(ChocAmor cutie){
            return cutie.length;
        }

        public void noInstanceof(){
            System.out.println("ChocAmor bomboane fara instanceof");
        }
}

class CandyBag{
    ArrayList <CandyBox> bomboane = new ArrayList<>();

    public ArrayList addBomboane(){
        CandyBox l1 = new Lindt("Chocolate", "Italian", 1, 2, 3);
        CandyBox l2 = new Lindt("Pandishpan", "British", 5, 6, 7);
        CandyBox b1 = new Baravelli("Strawberry & Chocolate", "France", 8, 4);
        CandyBox b2 = new Baravelli("Bubble Vanilla", "Irish", 10, 2);
        CandyBox b3 = new Baravelli("BrownBerry", "Bulgarian", 6, 3);
        CandyBox c1 = new ChocAmor("Vanills", "Greek" ,10);
        CandyBox c2 = new ChocAmor("Strawberry", "Greek" ,7);
        CandyBox c3 = new ChocAmor("Marmelade", "Spanish" ,8);
        CandyBox c4 = new ChocAmor("BlueBerry", "Romanian" ,12);

        bomboane.add(l1);
        bomboane.add(l2);
        bomboane.add(b1);
        bomboane.add(b2);
        bomboane.add(b3);
        bomboane.add(c1);
        bomboane.add(c2);
        bomboane.add(c3);
        bomboane.add(c4);

        return bomboane;
    }

    @Override
    public String toString() {
        return "CandyBag{" +
                "bomboane=" + bomboane +
                '}';
    }
}

class Area{
    CandyBag bomboane;
    int number;
    String street;

    public Area(){}

    public Area(CandyBag bomboane, int number, String street){
        this.bomboane = bomboane;
        this.number = number;
        this.street = street;
    }


    public String getBirthdayCard(Area obj){
        //parcurgere array list si folosire tostring
        for(int j = 0; j <bomboane.bomboane.size(); j++){
            System.out.println(bomboane.bomboane.get(j).toString());
        }
        System.out.println("\n");

        //parcurgere arraylist si folosire instance of
        for(int i = 0; i < bomboane.bomboane.size(); i++){
            if(bomboane.bomboane.get(i) instanceof Lindt){
                System.out.println("Este Lindt si volumul este: " + ((Lindt)bomboane.bomboane.get(i)).getVolume());
                System.out.println(" Dimensiunile sunt :" + ((Lindt)bomboane.bomboane.get(i)).printLindtDim((Lindt)bomboane.bomboane.get(i)));
            }
            if(bomboane.bomboane.get(i) instanceof ChocAmor){
                System.out.println("Este ChocAmor si volumul este: " + ((ChocAmor)bomboane.bomboane.get(i)).getVolume());
                System.out.println(" Dimensiunile sunt :" + ((ChocAmor)bomboane.bomboane.get(i)).printChocAmorDim((ChocAmor)bomboane.bomboane.get(i)));
            }
            if(bomboane.bomboane.get(i) instanceof Baravelli){
                System.out.println("Este Baravelli si volumul este: " + ((Baravelli)bomboane.bomboane.get(i)).getVolume());
                System.out.println(" Dimensiunile sunt :" + ((Baravelli)bomboane.bomboane.get(i)).printBaravelliDim((Baravelli)bomboane.bomboane.get(i)));
            }
        }
        return "\nAdresa este: " + obj.street + ",nr " + obj.number + "\n" + "La multi ani!" + "\n";
    }

    //exemplu de evitare a instanceof
    public void noInstanceOfFunction(Area obj){
        for(int i = 0; i < bomboane.bomboane.size(); i++){
            bomboane.bomboane.get(i).noInstanceof();
        }
    }
}




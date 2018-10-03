package collections;

public class MyClass implements Comparable<MyClass> {

    private String label, value;

    public MyClass(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o){

        MyClass other = (MyClass) o;
        return this.value.equalsIgnoreCase(other.value);
    }

    @Override
    public String toString() {
        return label + " | " + value;
    }

    public int compareTo(MyClass other){
        return value.compareToIgnoreCase(other.value);
    }
}

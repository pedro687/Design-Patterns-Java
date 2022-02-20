package Creational.Singleton;

public class Demo {
    public static void main(String[] args) {
        var basic = BasicSingleton.getInstance();

        System.out.println(basic.getValue());
    }
}

class BasicSingleton {
    private BasicSingleton() {

    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    
}
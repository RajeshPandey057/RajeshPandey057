interface A {
    int x = 5;

    void display();
}

interface B extends A {
    int y = 6;
}

abstract class C implements A {
    int z = 7;
}

class D extends C implements B {
    public void display() {
        System.out.println("Numbers are: \n" + x + "\n" + y + "\n" + z);
    }
}

public class pra {
    public static void main(String[] args) {
        A temp = new D();
        temp.display();
    }
}

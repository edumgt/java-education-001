class MyClass {
    @Deprecated
    public void oldMethod() {
        System.out.println("This is old.");
    }

    public void newMethod() {
        System.out.println("This is new.");
    }
}

public class DepreTest {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.oldMethod();  // ⚠ 경고: deprecated
    }
}

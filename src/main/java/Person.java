public class Person {
    // ✅ property (field)
    private String name; // 속성(프로퍼티)
    private int age;
    private int val1;
    private int length; // 속성(프로퍼티)

    // ✅ constructor (생성자)
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ✅ method (행동/기능)
    public void sayHello() {
        System.out.println("안녕하세요, 저는 " + name + "이고 나이는 " + age + "입니다.");
    }

    // ✅ getter
    public String getName() {
        return name;
    }

    // ✅ setter
    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return 100;
    }

    // public void setLength(int _val) {
    //     this.val1 = _val;
    // }
}

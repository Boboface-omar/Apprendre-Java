public class User {
    public String name;
    public int age;
    
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void afficherInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}
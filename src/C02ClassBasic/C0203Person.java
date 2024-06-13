package C02ClassBasic;

public class C0203Person {
    private String name;
    private String email;
    private int age;

    public void eating(){
        System.out.println( this.name+ "님은 밥을 먹는다!");
    }

    public void setName(String name) {
       this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }



}

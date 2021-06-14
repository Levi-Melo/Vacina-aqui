package entities;


public class Person {
    public String name;
    public String cpf;
    public int age;
    public String email;
    public String password;
    public String address;
    public int addressNumber;
    public String state;
    public String city;
    public String district;
    public int cep;
    public int profileId;
    public boolean healthPosition;
    public int priority;
    public int id;

    public Person(String name, String cpf, int age, String email, String password, String address,
                  int addressNumber, String state, String city, String district, int cep,
                  int profileId, boolean healthPosition, int priority){

        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.email = email;
        this.password = password;
        this.address = address;
        this.addressNumber = addressNumber;
        this.state = state;
        this.city = city;
        this.district = district;
        this.cep = cep;
        this.profileId = profileId;
        this.healthPosition = healthPosition;
        this.priority = priority;

    }

    public Person(String name, String cpf, int age, String email, String address, int addressNumber, String state, String city, String district, int cep, boolean healthPosition, int priority) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.email = email;
        this.address = address;
        this.addressNumber = addressNumber;
        this.state = state;
        this.city = city;
        this.district = district;
        this.cep = cep;
        this.healthPosition = healthPosition;
        this.priority = priority;
        this.profileId = 3;
        this.password = "";
    }
    public Person(int id, String name, String cpf, int age, String state, String city, int priority) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.state = state;
        this.city = city;
        this.priority = priority;
    }


}


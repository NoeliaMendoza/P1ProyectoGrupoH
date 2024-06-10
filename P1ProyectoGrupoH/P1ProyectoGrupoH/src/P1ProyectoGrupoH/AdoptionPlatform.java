package P1ProyectoGrupoH;

import java.util.List;
import java.util.Scanner;

public abstract class AdoptionPlatform {
    // Atributos de la clase
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int age;
    private String idNumber;
    private String phone;

    // Constructor de la clase
    public AdoptionPlatform(String firstName, String lastName, String address, String email, int age, String idNumber, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.age = age;
        this.idNumber = idNumber;
        this.phone = phone;
    }

    // Método abstracto para registrar usuarios adoptantes
    public abstract void DataSubject(Scanner scanner);

    // Método abstracto para mostrar datos
    public abstract void showData();

    // Métodos Get y Set
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	
	
}

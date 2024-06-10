package P1ProyectoGrupoH;

import java.util.Scanner;

public class GrupoHPreAdoptionForm {

    ////// Encapsulation
    private String name;
    private String address;
    private String phoneNumber;
    private String occupation;
    private boolean petExperience;
    private boolean ownHome;
    
    ////// Constructor
    public GrupoHPreAdoptionForm(String name, String address, String phoneNumber, String occupation,
            boolean petExperience, boolean ownHome) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.petExperience = petExperience;
        this.ownHome = ownHome;
    }
    
    /// Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public boolean isPetExperience() {
        return petExperience;
    }
    public void setPetExperience(boolean petExperience) {
        this.petExperience = petExperience;
    }
    public boolean isOwnHome() {
        return ownHome;
    }
    public void setOwnHome(boolean ownHome) {
        this.ownHome = ownHome;
    }

    public static GrupoHPreAdoptionForm fillOutPreAdoptionForm(Scanner scanner) {
        System.out.println("====================================");
        System.out.println("PRE-ADOPTION FORM:                  ");
        System.out.println("====================================");

        System.out.println("INGRESA TU NOMBRE:");
        String name = scanner.nextLine();
        System.out.println("INGRESA TU DIRECCIÓN:");
        String address = scanner.nextLine();
        String phoneNumber;
        do {
            System.out.println("INGRESA EL TELÉFONO DEL USUARIO:");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")) {
                System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
            }
        } while (phoneNumber.length() != 10 || !phoneNumber.matches("\\d+"));

        System.out.println("INGRESA TU OCUPACIÓN:");
        String occupation = scanner.next();
        
        System.out.println("¿TIENES EXPERIENCIA CUIDANDO MASCOTAS? (true/false):");
        boolean petExperience = scanner.nextBoolean();
        
        System.out.println("¿POSEES HOGAR PROPIO? (true/false):");
        boolean ownHome = scanner.nextBoolean();

        GrupoHPreAdoptionForm preAdoptionForm = new GrupoHPreAdoptionForm(name, address, phoneNumber, occupation, petExperience, ownHome);
        preAdoptionForm.showPreAdoptionForm();
        return preAdoptionForm;
    }

    public void showPreAdoptionForm() {
        System.out.println("===================================:");
        System.out.println("PRE-ADOPTION FORM INFORMATION      :");
        System.out.println("===================================:");
        System.out.println("NAME: " + getName());
        System.out.println("ADDRESS: " + getAddress());
        System.out.println("PHONE NUMBER: " + getPhoneNumber());
        System.out.println("OCCUPATION: " + getOccupation());
        System.out.println("PET CARE EXPERIENCE: " + isPetExperience());
        System.out.println("OWN HOME: " + isOwnHome());
    }
    
}

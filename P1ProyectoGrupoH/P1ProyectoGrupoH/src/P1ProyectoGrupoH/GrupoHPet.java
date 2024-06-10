package P1ProyectoGrupoH;

public class GrupoHPet {

    // Attributes
    private String petType;
    private String name;
    private String gender;
    private String breed;
    private int vaccines;

    // Constructor
    public GrupoHPet(String petType, String name, String gender, String breed, int vaccines) {
        this.petType = petType;
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.vaccines = vaccines;
    }

    // Getters and Setters
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getVaccines() {
        return vaccines;
    }

    public void setVaccines(int vaccines) {
        this.vaccines = vaccines;
    }

    @Override
    public String toString() {
        return "===========================\n" +
               "PET DATA:\n" +
               "===========================\n" +
               "PET TYPE: " + petType + "\n" +
               "NAME: " + name + "\n" +
               "GENDER: " + gender + "\n" +
               "BREED: " + breed + "\n" +
               "NUMBER OF VACCINES: " + vaccines + "\n";
    }
}

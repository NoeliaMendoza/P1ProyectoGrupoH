package P1ProyectoGrupoH;

import java.util.List;
import java.util.Scanner;

public class GrupoHAdopter extends AdoptionPlatform{
    private String petType;

    // Constructor
    public GrupoHAdopter(String firstName, String lastName, String address, String email, int age, String idNumber, String phone, String petType) {
        super(firstName, lastName, address, email, age, idNumber, phone);
        this.petType = petType;
    }

    // Getters and Setters
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    // Method to register adopter
    public static void DataSubject(Scanner scanner, List<GrupoHPet> availablePets) {
        int adopterCount = 0;
        do {
            System.out.println("INGRESA LA CANTIDAD DE ADOPTANTES A REGISTRAR:");
            adopterCount = scanner.nextInt();
            if (adopterCount <= 0 || adopterCount >= 10) {
                System.out.println("ERROR: DEBE SER ENTRE 1 Y 10.");
            }
        } while (adopterCount <= 0 || adopterCount >= 10);

        GrupoHAdopter[] adopters = new GrupoHAdopter[adopterCount];
        for (int i = 0; i < adopterCount; i++) {
            System.out.println("INGRESA EL NOMBRE DEL ADOPTANTE " + (i + 1) + ":");
            String firstName = scanner.next();
            System.out.println("INGRESA EL APELLIDO DEL ADOPTANTE " + (i + 1) + ":");
            String lastName = scanner.next();
            System.out.println("INGRESA LA DIRECCIÓN DEL ADOPTANTE " + (i + 1) + ":");
            String address = scanner.next();
            System.out.println("INGRESA EL CORREO DEL ADOPTANTE " + (i + 1) + ":");
            String email = scanner.next();
            int age;
            do {
                System.out.println("INGRESA LA EDAD DEL ADOPTANTE " + (i + 1) + ":");
                age = scanner.nextInt();
                if (age <= 0 || age >= 60) {
                    System.out.println("INGRESA UNA EDAD DENTRO DEL RANGO (1-59):");
                }
                scanner.nextLine();
            } while (age <= 0 || age >= 60);

            System.out.println("INGRESE LA CÉDULA DEL ADOPTANTE " + (i + 1) + ":");
            String idNumber = scanner.nextLine();
            while (!validateIdNumber(idNumber)) {
                System.out.println("CÉDULA INVÁLIDA, INGRESE NUEVAMENTE:");
                idNumber = scanner.nextLine();
            }

            String phone;
            do {
                System.out.println("INGRESA EL TELÉFONO DEL ADOPTANTE " + (i + 1) + ":");
                phone = scanner.nextLine();
                if (phone.length() != 10 || !phone.matches("\\d+")) {
                    System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
                }
            } while (phone.length() != 10 || !phone.matches("\\d+"));

            String petType;
            boolean petAvailable;
            do {
                System.out.println("INGRESA EL TIPO DE MASCOTA QUE DESEA ADOPTAR " + (i + 1) + ":");
                petType = scanner.next();
                petAvailable = false;

                for (GrupoHPet pet : availablePets) {
                    if (pet.getPetType().equalsIgnoreCase(petType)) {
                        petAvailable = true;
                        break;
                    }
                }

                if (!petAvailable) {
                    System.out.println("MASCOTA NO DISPONIBLE. POR FAVOR INGRESA UN TIPO DE MASCOTA EXISTENTE.");
                }
            } while (!petAvailable);

            adopters[i] = new GrupoHAdopter(firstName, lastName, address, email, age, idNumber, phone, petType);
        }
        System.out.println("========================:");
        System.out.println("REGISTERED ADOPTERS:     ");
        System.out.println("========================:");

        for (int i = 0; i < adopterCount; i++) {
            adopters[i].showData();
        }
        System.out.println("=============================================:");
        System.out.println("GUARDAR INFORMACION DEL ADOPTANTE EN CSV:     ");
        System.out.println("=============================================:");
        Files.GenerateCsv(adopters);///////////Llama al metodo para generar el archivo csv y guardar sus respectivos datos
    }

 
	// Method to validate ID number
    private static boolean validateIdNumber(String idNumber) {
        if (idNumber.length() != 10) {
            System.out.println("LA CÉDULA DEBE TENER 10 DÍGITOS.");
            return false;
        }
        for (char c : idNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("LA CÉDULA SOLO DEBE TENER DÍGITOS.");
                return false;
            }
        }
        return true;
    }

   @Override
    public void showData() {
    	 System.out.println("===========================");
         System.out.println("SHOW USER DATA:            ");
         System.out.println("===========================");
         System.out.println("FIRST NAME : " + getFirstName());
         System.out.println("LAST NAME : " + getLastName());
         System.out.println("ADDRESS : " + getAddress());
         System.out.println("EMAIL : " + getEmail());
         System.out.println("AGE : " + getAge());
         System.out.println("ID NUMBER : " + getIdNumber());
         System.out.println("PHONE : " + getPhone());
        System.out.println("TIPO DE MASCOTA QUE DESEA ADOPTAR: " + getPetType());
    }

	
	
	public static void adoptPet(Scanner scanner, List<GrupoHPet> availablePets) {
        System.out.println("========================:");
        System.out.println("MASCOTAS DISPONIBLES:");
        System.out.println("========================:");

        for (int i = 0; i < availablePets.size(); i++) {
            System.out.println((i + 1) + ". " + availablePets.get(i).getName());
        }

        // Select an existing pet
        int petIndex;
        do {
            System.out.println("SELECCIONE EL NÚMERO DE LA MASCOTA QUE DESEA ADOPTAR:");
            while (!scanner.hasNextInt()) {
                System.out.println("ERROR: DEBE INGRESAR UN NÚMERO.");
                scanner.next(); // Consume the input
            }
            petIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Clear the buffer
            if (petIndex < 0 || petIndex >= availablePets.size()) {
                System.out.println("ERROR: SELECCIÓN INVÁLIDA. INTENTE DE NUEVO.");
            }
        } while (petIndex < 0 || petIndex >= availablePets.size());

        // Show the pre-adoption form
        GrupoHPreAdoptionForm preAdoptionForm = GrupoHPreAdoptionForm.fillOutPreAdoptionForm(scanner);

        // Clear the buffer after filling out the pre-adoption form
        scanner.nextLine();

        System.out.println("¿CONFIRMAR ADOPCIÓN DE " + availablePets.get(petIndex).getName() + "? (Yes/No):");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("Yes")) {
            System.out.println("MASCOTA ADOPTADA CORRECTAMENTE.");
            availablePets.remove(petIndex);
        } else {
            System.out.println("ADOPCIÓN CANCELADA.");
        }
    }

	@Override
	public void DataSubject(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	

}

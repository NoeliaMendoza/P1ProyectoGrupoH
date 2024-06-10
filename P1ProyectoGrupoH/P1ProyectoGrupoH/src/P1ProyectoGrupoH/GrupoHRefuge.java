package P1ProyectoGrupoH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrupoHRefuge {
    // Attributes
    private String name;
    private String address;
    private String phone;
    private List<GrupoHPet> pets;

    // Constructor
    public GrupoHRefuge(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.pets = new ArrayList<>();
    }

    // Getters and Setters
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<GrupoHPet> getPets() {
        return pets;
    }

    public void addPet(GrupoHPet pet) {
        this.pets.add(pet);
    }

    // Polymorphism
    @Override
    public String toString() {
        return "===========================\n" +
               "SHOW SHELTER DATA:\n" +
               "===========================\n" +
               "NAME : " + getName() + "\n" +
               "ADDRESS : " + getAddress() + "\n" +
               "PHONE : " + getPhone() + "\n";
    }

    // Method to manage shelters
    public static void manageShelters(Scanner scanner, List<GrupoHRefuge> shelters,
                                       List<GrupoHPet> availablePets) {
        int option;
        do {
        	System.out.println("===== GESTIONAR REFUGIOS =====");
			System.out.println("1. REGISTRAR REFUGIO");
			System.out.println("2. AGREGAR MASCOTA AL REFUGIO");
			System.out.println("3. SALIR");
			System.out.print("SELECCIONE UNA OPCION: ");
			option = scanner.nextInt();
			scanner.nextLine(); // Limpiar el buffer


            switch (option) {
                case 1:
                    registerShelter(scanner);
                    break;
                case 2:
                    registerPet(scanner, shelters, availablePets);
                    break;
                case 3:
                	System.out.println("================================");
    				System.out.println("SALIENDO DE GESTION DE REFUGIOS.");
    				System.out.println("================================");
                    break;
                default:
                	   System.out.println("============================================================================");
                       System.out.println("OPCION INGRESA ES INCORRECTA, VUELVA A INGRESAR UNA DENTRO DEL RANGO(1-3)   ");
                       System.out.println("============================================================================");

            }
        } while (option != 3);
    }
    
    // Method to register a shelter
    public static void registerShelter(Scanner scanner) {
        
        int shelterCount = 0;
        do {
            System.out.println("INGRESA LA CANTIDAD DE REFUGIOS A REGISTRAR:");
            shelterCount = scanner.nextInt();
            if (shelterCount <= 0 || shelterCount >= 10) {
                System.out.println("ERROR: DEBE SER ENTRE 1 Y 10.");
            }
        } while (shelterCount <= 0 || shelterCount >= 10);

        // Create array of shelters
        GrupoHRefuge[] shelters = new GrupoHRefuge[shelterCount];
        scanner.nextLine(); // Clean scanner buffer

        // Register each shelter
        for (int i = 0; i < shelterCount; i++) {
            System.out.println("===========================================");
            System.out.println("ENTER THE DATA FOR SHELTER " + (i + 1) + ":");
            System.out.println("===========================================");

            System.out.print("NOMBRE DEL REFUGIO: ");
            String name = scanner.nextLine();

            System.out.print("DIRECCION DEL REFUGIO: ");
            String address = scanner.nextLine();

            String phone;
            do {
                System.out.print("INGRESA EL TELÉFONO DEL REFUGIO: ");
                phone = scanner.nextLine();
                if (phone.length() != 10 || !phone.matches("\\d+")) {
                    System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
                }
            } while (phone.length() != 10 || !phone.matches("\\d+"));

            // Create and add shelter to array
            shelters[i] = new GrupoHRefuge(name, address, phone);
            System.out.println("REFUGIO REGISTRADO CON EXITO.");
        }
        // Show registered shelters
        System.out.println("========================:");
        System.out.println("REGISTERED SHELTERS:  ");
        System.out.println("========================:");
        for (int i = 0; i < shelterCount; i++) {
            System.out.println(shelters[i].toString());
        }
        
        Files.GenerateJson(shelters);///////Calls the method to save the information in the json file 
    }
    
    // Method to register a pet in a shelter
    public static void registerPet(Scanner scanner, List<GrupoHRefuge> shelters, 
                                    List<GrupoHPet> availablePets) {
        // Enter the number of pets to register
        int petCount;
        do {
	        System.out.println("INGRESE LA CANTIDAD DE MASCOTAS A REGISTRAR:");
            petCount = scanner.nextInt();
            scanner.nextLine(); // Clean scanner buffer
            if (petCount <= 0 || petCount >= 10) {
	            System.out.println("ERROR: DEBE SER ENTRE 1 Y 10.");
            }
        } while (petCount <= 0 || petCount >= 10);

        // Register each pet
        for (int i = 0; i < petCount; i++) {
	        System.out.println("================================================");
	        System.out.println("INGRESE LOS DATOS DE LA MASCOTA " + (i + 1) + ":");
	        System.out.println("================================================");

	        System.out.print("TIPO DE MASCOTA: ");
            String petType = scanner.nextLine();
	        System.out.print("NOMBRE DE LA MASCOTA: ");
            String petName = scanner.nextLine();
	        System.out.print("GÉNERO DE LA MASCOTA: ");
            String gender = scanner.nextLine();
	        System.out.print("RAZA DE LA MASCOTA: ");
            String breed = scanner.nextLine();
	        System.out.print("NÚMERO DE VACUNAS: ");
            int numVaccines = scanner.nextInt();
            scanner.nextLine(); // Clean scanner buffer

            // Add the pet to the list of available pets
            GrupoHPet newPet = new GrupoHPet(petType, petName, gender, breed, numVaccines);
            availablePets.add(newPet);

            System.out.println("MASCOTA AGREGADA A LA LISTA DEL REFUGIO");
        }

    }


}

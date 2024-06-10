package P1ProyectoGrupoH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Volunteer extends AdoptionPlatform {
    // Atributos propios de la clase Volunteer
    private String volunteerId; // Identificador único del voluntario
    private int hoursPerWeek;   // Horas trabajadas por semana

    // Lista para almacenar múltiples voluntarios
    private static List<Volunteer> volunteers = new ArrayList<>();

    // Constructor de la clase Volunteer
    public Volunteer(String firstName, String lastName, String address, String email, int age, String idNumber, String phone, String volunteerId, int hoursPerWeek) {
        super(firstName, lastName, address, email, age, idNumber, phone);
        this.volunteerId = volunteerId;
        this.hoursPerWeek = hoursPerWeek;
    }

    // Métodos propios de la clase Volunteer
    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

   

    @Override
    public void DataSubject(Scanner scanner) {
        int QuantityVolunteers;
        do {
            System.out.println("==============================================================");
            System.out.println("INGRESA LA CANTIDAD DE VOLUNTARIOS A REGISTRAR (entre 1 y 10):");
            System.out.println("==============================================================");
            while (!scanner.hasNextInt()) {
                System.out.println("ERROR: DEBE INGRESAR UN NÚMERO ENTERO.");
                scanner.next();
            }
            QuantityVolunteers = scanner.nextInt();
            if (QuantityVolunteers <= 0 || QuantityVolunteers > 10) {
                System.out.println("ERROR: DEBE SER ENTRE 1 Y 10.");
            }
        } while (QuantityVolunteers <= 0 || QuantityVolunteers > 10);
        scanner.nextLine(); // Consumir la nueva línea

        Volunteer[] volunteersArray = new Volunteer[QuantityVolunteers];
        for (int i = 0; i < QuantityVolunteers; i++) {
            System.out.println("INGRESA EL NOMBRE DEL VOLUNTARIO " + (i + 1) + ":");
            String firstName = scanner.nextLine();
            System.out.println("INGRESA EL APELLIDO DEL VOLUNTARIO " + (i + 1) + ":");
            String lastName = scanner.nextLine();
            System.out.println("INGRESA LA DIRECCIÓN DEL VOLUNTARIO " + (i + 1) + ":");
            String address = scanner.nextLine();
            System.out.println("INGRESA EL CORREO DEL VOLUNTARIO " + (i + 1) + ":");
            String email = scanner.nextLine();
            
            int age;
            do {
                System.out.println("INGRESA LA EDAD DEL VOLUNTARIO " + (i + 1) + ":");
                while (!scanner.hasNextInt()) {
                    System.out.println("ERROR: DEBE INGRESAR UN NÚMERO ENTERO.");
                    scanner.next();
                }
                age = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                if (age <= 0 || age >= 60) {
                    System.out.println("INGRESA UNA EDAD DENTRO DEL RANGO (1-59).");
                }
            } while (age <= 0 || age >= 60);

            String idNumber;
            do {
                System.out.println("INGRESE LA CÉDULA DEL VOLUNTARIO " + (i + 1) + ":");
                idNumber = scanner.nextLine();
                if (!validateIdNumber(idNumber)) {
                    System.out.println("CÉDULA INVÁLIDA, INGRESE NUEVAMENTE:");
                }
            } while (!validateIdNumber(idNumber));

            String phone;
            do {
                System.out.println("INGRESA EL TELÉFONO DEL VOLUNTARIO " + (i + 1) + ":");
                phone = scanner.nextLine();
                if (phone.length() != 10 || !phone.matches("\\d+")) {
                    System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
                }
            } while (phone.length() != 10 || !phone.matches("\\d+"));

            int volunteerId;
            do {
                System.out.println("ID del Voluntario " + (i + 1) + " (4 dígitos positivos):");
                while (!scanner.hasNextInt()) {
                    System.out.println("ERROR: DEBE INGRESAR UN NÚMERO ENTERO POSITIVO.");
                    scanner.next();
                }
                volunteerId = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                if (volunteerId < 0 || volunteerId > 9999) {
                    System.out.println("ID FUERA DEL RANGO PERMITIDO (0 - 9999).");
                }
            } while (volunteerId < 0 || volunteerId > 9999);
            
            System.out.println("Horas por semana del Voluntario " + (i + 1) + ":");
            int hoursPerWeek;
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("ERROR: DEBE INGRESAR UN NÚMERO ENTERO POSITIVO.");
                    scanner.next();
                }
                hoursPerWeek = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                if (hoursPerWeek <= 0) {
                    System.out.println("ERROR: DEBE INGRESAR UN NÚMERO ENTERO POSITIVO.");
                }
            } while (hoursPerWeek <= 0);

            volunteersArray[i] = new Volunteer(firstName, lastName, address, email, age, idNumber, phone, String.valueOf(volunteerId), hoursPerWeek);
            volunteers.add(volunteersArray[i]); // Agregar el voluntario a la lista de voluntarios
        }

        for (Volunteer volunteer : volunteersArray) {
            volunteer.showData();
            System.out.println();
        }
        
        Files.GenerarCsvVoluntarios( volunteersArray);//////LLAMA AL ARCHIVO CSV DONDE SE GUARDA LA INFORMACION DE LOS VOLUNTARIOS REGISTRADOS
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

    // Implementación del método abstracto showData
    @Override
    public void showData() {
        System.out.println("======================================:");
        System.out.println("INFORMACION DE LOS VOLUNTARIOS:");
        System.out.println("======================================:");
        System.out.println("NOMBRE: " + getFirstName());
        System.out.println("APELLIDO: " + getLastName());
        System.out.println("DIRECCION: " + getAddress());
        System.out.println("EMAIL: " + getEmail());
        System.out.println("EDAD: " + getAge());
        System.out.println("CEDULA: " + getIdNumber());
        System.out.println("TELEFONO: " + getPhone());
        System.out.println("ID : " + getVolunteerId());
        System.out.println("HORAS POR SEMANA: " + getHoursPerWeek());
    }

    // Método adicional para calcular las horas trabajadas en un mes
    public int calculateMonthlyHours() {
        return hoursPerWeek * 4;
    }

    // Método adicional para verificar si el voluntario es mayor de edad
    public boolean isAdult() {
        return getAge() >= 18;
    }

    public static void MenuVolunteer(Scanner scanner) {
        int choice;
        do {
            System.out.println("====================================:");
            System.out.println("MENU DE VOLUNTARIO                   ");
            System.out.println("1. AGREGAR VOLUNTARIO                ");
            System.out.println("2. MOSTRAR VOLUNTARIOS               ");
            System.out.println("3. ACTUALIZAR DATOS DEL VOLUNTARIO   ");
            System.out.println("4. ELIMINAR VOLUNTARIO POR ID        ");
            System.out.println("5. CACULO DE HORAS TRABAJADAS        ");
            System.out.println("6. SALIR                             ");
            System.out.print("INGRESA UNA OPCION                     ");
            choice = scanner.nextInt();
            System.out.println("===================================:");
            scanner.nextLine(); // Consumir la nueva línea
            switch (choice) {
                case 1:
                    addNewVolunteer(scanner);
                    break;
                case 2:
                    showAllVolunteers();
                    break;
                
                case 3:
                    updateVolunteer(scanner);
                    break;
                case 4:
                    removeVolunteer(scanner);
                    break;
                case 5:
                    calculateTotalHoursWorked();
                    break;
               
                case 6:
                	System.out.println("=========================================");
                    System.out.println("THANK YOU VERY MUCH, HAVE A GOOD DAY     ");
                    System.out.println("=========================================");
                    break;
                default:
                	 System.out.println("============================================================================");
                     System.out.println("THE OPTION ENTERED IS INCORRECT, PLEASE ENTER ONE WITHIN THE RANGE (1-6)   ");
                     System.out.println("============================================================================");

            }
        } while (choice != 6);
    }

    public static void addNewVolunteer(Scanner scanner) {
        System.out.println("AGREGANDO NUEVO VOLUNTARIO:");
        Volunteer volunteer = new Volunteer(null, null, null, null, 0, null, null, null, 0);
        volunteer.DataSubject(scanner);
    }

    public static void showAllVolunteers() {
        if (volunteers.isEmpty()) {
            System.out.println("NO HAY VOLUNTARIOS REGISTRADOS.");
        } else {
            for (Volunteer volunteer : volunteers) {
                volunteer.showData();
                System.out.println("===========================");
            }
        }
    }

    public static Volunteer findVolunteerById(String updateId) {
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getVolunteerId().equals(updateId)) {
                return volunteer;
            }
        }
        return null;
    }

    public static void updateVolunteer(Scanner scanner) {
        System.out.print("INGRESA EL ID DEL VOLUNTARIO A ACTUALIZAR: ");
        String updateId = scanner.nextLine();
        Volunteer updateVolunteer = findVolunteerById(updateId);
        if (updateVolunteer != null) {
            updateVolunteer.updateVolunteerData(scanner, volunteers);
        } else {
            System.out.println("NO SE ENCONTRO NINGUN VOLUNTARIO CON ESE ID.");
        }
    }

    public void updateVolunteerData(Scanner scanner, List<Volunteer> volunteers2) {
        System.out.println("===================================:");
        System.out.println("ACTUALIZANDO DATOS DEL VOLUNTARIO:");
        System.out.println("===================================:");
        System.out.print("INGRESA EL ID DEL VOLUNTARIO A ACTUALIZAR: ");
        String updateId = scanner.nextLine();
        
        // Buscamos el voluntario por su ID
        Volunteer updateVolunteer = null;
        for (Volunteer volunteer : volunteers2) {
            if (volunteer.getVolunteerId().equals(updateId)) {
                updateVolunteer = volunteer;
                break;
            }
        }

        // Verificamos si se encontró el voluntario
        if (updateVolunteer != null) {
            System.out.print("NUEVO NOMBRE: ");
            updateVolunteer.setFirstName(scanner.nextLine());
            System.out.print("NUEVO APELLIDO: ");
            updateVolunteer.setLastName(scanner.nextLine());
            System.out.print("NUEVA DIRRECCION: ");
            updateVolunteer.setAddress(scanner.nextLine());
            System.out.print("NUEVO EMAIL: ");
            updateVolunteer.setEmail(scanner.nextLine());
            
            int newAge;
            do {
                System.out.print("NUEVA EDAD : ");
                newAge = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                if (newAge <= 0 || newAge >= 60) {
                    System.out.println("INGRESA UNA EDAD DENTRO DEL RANGO (1-59):");
                }
            } while (newAge <= 0 || newAge >= 60);
            updateVolunteer.setAge(newAge);

            String newIdNumber;
            do {
                System.out.print("NUEVA CEDULA: ");
                newIdNumber = scanner.nextLine();
                if (!validateIdNumber(newIdNumber)) {
                    System.out.println("CÉDULA INVÁLIDA, INGRESE NUEVAMENTE:");
                }
            } while (!validateIdNumber(newIdNumber));
            updateVolunteer.setIdNumber(newIdNumber);

            String newPhone;
            do {
                System.out.print("NUEVO TELEFONO: ");
                newPhone = scanner.nextLine();
                if (newPhone.length() != 10 || !newPhone.matches("\\d+")) {
                    System.out.println("ERROR: EL TELÉFONO DEBE CONTENER EXACTAMENTE 10 DÍGITOS NUMÉRICOS.");
                }
            } while (newPhone.length() != 10 || !newPhone.matches("\\d+"));
            updateVolunteer.setPhone(newPhone);

            // No se permite modificar el ID del voluntario

            System.out.print("NUEVAS HORAS POR SEMANA: ");
            updateVolunteer.setHoursPerWeek(scanner.nextInt());
            scanner.nextLine(); // Consumir la nueva línea
            System.out.println("DATOS DEL VOLUNTARIO ACTUALIZADOS CORRECTAMENTE.");
        } else {
            System.out.println("NO SE ENCONTRO NINGUN VOLUNTARIO CON ESE ID.");
        }
    }


    public static void removeVolunteer(Scanner scanner) {
        System.out.print("INGRESA EL ID DEL VOLUNTARIO A ELIMINAR: ");
        String removeId = scanner.nextLine();
        if (removeVolunteerById(removeId)) {
            System.out.println("VOLUNTARIO ELIMINADO CON EXITO.");
        } else {
            System.out.println("NO SE ENCONTRO NINGUN VOLUNTARIO CON ESE ID.");
        }
    }

    public static boolean removeVolunteerById(String volunteerId) {
        return volunteers.removeIf(volunteer -> volunteer.getVolunteerId().equals(volunteerId));
    }

    public static void calculateTotalHoursWorked() {
        int totalHours = 0;
        for (Volunteer volunteer : volunteers) {
            totalHours += volunteer.calculateMonthlyHours();
        }
        System.out.println("El TOTAL DE HORAS TRABAJADAS POR TODOS LOS VOLUNTARIOS ES: " + totalHours);
    }

    
}

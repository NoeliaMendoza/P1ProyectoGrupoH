package P1ProyectoGrupoH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1ProyectoGrupoH {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<GrupoHPet> availablePets = new ArrayList<>();
        List<GrupoHRefuge> refuges = new ArrayList<>();
        List<GrupoHFollowUp> followUps = new ArrayList<>();
        
        /*System.out.println("======================================================================");
        System.out.println("STATIC LIST OF AVAILABLE ANIMALS FOR ADOPTION                        ");
        System.out.println("======================================================================");
        */
        availablePets.add(new GrupoHPet("Dog", "Firulais", "Male", "Labrador", 5));
        availablePets.add(new GrupoHPet("Cat", "Misu", "Female", "Siamese", 3));
        // Add more pets here...
        menu(scanner, availablePets, refuges, followUps);
    }

    public static void cover() {
        System.out.println("===========================================");
        System.out.println("UNIVERSIDAD DE LAS FUERZAS ARMADAS ESPE-SS ");
        System.out.println("OBJECT-ORIENTED PROGRAMMING                ");
        System.out.println("PLATAFORMA DE ADOPCION PARA ANIMALES       ");
        System.out.println("LOMBEIDA ANA                               ");
        System.out.println("NOELIA MENDOZA                             ");
        System.out.println("===========================================");

    }

    public static void menu(Scanner scanner, List<GrupoHPet> availablePets, List<GrupoHRefuge> refuges, List<GrupoHFollowUp> followUps) {
        int menuOp = 0;
        do {
            cover();
            System.out.println("=========================================");
            System.out.println("            MENU DE OPCIONES             ");
            System.out.println("1. REGISTRAR AL ADOPTANTE");
            System.out.println("2. MOSTRAR MASCOTAS DISPONIBLES");
            System.out.println("3. GESTIONAR REFUGIOS");
            System.out.println("4. GESTIONAR SEGUIMIENTOS");
			System.out.println("5. ADOPTAR MASCOTA");
			System.out.println("6. GESTINAR VOLUNTARIOS");
            System.out.println("7. SALIR");
            System.out.println("INGRESE UNA OPCION");
            menuOp = scanner.nextInt();
            switch (menuOp) {
 
                case 1:
                	  System.out.println("=========================================");
                      GrupoHAdopter.DataSubject( scanner, availablePets);
                      System.out.println("=========================================");
                    break;
                case 2:
                    System.out.println("=========================================");
                    showAvailablePets(availablePets);
                    System.out.println("=========================================");
                    break;
                case 3:
                    System.out.println("=========================================");
                    GrupoHRefuge.manageShelters(scanner, refuges, availablePets);
                    System.out.println("=========================================");
                    break;
                case 4:
                    System.out.println("=========================================");
                    GrupoHFollowUp.manageFollowUps(scanner, followUps); 
                    System.out.println("=========================================");
                    break;
                case 5:
                    System.out.println("=========================================");
                    GrupoHAdopter.adoptPet( scanner, availablePets);
                    System.out.println("=========================================");
                    break;
                case 6:
                    System.out.println("=========================================");
                    Volunteer.MenuVolunteer(scanner) ;
                    System.out.println("=========================================");
                    break;
                case 7:
                    System.out.println("=========================================");
                    System.out.println("THANK YOU VERY MUCH, HAVE A GOOD DAY     ");
                    System.out.println("=========================================");
                    break;
                default:
                    System.out.println("============================================================================");
                    System.out.println("THE OPTION ENTERED IS INCORRECT, PLEASE ENTER ONE WITHIN THE RANGE (1-6)   ");
                    System.out.println("============================================================================");
            }
        } while (menuOp != 7);
    }

    public static void showAvailablePets(List<GrupoHPet> availablePets) {
        System.out.println("MASCOTAS DISPONIBLES PARA ADOPCIÓN:");
        for (GrupoHPet pet : availablePets) {
            System.out.println(pet);
        }
    }
}

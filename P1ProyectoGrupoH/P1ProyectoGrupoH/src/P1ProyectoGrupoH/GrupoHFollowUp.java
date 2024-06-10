package P1ProyectoGrupoH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrupoHFollowUp {
    private String adopterName;
    private String adopterID;
    private String petName;
    private List<String> reports;

    public GrupoHFollowUp(String adopterName, String adopterID, String petName) {
        this.adopterName = adopterName;
        this.adopterID = adopterID;
        this.petName = petName;
        this.reports = new ArrayList<>();
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getAdopterID() {
        return adopterID;
    }

    public void setAdopterID(String adopterID) {
        this.adopterID = adopterID;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public List<String> getReports() {
        return reports;
    }

    public void addReport(String report) {
        this.reports.add(report);
    }

    @Override
    public String toString() {
        return "===========================\n" +
                "FOLLOW-UP DATA:\n" +
                "===========================\n" +
                "ADOPTER'S NAME: " + getAdopterName() + "\n" +
                "ID: " + getAdopterID() + "\n" +
                "PET'S NAME: " + getPetName() + "\n" +
                "REPORTS: " + getReports() + "\n";
    }

    public static void manageFollowUps(Scanner scanner, List<GrupoHFollowUp> followUps) {
        int option;
        do {
        	System.out.println("===== GESTIONAR SEGUIMIENTOS =====");
			System.out.println("1. Registrar nuevo seguimiento");
			System.out.println("2. Agregar reporte de seguimiento");
			System.out.println("3. Mostrar seguimientos");
			System.out.println("4. Salir");
			System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (option) {
                case 1:
                	registerFollowUps(scanner, followUps);
                    break;
                case 2:
                    addFollowUpReport(scanner, followUps);
                    break;
                case 3:
                    showFollowUps(followUps);
                    break;
                case 4:
                    System.out.println("=============================");
                    System.out.println("Exiting follow-up management.");
                    System.out.println("=============================");

                    break;
                default:
                    System.out.println("=================================");
                    System.out.println("Invalid option. Please try again.");
                    System.out.println("=================================");

            }
        } while (option != 4);
    }
 // Método para registrar seguimientos
    public static void registerFollowUps(Scanner scanner, List<GrupoHFollowUp> followUps) {
    	
    	 int followUpCount=0;
    	 
    	 do {
    		 System.out.println("Ingrese la cantidad de seguimientos a registrar: ");
             followUpCount = scanner.nextInt();
             if(followUpCount<=0|| followUpCount>=10) {   	 
        		 System.out.println("Error ingresa dentro del rango el seguimiento(1-10): ");
             }
    	 }while(followUpCount<=0|| followUpCount>=10);
        
        scanner.nextLine(); // Limpiar el buffer

        for (int i = 0; i < followUpCount; i++) {
            System.out.println("===========================================");
            System.out.println("REGISTRAR SEGUIMIENTO " + (i + 1) + ":");
            System.out.println("===========================================");

            System.out.print("NOMBRE DEL ADOPTANTE: ");
            String adopterName = scanner.nextLine();

            System.out.print("CEDULA DEL ADOPTANTE: ");
            String adopterID = scanner.nextLine();
            while (!validateID(adopterID)) {
                System.out.println("CEDULA INVALIDA, INGRESE NUEVAMENTE.");
                adopterID = scanner.nextLine();
            }

            System.out.print("NOMBRE DE LA MASCOTA: ");
            String petName = scanner.nextLine();

            GrupoHFollowUp followUp = new GrupoHFollowUp(adopterName, adopterID, petName);
            followUps.add(followUp);
            System.out.println("SEGIMIENTO REGISTRADO CON EXITO.");
        }
    }

    private static boolean validateID(String id) {
        if (id.length() != 10) {
        	System.out.println("LA CEDULA DEBE DE TENER 10 DIGITOS.");
            return false;
        }
        for (char c : id.toCharArray()) {
            if (!Character.isDigit(c)) {
            	System.out.println("LA CEDULA SOLO DEBE TENER DIGITOS POSITIVOS.");
                return false;
            }
        }
        // Additional validation logic can be added here for specific ID structures
        return true;
    }

    public static void addFollowUpReport(Scanner scanner, List<GrupoHFollowUp> followUps) {
		System.out.println("SELECIONA UN SEGUMIENTO:");
        for (int i = 0; i < followUps.size(); i++) {
            System.out.println((i + 1) + ". " + followUps.get(i).getAdopterName() + " - "
                    + followUps.get(i).getPetName());
        }
        int followUpIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Clear the buffer

        if (followUpIndex >= 0 && followUpIndex < followUps.size()) {
        	System.out.print("AGREGAR REPORTE AL SEGUIMIENTO: ");
            String report = scanner.nextLine();
            followUps.get(followUpIndex).addReport(report);
			System.out.println("REPORTE AGREGADO AL SEGUIMIENTO.");
        } else {
			System.out.println("SEGUIMIENTO NO VALIDO.");
        }
    }

    public static void showFollowUps(List<GrupoHFollowUp> followUps) {
        for (GrupoHFollowUp followUp : followUps) {
            System.out.println(followUp);
        }
    }
}

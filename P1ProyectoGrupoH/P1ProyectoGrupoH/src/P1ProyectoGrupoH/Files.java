package P1ProyectoGrupoH;

////////////Libraries
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Files {

//////////Method to generate writing and reading of data by saving array data to the csv file
static void GenerateCsv(GrupoHAdopter[] adopters) {

try (FileWriter file = new FileWriter("Adopters.csv", true);
   PrintWriter writer = new PrintWriter(file)) {
  for (GrupoHAdopter a : adopters) {
      writer.println(a.getFirstName() + "," + a.getLastName() + "," + a.getAddress() + "," + a.getEmail() + ","
              + a.getAge() + "," + a.getIdNumber()+ "," + a. getPhone() + "," + a.getPetType());
  }
  System.out.println("CSV FILE GENERATED SUCCESSFULLY");
} catch (IOException e) {
  System.out.println("ERROR GENERATING CSV FILE " + e.getMessage());
}
}

    //////////Method to generate writing and reading of data by saving array data to the Json file
    static void GenerateJson(GrupoHRefuge[] refuges) {
        try (FileWriter file = new FileWriter("RegisterRefuges.json", true);
             PrintWriter writer = new PrintWriter(file)) {
            for (GrupoHRefuge r : refuges) {
                writer.println("{");
                writer.println("  \"Name\": \"" + r.getName() + "\",");
                writer.println("  \"Address\": \"" + r.getAddress() + "\",");
                writer.println("  \"Phone\": \"" + r.getPhone() + "\",");
                writer.println("}");
            }
            System.out.println("JSON FILE GENERATED SUCCESSFULLY");

        } catch (IOException e) {
            System.out.println("ERROR GENERATING JSON FILE" + e.getMessage());
        }
    }
    
    
    static void GenerarCsvVoluntarios(Volunteer[] volunteersArray) {
    	try(FileWriter  file= new FileWriter("Voluntarios.csv",true);
    			PrintWriter writer= new PrintWriter(file)){
    		
    		for(Volunteer v:volunteersArray) {
    			
    			writer.println(v.getFirstName()+","+v.getLastName()+","+v.getAddress()+","+v.getEmail()+","+v.getAge()+","+v.getIdNumber()
    			+","+v.getPhone()+","+v.getVolunteerId()+","+v.getHoursPerWeek());
    		}
    		  System.out.println("CSV FILE GENERATED SUCCESSFULLY");

    	}catch(IOException e) {
      	  System.out.println("ERROR GENERATING CSV FILE ");

    	}


    }
    
    

}

package tutorial;

import APP_Business_Rules.RestaurantUseCase.RestaurantFileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;


public class FileReader1Test {
    @Test
    public void createListTestSize(){
        RestaurantFileReader fileReader = new RestaurantFileReader("C:\\Users\\Emily\\IdeaProjects\\course-project-digitaldiningdivas\\src\\main\\java\\Frameworks_and_Drivers\\Restaurant.csv");
        int size = fileReader.createList().get(0).size();
        Assertions.assertEquals(size, 4);

    }
    @Test
    public void createListTest(){
        RestaurantFileReader fileReader = new RestaurantFileReader("C:\\Users\\Emily\\IdeaProjects\\course-project-digitaldiningdivas\\src\\main\\java\\Frameworks_and_Drivers\\Restaurant.csv");
        List<String> listOfRes = Arrays.asList("Aburi Hana","Japanese", "102 Yorkville Ave", "1");
        Assertions.assertEquals(fileReader.createList().get(0), listOfRes);

    }

}

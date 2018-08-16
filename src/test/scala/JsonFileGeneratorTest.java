import DataConstuctor.Daily;
import DataConstuctor.DataConstructor;
import graphgenerator.JsonFileGenerator;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonFileGeneratorTest {

    private String mockJsonFileName = "dailies.json";
    private Path mockOutputDirectory = Paths.get(".", "test", "out");
    private Path mockJsonFilePath = mockOutputDirectory.resolve(mockJsonFileName);
    private JsonFileGenerator jsonFileGenerator;

    @Before
    public void setup() {
        mockOutputDirectory.toFile().mkdirs();
        if(mockJsonFilePath.toFile().exists()) {
            mockJsonFilePath.toFile().delete();
        }
        this.jsonFileGenerator = new JsonFileGenerator("dailies.json");
    }

    @Test
    public void testGenerateEmptyDailies() {
        Daily[] dailies = new Daily[0];
        int totalHostnames = 0;
        jsonFileGenerator.generateJson(dailies, totalHostnames, mockOutputDirectory);
    }

    @Test
    public void testGenerateDailies() {
        Daily d1 = new Daily();
        Daily d2 = new Daily();
        d1.todayUniqueHostnames = 27;
        d1.totalUniqueHostnames = 27;
        d2.todayUniqueHostnames = 3;
        d2.totalUniqueHostnames = 30;
        int totalHostnames = 30;
        jsonFileGenerator.generateJson(new Daily[]{d1, d2}, totalHostnames, mockOutputDirectory);
    }
}

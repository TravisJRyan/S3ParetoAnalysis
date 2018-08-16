import DataConstuctor.Daily;
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
    private void setup() {
        mockOutputDirectory.toFile().mkdirs();
        if(mockJsonFilePath.toFile().exists()) {
            mockJsonFilePath.toFile().delete();
        }
        this.jsonFileGenerator = new JsonFileGenerator("dailies.json");
    }

    @Test
    public void testGenerateEmptyDailies() {
        Daily[] dailies = new Daily[0];
        int totalHostnames = 6;
        jsonFileGenerator.generateJson(dailies, totalHostnames, mockOutputDirectory);
    }

}

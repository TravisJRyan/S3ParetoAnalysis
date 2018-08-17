
import DataConstuctor.Daily;
import DataConstuctor.DataConstructorInterface;
import graphgenerator.GraphGenerator;
import graphgenerator.JsonFileGenerator;
import graphgenerator.StaticFileGenerator;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GraphGeneratorTest {

    private Path outputDirectory = Paths.get(".", "test", "out");
    private String htmlFileName = "index.html";
    private String jsFileName = "index.js";
    private String jsonFileName = "dailies.json";
    private DataConstructorInterface mockDataConstructor;
    private StaticFileGenerator staticFileGenerator;
    private JsonFileGenerator jsonFileGenerator;
    private GraphGenerator graphGenerator;

    @Before
    public void setup() {
        if(!outputDirectory.toFile().exists()) {
            outputDirectory.toFile().mkdirs();
        }
        deleteHtmlFileIfExists();
        deleteJsFileIfExists();
        deleteJsonFileIfExists();
        mockDataConstructor = mock(DataConstructorInterface.class);
        staticFileGenerator = new StaticFileGenerator(htmlFileName, jsFileName);
        jsonFileGenerator = new JsonFileGenerator(jsonFileName);
        graphGenerator = new GraphGenerator(outputDirectory, mockDataConstructor, staticFileGenerator, jsonFileGenerator);
    }

    private void deleteHtmlFileIfExists() {
        Path htmlFilePath = outputDirectory.resolve(htmlFileName);
        if(htmlFilePath.toFile().exists()) {
            htmlFilePath.toFile().delete();
        }
    }

    private void deleteJsFileIfExists() {
        Path jsFilePath = outputDirectory.resolve(jsFileName);
        if(jsFilePath.toFile().exists()) {
            jsFilePath.toFile().delete();
        }
    }

    private void deleteJsonFileIfExists() {
        Path jsonFilePath = outputDirectory.resolve(jsonFileName);
        if(jsonFilePath.toFile().exists()) {
            jsonFilePath.toFile().delete();
        }
    }

    @Test
    public void testCleanup() {
        cleanup();
    }

    @Test
    public void testGenerateWithEmptyDailies() {

        when(mockDataConstructor.generateDailies()).thenReturn(new Daily[0]);
        when(mockDataConstructor.totalHostnames()).thenReturn(0);

        graphGenerator.generateParetoChart();
    }

    private void cleanup() {
        try {
            Path test = Paths.get(".", "test");
            FileUtils.deleteDirectory(test.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

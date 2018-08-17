import graphgenerator.StaticFileGenerator;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class StaticFileGeneratorTest {

    private String htmlFileName = "index.html";
    private String jsFileName = "index.js";
    private Path outputDirectory = Paths.get(".", "test", "out");
    private StaticFileGenerator staticFileGenerator;

    @Before
    public void setup() {
        if(!outputDirectory.toFile().exists()) {
            outputDirectory.toFile().mkdirs();
        }
        deleteHtmlFileIfExists();
        deleteJsFileIfExists();
        this.staticFileGenerator = new StaticFileGenerator(htmlFileName, jsFileName);
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

    @Test
    public void testCopyHtmlFile() {
        staticFileGenerator.generateStaticFiles(outputDirectory);
    }
}

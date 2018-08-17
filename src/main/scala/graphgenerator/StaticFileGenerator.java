package graphgenerator;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Path;

public class StaticFileGenerator {

    private String htmlFileName;
    private String jsonFileName;

    public StaticFileGenerator(String htmlFileName, String jsonFileName) {
        this.htmlFileName = htmlFileName;
        this.jsonFileName = jsonFileName;
    }

    public void generateStaticFiles(Path outputDirectory) {
        InputStream htmlInputStream = getHtmlFileInputStream();
        InputStream jsInputStream = getJsFileInputStream();
        File htmlOutputFile = getHtmlOutputFile(outputDirectory);
        OutputStream jsOutputStream = getJsFileOutputStream();

        try {
            FileUtils.copyInputStreamToFile(htmlInputStream, htmlOutputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private InputStream getHtmlFileInputStream() {
        return ClassLoader.getSystemResourceAsStream("index.html");
    }

    private InputStream getJsFileInputStream() {
        return null;
    }

    private File getHtmlOutputFile(Path outputDirectory) {
        return outputDirectory.resolve(htmlFileName).toFile();
    }

    private OutputStream getJsFileOutputStream() {
        return null;
    }
}

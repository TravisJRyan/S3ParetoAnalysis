package graphgenerator;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

public class StaticFileGenerator {

    public void generateStaticFiles(Path outputDirectory) {
        InputStream htmlFileInputStream = getHtmlFileInputStream();
        InputStream jsFileInputStream = getJsFileInputStream();
        OutputStream htmlFileOutputStream = getHtmlFileOutputStream();
        OutputStream jsFileOutputStream = getJsFileOutputStream();
    }

    private InputStream getHtmlFileInputStream() {
        return null;
    }

    private InputStream getJsFileInputStream() {
        return null;
    }

    private OutputStream getHtmlFileOutputStream() {
        return null;
    }

    private OutputStream getJsFileOutputStream() {
        return null;
    }
}

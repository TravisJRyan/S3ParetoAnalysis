package graphgenerator;

import DataConstuctor.Daily;
import DataConstuctor.DataConstructorInterface;

import java.nio.file.Path;

public class GraphGenerator {

    private Path outputDirectory;
    private DataConstructorInterface dataConstructor;
    private StaticFileGenerator staticFileGenerator;
    private JsonFileGenerator jsonFileGenerator;

    public GraphGenerator(Path outputDirectory,
                          DataConstructorInterface dataConstructor,
                          StaticFileGenerator staticFileGenerator,
                          JsonFileGenerator jsonFileGenerator) {
        this.outputDirectory = outputDirectory;
        this.dataConstructor = dataConstructor;
        this.staticFileGenerator = staticFileGenerator;
        this.jsonFileGenerator = jsonFileGenerator;
    }

    public void generateParetoChart() {
        System.out.println("Generating pareto chart...");
        System.out.println("Generating dailies...");
        Daily[] dailies = dataConstructor.generateDailies();
        System.out.println("Dailies generated!");
        int numHostnames = dataConstructor.totalHostnames();
        System.out.format("Encountered %d unique hostnames.\n", numHostnames);
        System.out.format("Generating static files in %s.\n", outputDirectory.toAbsolutePath());
        staticFileGenerator.generateStaticFiles(outputDirectory);
        System.out.println("Static files generated.");
        System.out.format("Generating json file in %s.\n", outputDirectory.toAbsolutePath());
        jsonFileGenerator.generateJson(outputDirectory);
        System.out.println("Json file generated.");
        System.out.format("Pareto chart available in %s.\n", outputDirectory.toAbsolutePath());

    }
}

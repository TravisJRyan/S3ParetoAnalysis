package graphgenerator;

import DataConstuctor.Daily;
import org.json4s.JsonAST;
import scala.Tuple2;
import scala.collection.immutable.List;

import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

public class JsonFileGenerator {

    private String jsonFileName;

    public JsonFileGenerator(String jsonFileName) {
        this.jsonFileName = jsonFileName;
    }

    public void generateJson(Daily[] dailies, Path outputDirectory) {
        OutputStream jsonFileOutputStream = getJsonFileOutputStream(outputDirectory);
        JsonAST.JValue dailiesJson = buildDailiesJson(dailies);
    }

    private OutputStream getJsonFileOutputStream(Path outputDirectory) {
        return null;
    }

    private JsonAST.JValue buildDailiesJson(Daily[] dailies) {
        JsonAST.JSet dailyValues = Arrays.stream(dailies).map(daily -> {

                }).collect();
        return new JsonAST.JObject(
                (List<Tuple2<String,JsonAST.JValue>>) Collections.singletonList(
                        new Tuple2<String, JsonAST.JValue>("dailies", dailyValues)));
    }


}

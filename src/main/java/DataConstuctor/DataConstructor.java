package DataConstuctor;

import java.util.HashSet;
import java.util.Set;

public class DataConstructor implements DataConstructorInterface {

    Daily[] allDailies;
    S3Helper s3Helper;

    public DataConstructor(){
        s3Helper = new S3Helper();
        allDailies = new Daily[7];
    }

    public Daily[] generateDailies(){
        for(int i = 0; i < allDailies.length; i++)
            allDailies[i] = generateDaily();
        return allDailies;
    }

    private Daily generateDaily(){
        Daily newDaily = new Daily();
        newDaily.totalUniqueHostnames = 0;
        newDaily.todayUniqueHostnames = 0;
        Set<String> repeats = new HashSet<>();
        repeats.add(s3Helper.getHostname());
        newDaily.repeats = repeats;
        return newDaily;
    }

    public int totalHostnames(){
        return 1;
    }

}

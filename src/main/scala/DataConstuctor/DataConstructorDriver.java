package DataConstuctor;

public class DataConstructorDriver {
    public static void main(String[] args){
        DataConstructor dataConstructor = new DataConstructor();
        Daily[] dailies = dataConstructor.generateDailies();
        System.out.println(dailies[6].repeats.toString());
    }
}

import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.io.File;

public class test {
    @Test
    public void test1(){
        File f=new File("//usr//local//tomcat9//webapps//ExperimentReport-1.0-SNAPSHOT//downloads//MillikanOilDrop");
        System.out.println(f.getPath());
    }
}

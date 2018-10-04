package control;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Application {

    public static void main(String[] args) {


        Properties properties = new Properties();
        properties.setProperty("displayName", "Wes Brown");
        properties.setProperty("accountNumber", "Test");

        try(OutputStream outputStream = Files.newOutputStream(Paths.get("props.xml"))){

            properties.storeToXML(outputStream, "MyComment");
        } catch (IOException e){

        }

        String name = System.getProperty("user.name");
        System.out.println(name);


        System.out.println(System.getenv("COMPUTERNAME"));

    }
}

package streams;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        String[] data = {
                "Line 1",
                "Line 2 2",
                "Line 3 3 3",
                "Line 4 4 4 4",
                "Line 5 5 5 5 5"
        };

        try(FileSystem zipFileSystem = openZip(Paths.get("myData.zip"))){

            copyToZip(zipFileSystem);
            writeToFileInZip1(zipFileSystem, data);
            writeToFileInZip2(zipFileSystem, data);

        } catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }

    }

    private static FileSystem openZip(Path zipPath) throws IOException, URISyntaxException{
        Map<String, String> providerProperties = new HashMap<>();
        providerProperties.put("create", "true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null);
        FileSystem zipFileSystem = FileSystems.newFileSystem(zipUri, providerProperties);

        return zipFileSystem;
    }

    private static void copyToZip(FileSystem zipFileSystem) throws  IOException{

        //Path sourceFile = FileSystems.getDefault().getPath("file1.txt");
        Path sourceFile = Paths.get("file1.txt");
        Path destFile = zipFileSystem.getPath("/file1Copied.txt");

        Files.copy(sourceFile, destFile,StandardCopyOption.REPLACE_EXISTING );
    }

    private static void writeToFileInZip1(FileSystem zipFileSystem, String[] data) throws IOException{

        try(BufferedWriter writer = Files.newBufferedWriter(zipFileSystem.getPath("/newFile1.txt"))){

            for(String line: data){
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static void writeToFileInZip2(FileSystem zipFileSystem, String[] data) throws IOException{

        Files.write(zipFileSystem.getPath("/newFile2.txt"), Arrays.asList(data),
                Charset.defaultCharset(), StandardOpenOption.CREATE);

    }

    /*public static void doTryCatchFinally() {

        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try{
            reader = Helper.openReader("file1.txt");

            while((length = reader.read(buff)) >= 0){

                System.out.println("\nLength: " + length);

                for(int i=0; i < length; i++){
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {

            try{
                if(reader!=null){
                    reader.close();
                }

            } catch (IOException e2){

                System.out.println(e2.getClass().getSimpleName() + " - " + e2.getMessage());
            }
        }
    }*/

    /*public static void doTryWithResource() {

        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try (Reader reader = Helper.openReader("file1.txt")){

            while((length = reader.read(buff))>= 0){

                System.out.println("\nLength: " + length);

                for(int i =0; i <length; i++){
                    System.out.println(buff[i]);
                }
            }
        } catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }*/

    /*public static void doTryWithResourceMulti() {

        char[] buff = new char[8];
        int length;
        Reader reader = null;

        try (Reader reader = Helper.openReader("file1.txt");
             Writer writer = Helper.openWriter("file2.txt") ){

            while((length = reader.read(buff))>= 0){

                System.out.println("\nLength: " + length);
                writer.write(buff, 0, length);
            }
        } catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }*/

    /*private static void doCloseThing(){
        try(MyAutoCloseable autoCloseable = new MyAutoCloseable()){
            autoCloseable.saySomething();
        } catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }*/
}

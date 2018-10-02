package streams;

import java.io.IOException;

public class MyAutoCloseable implements AutoCloseable{

    public void saySomething() throws IOException{
        System.out.println("Something");
    }

    public void close() throws IOException {
        System.out.println("close");
    }
}

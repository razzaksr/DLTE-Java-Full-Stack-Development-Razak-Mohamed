package exceptions.dlte.javapart.handlings;

import java.io.IOException;

public class ImplementationCheckedException {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime=Runtime.getRuntime();
        Process process;
        process=runtime.exec("notepad");
        Thread.sleep(5000);
        process=runtime.exec("mspaint");
    }
}

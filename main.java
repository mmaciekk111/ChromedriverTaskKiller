import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChromedriverTaskKiller {
    public static void main(String[] args) {

        processCounter("chromedriver.exe");
        processKiller("chromedriver.exe");
    }

    public static void processKiller(String processToKill) {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM "+processToKill);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processCounter(String processToCount) {
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c tasklist | findstr "+processToCount);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            System.out.println("Number of chromedriver.exe processes running: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

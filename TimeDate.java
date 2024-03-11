package java_demo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeDate {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> loopFunction(), 0, 3, TimeUnit.SECONDS); // Run the loop function with a initial delay of 0 seconds and then every 3 seconds
        try {
            Thread.sleep(30000); // Wait for 30 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown(); // Shutdown the executor after 30 seconds
    }

    public static void loopFunction() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String formattedDate = "Current date and time: " + sdf.format(date) + "\n"; // Display current date and time in IST

        File file = new File("output.txt");
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new IOException("Failed to create new file.");
                }
            }

            FileWriter writer = new FileWriter(file, true);
            writer.append(formattedDate);
            writer.close();
            System.out.println("Output written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

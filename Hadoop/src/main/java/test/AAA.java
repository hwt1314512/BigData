package test;

import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;

/**
 * Created by Administrator on 2017/3/28.
 */
public class AAA {
    public static void main(String[] args) throws IOException {

        String line = "0067011990999991950051507004+68750+023550FM-12+038299999V0203301N00671220001CN9999999N9+00001+99999999999";
        String year = line.substring(15, 19);
        System.out.println(year);

        int airTemperature;
        if (line.charAt(87) == '+') { // parseInt doesn't like leading plus signs
            airTemperature = Integer.parseInt(line.substring(88, 92));
        } else {
            airTemperature = Integer.parseInt(line.substring(87, 92));
        }

        System.out.println(airTemperature);

        String quality = line.substring(92, 93);
        System.out.println(quality);
        System.out.println(quality.matches("[01459]"));
    }
}

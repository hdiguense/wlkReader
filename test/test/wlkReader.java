package test;
import data.DailySummary;
import data.DailyWeatherData;
import org.joda.time.*;
import reader.WlkReader;

import java.io.File;
import java.util.List;

public class wlkReader {
    public static void main(String[] args) throws java.io.IOException {
        WlkReader wlkReader = new WlkReader(new File("D:\\Users\\Daniel\\Google Drive\\devProjects\\IdeaProjects\\wlk-reader\\test\\test"), new DateTime(2012, 2, 5, 14, 0), new DateTime(2012, 7, 23, 16, 30), true);
        List<DailyWeatherData> dailyWeatherDataList = wlkReader.readData();
        System.out.println("Data Below: \n\n");
        for (DailyWeatherData data : dailyWeatherDataList) {
            DailySummary summ = data.getDailySummary();
            summ.toString();
        }
    }
}

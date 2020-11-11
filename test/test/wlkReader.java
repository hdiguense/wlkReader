package test;
import data.DailySummary;
import data.DailyWeatherData;
import data.WeatherDataRecord;
import org.joda.time.*;
import reader.WlkReader;

import java.io.File;
import java.util.List;

public class wlkReader {
    public static void main(String[] args) throws java.io.IOException {
        WlkReader wlkReader = new WlkReader(new File("C:\\WeatherLink\\Estaciones ICAFE\\cbaurora" /*set the path here. In this is just for one station*/), /*start date*/ new DateTime(2020/*year*/, 11/*month*/, 1/*day*/, 0/*hour*/, 0/*min*/), /*end date */ new DateTime(2020 /*year*/, 11/*month*/, 7/*day*/, 23/*hour*/, 0/*minutes*/), true);
        List<DailyWeatherData/*this is daily data*/> dailyWeatherDataList = wlkReader.readData();
        System.out.println("Data Below: \n\n");
        for (DailyWeatherData data : dailyWeatherDataList) {
            DailySummary summ /*this summarize all data */ = data.getDailySummary();
            double clima_Var = summ.getDailyRain();
            //System.out.println(clima_Var); //here you print daily data
            List<WeatherDataRecord/*this is the list of records every 15min*/> data_15min = data.getWeatherDataRecords()/*this is the method to get all 15min records*/;
            for (WeatherDataRecord record: data_15min){//this is a loop for printing all the records

                System.out.println(record.getTime() + ": temp: " + record.getOutTemp() /*temp values*/ + ": lluvia: " + record.getPrecipitation() /*rain values*/);//use the method . getVARIABLE to call the variable you want
            }
        }

    }
}

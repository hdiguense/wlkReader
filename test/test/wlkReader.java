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
        WlkReader wlkReader = new WlkReader(new File("C:\\WeatherLink\\Estaciones ICAFE\\cbaurora" /*set the path here. In this is just for one station*/), /*start date*/ new DateTime(2020/*year*/, 11/*month*/, 1/*day*/, 0/*hour*/, 0/*min*/), /*end date */ new DateTime(2020 /*year*/, 11/*month*/, 1/*day*/, 0/*hour*/, 16/*minutes*/), true);
        List<DailyWeatherData/*this is daily data*/> dailyWeatherDataList = wlkReader.readData();
        System.out.println("Data Below: \n\n");
        for (DailyWeatherData data : dailyWeatherDataList) {
            DailySummary summ /*this summarize all data */ = data.getDailySummary();
            double avg_dew_point = summ.getAvgDewPoint();
            double max_dew_point = summ.getMaxDewPoint();
            double min_dew_point = summ.getMinDewPoint();
            LocalTime min_time_dew_point = summ.getTimeMinDewPoint();
            LocalTime max_time_dew_point = summ.getTimeMaxDewPoint();
            double wind_run = summ.getWindRun();
            double avg_wind_chill = summ.getAvgWindChill();
            double max_wind_chill = summ.getMaxWindChill();
            double min_wind_chill = summ.getMinWindChill();
            double avg_heat_index = summ.getAvgHeatIndex();
            double max_heat_index = summ.getMaxHeatIndex();
            double min_heat_index = summ.getMinHeatIndex();
            double max_thw_index = summ.getMaxTHWIndex();
            double min_thw_index = summ.getMinTHWIndex();
            LocalTime min_time_thw = summ.getTimeMinTHWIndex();
            LocalTime max_time_thw = summ.getTimeMaxTHWIndex();
            double max_thsw_index = summ.getMaxTHSWIndex();
            double min_thsw_index = summ.getMinTHSWIndex();
            LocalTime max_time_thsw = summ.getTimeMaxTHSWIndex();
            LocalTime min_time_thsw = summ.getTimeMinTHSWIndex();
            double uv_dose = summ.getDailyUVDose();
            double uv_max = summ.getMaxUV();
            double heat_dd = summ.getIntegratedHeatDD65();
            double cool_dd = summ.getIntegratedCoolDD65();


            System.out.println("Avg Dew point:  " + avg_dew_point + ", Max dew point: " + max_dew_point + ", Min Dew Point: " + min_dew_point + ", MinTimeDewPoint: " + min_time_dew_point + ",, MaxTimeDewPoint: " + max_time_dew_point + ", wind run: " + wind_run + ", avgWindChill: "+ avg_wind_chill + ", maxWindChill: " + max_wind_chill + ", minWindChill: " + min_wind_chill + ", AvgHeatIndex" + avg_heat_index + ", MaxHeatIndex: " + max_heat_index + ", MinHeatIndex: " + min_heat_index + ", maxTHWIndex: " + max_thw_index + ", minTHWIndex: " + min_thw_index + ", minTimeTHW: " + min_time_thw + ", maxTimeTHW: " + max_time_thw + ", maxTHSWIndex: " + max_thsw_index + ", minTHSWIndex: " + min_thsw_index + ", MaxTimeTHSW: " + max_time_thsw + ", MinTimeTHSW: " + min_time_thsw + ", UV_dose: " + uv_dose + ", UV_Max: " + uv_max + ", HDD: " + heat_dd + ", Cool DD: " + cool_dd); //here you print daily data
            List<WeatherDataRecord/*this is the list of records every 15min*/> data_15min = data.getWeatherDataRecords()/*this is the method to get all 15min records*/;
            for (WeatherDataRecord record: data_15min){//this is a loop for printing all the records

                System.out.println("time: " + record.getTime() + ", tempOut: " + record.getOutTemp() /*temp values*/ + ", HiTemp: " + record.getMaxOutTemp() + ", LoTemp: " + record.getMinOutTemp() + ", OutHum: " + record.getOutHumidity() + ", windSpeed: " + record.getWindSpeed() + ", windDir: " + record.getWindDirection() + ", hi speed: "+ record.getMaxWindSpeed() + ", hi dir: " + record.getMaxWindDirection() + ", Bar: " + record.getPressure() +  " Rain: "  + record.getPrecipitation() + ", rain rate: " + record.getMaxPrecipitationRate() + ", Solar Rad: " + record.getSolarRad() + ", Solar hi Energy: " + record.getMaxSolarRad() + ", UV index: " + record.getUV() + ", In Temp: " + record.getInTemp() + ", In Hum: " + record.getInHumidity() + ", In DEW: no var" + ", In heat: no var" + ", In EMC: no var" + ", IN Air Density: no var" + ", temp extra: " + record.getExtraTemp()[0] + ", ET: " + record.getET() + ", Soil 1 moist: " + record.getSoilMoisture()[0] + ", Soil 2 moist: " + record.getSoilMoisture()[1] + ", Soil 3 moist: " + record.getSoilMoisture()[2] + ", Soil 4 moist: " + record.getSoilMoisture()[3] + ", Soil 1 Temp: " + record.getSoilTemp()[0] + ", Soil 2 Temp: " + record.getSoilTemp()[1] + ", Soil 3 Temp: " + record.getSoilTemp()[2] + ", Soil 4 Temp: " + record.getSoilTemp()[3] + ", Leaf Wet 1: " + record.getLeafWetness()[0] + ", Leaf Wet 2: " + record.getLeafWetness()[1] + ", Leaf temp 1: "+ record.getLeafTemp()[0] + ", Leaf temp 2: " + record.getLeafTemp()[1] + ", wind Samp: " + record.getNumwindSamples() + ", wind TX: No var"+  ", ISS reception: No var" + ", Arc INT: " +  record.getArchiveInterval());//use the method . getVARIABLE to call the variable you want
            }
        }

    }
}

import java.util.*;

class UndergroundSystem {

    // Stores check-in information:
    // id -> [stationName, checkInTime]
    private Map<Integer, CheckIn> checkIns;

    // Stores route information:
    // "start#end" -> [totalTime, totalTrips]
    private Map<String, long[]> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn in = checkIns.get(id);

        String route = in.station + "#" + stationName;

        long travelTime = t - in.time;

        if (!routes.containsKey(route)) {
            routes.put(route, new long[]{0, 0});
        }

        long[] data = routes.get(route);

        data[0] += travelTime; // total time
        data[1]++;             // number of trips

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "#" + endStation;

        long[] data = routes.get(route);

        return (double) data[0] / data[1];
    }

    // Helper class for check-in data
    private static class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}
INPUT;
["UndergroundSystem","checkIn","checkIn","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[45,"Waterloo",15],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]

OUTPUT;
[null,null,null,null,null,14.00000,12.00000,null,12.00000,null,13.00000]

package dcc.mpg.model;

import java.util.HashMap;
import java.util.Map;

public class FuelMetric {
    private int milesOnMeter;

    private double gallonsFilled;

    private FuelMetric() {
    }

    public FuelMetric(final int milesOnMeter, final double gallonsFilled) {
        this.milesOnMeter = milesOnMeter;
        this.gallonsFilled = gallonsFilled;
    }

    public int getMilesOnMeter() {
        return milesOnMeter;
    }

    public double getGallonsFilled() {
        return gallonsFilled;
    }

    public static Map<String, Object> asMap(final FuelMetric metric) {
        Map map = new HashMap();
        map.put("milesOnMeter", metric.getMilesOnMeter());
        map.put("gallonsFilled", metric.getGallonsFilled());
        return map;
    }

    public static FuelMetric fromMap(final Map map) {
        return new FuelMetric((int)map.get("milesOnMeter"), (double)map.get("gallonsFilled"));
    }
}

package ceiti.model;

import java.util.Arrays;
import ceiti.parser.http.HTMLParser;

public class MySubject {
    private final String name;
    private final String unformattedGrades;
    private final int[] grades;
    private Double average;

    public MySubject(String name, String grades) {
        this.name = name;
        this.unformattedGrades  = grades;
        this.grades = HTMLParser.parseGrades(unformattedGrades);
        this.average = Arrays.stream(this.grades).average().orElse(Double.NaN);
    }

    public String getName() {
        return name;
    }

    public String getUnformattedGrades() {
        return unformattedGrades;
    }

    public Double getAverage(){
        return average;
    }

    public String getStringAverage(){
        return Double.isNaN(average) ? "" : average.toString();
    }
}

package ceiti.parser.http;

import ceiti.model.MySubject;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import ceiti.model.Subject;
import org.jetbrains.annotations.NotNull;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HTMLParser {
    public static List<Subject> parseSubjects(@NotNull Document htmlDocument, int semester){
        List<Subject> subjects = new ArrayList<>();

        Elements elements =  htmlDocument.getElementsByAttributeValue("aria-labelledby", "headin3g2");

        for (Element element : elements){
            Elements table = element.getElementsByTag("tr");
            for (Element row : table){
                Elements columns = row.getElementsByTag("td");
                if (columns.size() < 2) continue;

                String subjectName = columns.get(0).text();
                String grades = columns.get(1).text();
                List<Integer> gradesList = Arrays.stream(parseGrades(grades))
                        .boxed()
                        .toList();


                Subject subject = new Subject(subjectName, gradesList);

                subjects.add(subject);
            }
        }


        return subjects;
    }
    public static int[] parseGrades(String expression){
        String[] grades = expression.split(", ");

        return Arrays.stream(grades)
                .filter(str -> Pattern.matches("\\b([1-9]|10)\\b",str))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

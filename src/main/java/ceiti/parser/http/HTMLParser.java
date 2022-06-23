package ceiti.parser.http;

import ceiti.model.Subject;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class HTMLParser {

    private static int getYearOfStudy(@NotNull Document htmlDocument) {
        String yearOfStudy = null;
        try{
            Element personalInfoTable = htmlDocument.getElementsByAttributeValue("id","date-personale").first();
            for (Element row : personalInfoTable.getElementsByTag("tr")) {
                if(row.getElementsByTag("th").first().text().equals("Anul de studii")){
                   yearOfStudy = row.getElementsByTag("td").first().text();
                    break;
                }
            }
        } catch(Exception e){
            //todo handle exception?
        }
        if (yearOfStudy != null){
            return switch (yearOfStudy) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                default -> throw new IllegalArgumentException("Unknown year of study!");
            };
        }

        throw new IllegalArgumentException("Unknown year of study!");
    }

    private static List<String> getExams(@NotNull Document htmlDocument, int yearOfStudy){
        String firstSemester = "collapse" + ((yearOfStudy * 2)-2);
        String secondSemester = "collapse" + ((yearOfStudy * 2)-1);
        List<String> exams = new ArrayList<>();

        getExamsBySemester(htmlDocument, firstSemester, exams);

        getExamsBySemester(htmlDocument, secondSemester, exams);

        return exams;
    }

    private static void getExamsBySemester(@NotNull Document htmlDocument, String semester, List<String> exams) {
        Element secondSemesterExamsTable = htmlDocument.getElementById(semester);
        for (Element row : secondSemesterExamsTable.getElementsByTag("tr")) {
            Elements exam = row.getElementsByTag("td");
            if (exam.size() == 2){
                String examName = exam.first().text();
                String examNote = exam.last().text();
                exams.add(examName + ": " + examNote);
            }
        }
    }

    public static List<Subject> parseSubjects(@NotNull Document htmlDocument, int semester){
        List<Subject> subjects = new ArrayList<>();

        int yearOfStudy = getYearOfStudy(htmlDocument);
        List<String> exams = getExams(htmlDocument, yearOfStudy);
        for (String exam : exams) {
            System.out.println(exam);
        }

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

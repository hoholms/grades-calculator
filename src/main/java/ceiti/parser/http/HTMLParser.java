package ceiti.parser.http;

import ceiti.model.Subject;
import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.regex.Pattern;


public class HTMLParser {

    private static int getYearOfStudy(@NotNull Document htmlDocument) {
        String yearOfStudy = null;
        try {
            Element personalInfoTable = htmlDocument.getElementsByAttributeValue("id", "date-personale").first();
            for (Element row : personalInfoTable.getElementsByTag("tr")) {
                if (row.getElementsByTag("th").first().text().equals("Anul de studii")) {
                    yearOfStudy = row.getElementsByTag("td").first().text();
                    break;
                }
            }
        } catch (Exception e) {
            //todo handle exception?
            System.out.println(e.getMessage());
        }
        if (yearOfStudy != null) {
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

    private static Map<String, Float> getExams(@NotNull Document htmlDocument, int yearOfStudy, String semester) {
        String firstSemester = "collapse" + ((yearOfStudy * 2) - 2);
        String secondSemester = "collapse" + ((yearOfStudy * 2) - 1);
        Map<String, Float> exams = new HashMap<>();

        if (semester.equals("headin3g1"))
            getExamsBySemester(htmlDocument, firstSemester, exams);
        else
            getExamsBySemester(htmlDocument, secondSemester, exams);

        return exams;
    }

    private static void getExamsBySemester(@NotNull Document htmlDocument, String semester, Map<String, Float> exams) {
        Element secondSemesterExamsTable = htmlDocument.getElementById(semester);
        for (Element row : secondSemesterExamsTable.getElementsByTag("tr")) {
            Elements exam = row.getElementsByTag("td");
            if (exam.size() == 2) {
                String examName = exam.first().text();
                if (examName.contains("(Teza) "))
                    examName = examName.substring(7);
                else if (examName.contains("(Examen) "))
                    examName = examName.substring(9);

                String examNote = exam.last().text();
                if (!examNote.equals("---"))
                    exams.put(examName, Float.parseFloat(examNote));
            }
        }
    }

    public static List<Subject> parseSubjects(@NotNull Document htmlDocument, String semester) {
        List<Subject> subjects = new ArrayList<>();

        int yearOfStudy = getYearOfStudy(htmlDocument);
        Map<String, Float> exams = getExams(htmlDocument, yearOfStudy, semester);

        Elements elements = htmlDocument.getElementsByAttributeValue("aria-labelledby", semester);
        for (Element element : elements) {
            Elements table = element.getElementsByTag("tr");
            for (Element row : table) {
                Elements columns = row.getElementsByTag("td");
                if (columns.size() < 2) continue;

                String subjectName = columns.get(0).text();
                String grades = columns.get(1).text();
                List<Integer> gradesList = Arrays.stream(parseGrades(grades))
                        .boxed()
                        .toList();

                float examGrade = 0.0f;
                for (Map.Entry<String, Float> exam : exams.entrySet())
                    if (exam.getKey().equals(subjectName)) examGrade = exam.getValue();

                if (examGrade == 0.0f)
                    subjects.add(new Subject(subjectName, gradesList));
                else
                    subjects.add(new Subject(subjectName, gradesList, (int) examGrade));
            }
        }


        return subjects;
    }

    public static int[] parseGrades(String expression) {
        String[] grades = expression.split(", ");

        return Arrays.stream(grades)
                .filter(str -> Pattern.matches("\\b([1-9]|10)\\b", str))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

package ceiti.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/**
 * The type Subject.
 */
public class Subject implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String nameSub;
    private List<Integer> grades;
    private boolean exam;
    private Integer exGrade;

    /**
     * Instantiates a new Subject.
     *
     * @param nameSub the name sub
     * @param grades  the grades
     */
    public Subject(String nameSub, List<Integer> grades) {
        this.nameSub = nameSub;
        this.grades = grades;
        this.exam = false;
    }

    /**
     * Instantiates a new Subject.
     *
     * @param nameSub the name sub
     */
    public Subject(String nameSub) {
        this.nameSub = nameSub;
        this.grades = new Vector<>();
        this.exam = false;
    }

    /**
     * Instantiates a new Subject.
     */
    public Subject() {
        this.nameSub = null;
        this.grades = null;
        this.exam = false;
    }

    /**
     * Avg grade float.
     *
     * @return the float
     */
    public float avgGrade() {
        float ag = 0f;
        for (Integer grade : grades) {
            if (grade != null) ag += grade;
        }
        return ag / grades.size();
    }

    /**
     * Avg ex grade float.
     *
     * @return the float
     */
    public float avgExGrade() {
        float ag = 0f;
        for (Integer grade : grades) {
            if (grade != null) ag += grade;
        }
        return ((ag / grades.size()) + exGrade) / 2;
    }

    /**
     * Gets name sub.
     *
     * @return the name sub
     */
    public String getNameSub() {
        return nameSub;
    }

    /**
     * Sets name sub.
     *
     * @param nameSub the name sub
     */
    public void setNameSub(String nameSub) {
        this.nameSub = nameSub;
    }

    /**
     * Gets grades.
     *
     * @return the grades
     */
    public List<Integer> getGrades() {
        return grades;
    }

    /**
     * Sets grades.
     *
     * @param grades the grades
     */
    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    /**
     * Sets grade.
     *
     * @param ind the ind
     * @param val the val
     */
    public void setGrade(int ind, Integer val) {
        grades.set(ind, val);
    }

    /**
     * Is exam boolean.
     *
     * @return the boolean
     */
    public boolean isExam() {
        return exam;
    }

    /**
     * Sets exam.
     *
     * @param exam the exam
     */
    public void setExam(boolean exam) {
        this.exam = exam;
    }

    /**
     * Gets ex grade.
     *
     * @return the ex grade
     */
    public Integer getExGrade() {
        return exGrade;
    }

    /**
     * Sets ex grade.
     *
     * @param exGrade the ex grade
     */
    public void setExGrade(Integer exGrade) {
        setExam(true);
        this.exGrade = exGrade;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "nameSub='" + nameSub + '\'' +
                ", grades=" + grades +
                ", exam=" + exam +
                ", exGrade=" + exGrade +
                '}';
    }
}

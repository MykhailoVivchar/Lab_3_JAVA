import java.util.ArrayList;
import java.util.List;

// Клас Abiturient з полями та методами
public class Abiturient {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phone;
    private int[] grades;

    // Конструктор класу
    public Abiturient(int id, String lastName, String firstName, String patronymic, String address, String phone, int[] grades) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.grades = grades;
    }

    // Методи set та get
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    // Метод для розрахунку середнього балу
    public double calculateAverageGrade() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    // Перевизначений метод toString для зручного виводу інформації про абітурієнта
    @Override
    public String toString() {
        return String.format("%-5d%-15s%-15s%-15s%-20s%-15s%-15s", id, lastName, firstName, patronymic, address, phone, arrayToString(grades));
    }

    // Допоміжний метод для конвертації масиву оцінок в рядок
    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // Додатковий метод в класі для вибору абітурієнтів з незадовільними оцінками
    public static List<Abiturient> getUnsatisfactoryAbiturients(List<Abiturient> abiturients) {
        List<Abiturient> unsatisfactoryList = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            for (int grade : abiturient.getGrades()) {
                if (grade == 2) {
                    unsatisfactoryList.add(abiturient);
                    break;
                }
            }
        }
        return unsatisfactoryList;
    }

    // Додатковий метод в класі для вибору абітурієнтів з середнім балом вище заданого
    public static List<Abiturient> getAbiturientsWithAverageGradeAbove(List<Abiturient> abiturients, double threshold) {
        List<Abiturient> aboveThresholdList = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.calculateAverageGrade() > threshold) {
                aboveThresholdList.add(abiturient);
            }
        }
        return aboveThresholdList;
    }

    // Додатковий метод в класі для вибору абітурієнтів з найвищим середнім балом
    public static List<Abiturient> getTopNStudentsWithHighestAverageGrade(List<Abiturient> abiturients, int n) {
        abiturients.sort((a1, a2) -> Double.compare(a2.calculateAverageGrade(), a1.calculateAverageGrade()));
        return abiturients.subList(0, Math.min(n, abiturients.size()));
    }
}

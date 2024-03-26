import java.util.ArrayList;
import java.util.List;

// Клас Main для виконання основної логіки програми
public class Main {
    public static void main(String[] args) {
        // Створення масиву об'єктів класу Abiturient
        List<Abiturient> abiturients = new ArrayList<>();
        abiturients.add(new Abiturient(1, "Шевчук", "Іван", "Іванович", "вул. Шевченка, 10", "97-675-86-76", new int[]{4, 5, 3, 4}));
        abiturients.add(new Abiturient(2, "Петров", "Олег", "Миколайович", "вул. Львівська, 5", "98-765-43-11", new int[]{5, 4, 5, 5}));
        abiturients.add(new Abiturient(3, "Шевченко", "Микола", "Григорович", "вул. Шевченка, 1", "97-678-90-01", new int[]{3, 3, 3, 2}));
        abiturients.add(new Abiturient(4, "Кулеба", "Андрій", "Миколайович", "вул. Теліги, 2", "96-654-32-10", new int[]{2, 3, 2, 3}));
        abiturients.add(new Abiturient(5, "Вишнівець", "Сергій", "Тарасович", "вул. Яремчука, 15", "97-321-09-87", new int[]{4, 4, 5, 4}));

        // a) Список абітурієнтів з незадовільними оцінками (незадовільна оцінка = 2)
        List<Abiturient> unsatisfactoryList = Abiturient.getUnsatisfactoryAbiturients(abiturients);
        System.out.println("Список абітурієнтів з незадовільними оцінками:");
        printAbiturients(unsatisfactoryList);

        // b) Список абітурієнтів з середнім балом вище заданого (середній бал = 3)
        double threshold = 3.0; // заданий бал
        List<Abiturient> aboveThresholdList = Abiturient.getAbiturientsWithAverageGradeAbove(abiturients, threshold);
        System.out.println("\nСписок абітурієнтів з середнім балом вище " + threshold + ":");
        printAbiturients(aboveThresholdList);

        // c) Вибір заданої кількості абітурієнтів з найвищим середнім балом (вища оцінка = 4)
        int n = 2; // кількість абітурієнтів з найвищим балом
        List<Abiturient> topStudents = Abiturient.getTopNStudentsWithHighestAverageGrade(abiturients, n);
        System.out.println("\n" + n + " абітурієнтів з найвищим середнім балом:");
        printAbiturients(topStudents);
    }

    // Допоміжний метод для виведення списку абітурієнтів на консоль
    private static void printAbiturients(List<Abiturient> abiturients) {
        System.out.println("ID\t\tПрізвище\t\tІм'я\t\tПо батькові\t\tАдреса\t\t\t\tТелефон\t\t\tОцінки");
        for (Abiturient abiturient : abiturients) {
            System.out.println(abiturient);
        }
    }
}


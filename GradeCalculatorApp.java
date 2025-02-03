import java.util.Scanner;

public class GradeCalculatorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask language preference
        System.out.println("Press 1 for English, 2 for Spanish:");
        int languageChoice = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character.

        boolean isEnglish = languageChoice == 1;

        // Messages based on language
        String welcomeMessage = isEnglish ? "Welcome to the Grade Calculator!" : "¡Bienvenido al Calculador de Calificaciones!";
        String namePrompt = isEnglish ? "Enter your name:" : "Ingrese su nombre:";
        String discussionPrompt = isEnglish ? "Enter total discussion/quiz score (max 100):" : "Ingrese el puntaje total de discusión/quiz (máximo 100):";
        String projectPrompt = isEnglish ? "Enter total project score (max 200):" : "Ingrese el puntaje total de proyectos (máximo 200):";
        String examPrompt = isEnglish ? "Enter total exam score (max 700):" : "Ingrese el puntaje total de exámenes (máximo 700):";
        String formatPrompt = isEnglish ? "Select output format: (1) JSON, (2) CSV:" : "Seleccione el formato de salida: (1) JSON, (2) CSV:";
        String errorMessage = isEnglish ? "Invalid score entered. Exiting program." : "Puntaje inválido ingresado. Saliendo del programa.";
        String resultMessage = isEnglish ? "Here are your results:" : "Aquí están tus resultados:";

        // Display welcome message
        System.out.println(welcomeMessage);

        // Gather input
        System.out.println(namePrompt);
        String name = scanner.nextLine();

        System.out.println(discussionPrompt);
        double discussionScore = scanner.nextDouble();
        if (discussionScore < 0 || discussionScore > 100) {
            System.out.println(errorMessage);
            return;
        }

        System.out.println(projectPrompt);
        double projectScore = scanner.nextDouble();
        if (projectScore < 0 || projectScore > 200) {
            System.out.println(errorMessage);
            return;
        }

        System.out.println(examPrompt);
        double examScore = scanner.nextDouble();
        if (examScore < 0 || examScore > 700) {
            System.out.println(errorMessage);
            return;
        }

        // Calculate totals and grades
        double totalScore = discussionScore + projectScore + examScore;
        String letterGrade;
        if (totalScore >= 930) {
            letterGrade = "A";
        } else if (totalScore >= 900) {
            letterGrade = "A-";
        } else if (totalScore >= 870) {
            letterGrade = "B+";
        } else if (totalScore >= 830) {
            letterGrade = "B";
        } else if (totalScore >= 800) {
            letterGrade = "B-";
        } else if (totalScore >= 770) {
            letterGrade = "C+";
        } else if (totalScore >= 730) {
            letterGrade = "C";
        } else if (totalScore >= 700) {
            letterGrade = "C-";
        } else if (totalScore >= 670) {
            letterGrade = "D+";
        } else if (totalScore >= 630) {
            letterGrade = "D";
        } else if (totalScore >= 600) {
            letterGrade = "D-";
        } else {
            letterGrade = "F";
        }

        // Select output format
        System.out.println(formatPrompt);
        int formatChoice = scanner.nextInt();

        // Display results
        System.out.println(resultMessage);
        if (formatChoice == 1) {
            // JSON format
            System.out.println("{");
            System.out.println("  \"name\": \"" + name + "\",");
            System.out.println("  \"discussionScore\": " + discussionScore + ",");
            System.out.println("  \"projectScore\": " + projectScore + ",");
            System.out.println("  \"examScore\": " + examScore + ",");
            System.out.println("  \"totalScore\": " + totalScore + ",");
            System.out.println("  \"letterGrade\": \"" + letterGrade + "\"");
            System.out.println("}");
        } else {
            // CSV format
            System.out.println("Name,Discussion Score,Project Score,Exam Score,Total Score,Letter Grade");
            System.out.println(name + "," + discussionScore + "," + projectScore + "," + examScore + "," + totalScore + "," + letterGrade);
        }
    }
}

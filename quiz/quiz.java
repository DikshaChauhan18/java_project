import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuizApp {

    static class Question {
        String question;
        String[] options;
        int correctAnswerIndex;

        public Question(String question, String[] options, int correctAnswerIndex) {
            this.question = question;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public boolean isCorrectAnswer(int answerIndex) {
            return answerIndex == correctAnswerIndex;
        }
    }

    public static void main(String[] args) {
        List<Question> allQuestions = new ArrayList<>();
        // General Knowledge Questions
        allQuestions.add(new Question("What is the capital of France?", new String[]{"1. Paris", "2. London", "3. Berlin", "4. Madrid"}, 0));
        allQuestions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 1));
        allQuestions.add(new Question("What is the largest ocean on Earth?", new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"}, 3));
        allQuestions.add(new Question("Who wrote 'To Kill a Mockingbird'?", new String[]{"1. Harper Lee", "2. J.K. Rowling", "3. Ernest Hemingway", "4. Mark Twain"}, 0));
        allQuestions.add(new Question("What is the chemical symbol for Gold?", new String[]{"1. Au", "2. Ag", "3. Pb", "4. Fe"}, 0));
        allQuestions.add(new Question("What is the largest planet in our Solar System?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 2));
        allQuestions.add(new Question("What year did World War I begin?", new String[]{"1. 1912", "2. 1914", "3. 1916", "4. 1918"}, 1));
        allQuestions.add(new Question("Which element is known as the 'building block of life'?", new String[]{"1. Carbon", "2. Hydrogen", "3. Oxygen", "4. Nitrogen"}, 0));
        allQuestions.add(new Question("What is the hardest natural substance on Earth?", new String[]{"1. Gold", "2. Iron", "3. Diamond", "4. Platinum"}, 2));
        allQuestions.add(new Question("Which planet is known as the 'Morning Star' or 'Evening Star'?", new String[]{"1. Venus", "2. Mars", "3. Mercury", "4. Jupiter"}, 0));
        allQuestions.add(new Question("Who is the author of '1984'?", new String[]{"1. George Orwell", "2. Aldous Huxley", "3. Ray Bradbury", "4. J.D. Salinger"}, 0));
        allQuestions.add(new Question("What is the smallest unit of matter?", new String[]{"1. Atom", "2. Molecule", "3. Electron", "4. Proton"}, 0));
        allQuestions.add(new Question("What is the capital of Japan?", new String[]{"1. Beijing", "2. Seoul", "3. Tokyo", "4. Bangkok"}, 2));
        allQuestions.add(new Question("In which year did the Titanic sink?", new String[]{"1. 1905", "2. 1912", "3. 1923", "4. 1931"}, 1));
        allQuestions.add(new Question("What is the longest river in the world?", new String[]{"1. Nile", "2. Amazon", "3. Yangtze", "4. Mississippi"}, 1));

        // Human Body Questions
        allQuestions.add(new Question("What is the largest organ in the human body?", new String[]{"1. Liver", "2. Skin", "3. Heart", "4. Lungs"}, 1));
        allQuestions.add(new Question("How many bones are there in the adult human body?", new String[]{"1. 206", "2. 208", "3. 210", "4. 212"}, 0));
        allQuestions.add(new Question("What is the main function of red blood cells?", new String[]{"1. Fight infections", "2. Carry oxygen", "3. Clot blood", "4. Produce hormones"}, 1));
        allQuestions.add(new Question("Which part of the brain is responsible for memory?", new String[]{"1. Cerebellum", "2. Hippocampus", "3. Medulla", "4. Thalamus"}, 1));
        allQuestions.add(new Question("What is the function of the diaphragm in the human body?", new String[]{"1. Digestion", "2. Respiration", "3. Circulation", "4. Sensation"}, 1));
        allQuestions.add(new Question("Which muscle is the strongest in the human body based on its size?", new String[]{"1. Biceps", "2. Quadriceps", "3. Gluteus maximus", "4. Masseter"}, 3));
        allQuestions.add(new Question("How many chambers are there in the human heart?", new String[]{"1. 2", "2. 3", "3. 4", "4. 5"}, 2));
        allQuestions.add(new Question("What is the name of the bone commonly known as the collarbone?", new String[]{"1. Clavicle", "2. Scapula", "3. Sternum", "4. Humerus"}, 0));
        allQuestions.add(new Question("What part of the eye controls the amount of light entering?", new String[]{"1. Retina", "2. Cornea", "3. Iris", "4. Lens"}, 2));
        allQuestions.add(new Question("Which organ is responsible for producing insulin?", new String[]{"1. Liver", "2. Pancreas", "3. Kidney", "4. Stomach"}, 1));

        List<Question> selectedQuestions = getRandomQuestions(allQuestions, 10);

        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < selectedQuestions.size(); i++) {
            Question q = selectedQuestions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.question);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (1-4): ");
            int answerIndex = scanner.nextInt() - 1;

            if (q.isCorrectAnswer(answerIndex)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was option " + (q.correctAnswerIndex + 1) + ".");
            }
            System.out.println();
        }

        System.out.println("Quiz Over! Your score is: " + score + "/" + selectedQuestions.size());
        scanner.close();
    }

    private static List<Question> getRandomQuestions(List<Question> allQuestions, int numQuestions) {
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, Math.min(numQuestions, allQuestions.size()));
    }
}

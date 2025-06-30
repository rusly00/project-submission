package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.*;
import java.util.*;

public class QuizController {
    @FXML private Label questionLabel;
    @FXML private Button optionA, optionB, optionC, optionD, nextBtn;

    private List<Question> questions = new ArrayList<>();
    private int index = 0, score = 0;
    private char selectedOption = ' ';

    @FXML
    public void initialize() {
        loadQuestionsFromDB();
        if (!questions.isEmpty()) showQuestion();
    }

    private void loadQuestionsFromDB() {
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM questions")) {
            while (rs.next()) {
                questions.add(new Question(
                        rs.getString("question"),
                        rs.getString("optionA"),
                        rs.getString("optionB"),
                        rs.getString("optionC"),
                        rs.getString("optionD"),
                        rs.getString("correctOption").charAt(0)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showQuestion() {
        Question q = questions.get(index);
        questionLabel.setText((index + 1) + ". " + q.question);
        optionA.setText("A. " + q.optionA);
        optionB.setText("B. " + q.optionB);
        optionC.setText("C. " + q.optionC);
        optionD.setText("D. " + q.optionD);
        selectedOption = ' ';
    }

    @FXML
    private void handleA() { selectedOption = 'A'; }
    @FXML
    private void handleB() { selectedOption = 'B'; }
    @FXML
    private void handleC() { selectedOption = 'C'; }
    @FXML
    private void handleD() { selectedOption = 'D'; }

    @FXML
    private void handleNext() {
        if (selectedOption == questions.get(index).correctOption) {
            score++;
        }
        index++;
        if (index < questions.size()) {
            showQuestion();
        } else {
            questionLabel.setText("Quiz Complete! Your Score: " + score + "/" + questions.size());
            optionA.setDisable(true);
            optionB.setDisable(true);
            optionC.setDisable(true);
            optionD.setDisable(true);
            nextBtn.setDisable(true);
        }
    }
}
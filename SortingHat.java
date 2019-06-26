
import java.awt.Dimension;

/*
 * SortingHat.java
 * by Veronica Aldous 
 * 5/13/19
 * 
 * This class contains the questions that the user will answer to be sorted.
 * It contains the main method for my program and shows the intro page to start
 * the quiz. It links all the pages of the quiz together from the start of the
 * quiz to the result. 
 * 
 */
public class SortingHat
{
    // Sets the size of the windows in this program 
    public static final Dimension DIMENSION = new Dimension(725, 800);

    // The main method includes ALL the questions used in the Sorting quiz.
    // the code for displaying the intro page, question pages and result page
    // are all in separate classes. 
    public static void main(String[] args)
    {
        // keeps track of the users points for the 4 houses
        ResultTracker tracker = new ResultTracker();
        
        // constructs the intro page to start the quiz
        IntroPage introPage = new IntroPage();

        // constructs question objects to ask questions to the users
        Question question1 = new Question("Which quality do you find the most "
                + "admirable?", "Bravery", "Kindness", "Intelligence", 
                "Ambition");
        
        // constructs the user interface part of the question 
        QuestionGUI questionGUI1 = new QuestionGUI(question1, tracker);
        
        // does the same thing for the following questions as for question 1
        Question question2 = new Question("Which of these things appeals to"
                + " you most? ", "Winning", "Food", "Books", "Money");

        QuestionGUI questionGUI2 = new QuestionGUI(question2, tracker);

        Question question3 = new Question("Which movies appeals to you "
                + "the most?", "The Avengers", "Frozen", "The Matrix", 
                "The Silence of the Lambs");
        
        QuestionGUI questionGUI3 = new QuestionGUI(question3, tracker);
        
        Question question4 = new Question("Choose an Avenger:", "Captain"
                + " America", "Thor", "Bruce Banner/The Hulk", 
                "Iron Man");
        
        QuestionGUI questionGUI4 = new QuestionGUI(question4, tracker);
        
        Question question5 = new Question("Which of these would make you the "
                + "happiest?", "Honor", "Love", "Wisdom", "Wealth");
        
        QuestionGUI questionGUI5 = new QuestionGUI(question5, tracker); 
        
        Question question6 = new Question("Choose a Greek God:", "Zeus", 
                "Apollo", "Athena", "Hades");
                
        QuestionGUI questionGUI6 = new QuestionGUI(question6, tracker);
        
        Question question7 = new Question("Who is the most important person "
                + "in your life?", "Your friends", "Your family", "Your role "
                + "model", "Yourself");
        
        QuestionGUI questionGUI7 = new QuestionGUI(question7, tracker);
        
        Question question8 = new Question("Pick an American President:", 
                "George Washington", "George W. Bush", "Thomas Jefferson",
                "Donald Trump");
        
        QuestionGUI questionGUI8 = new QuestionGUI(question8, tracker);
        
        Question question9 = new Question("If someone atacked you with the"
                + " intention of hurting you, what spell would you use?", 
                "Stunning spell", "Protective shield spell", 
                "Disarming spell", "Killing curse");
        
        QuestionGUI questionGUI9 = new QuestionGUI(question9, tracker);
        
        Question question10 = new Question("If your friend was attacked by a "
                + "monster that tried to steal your friend's money, what would "
                + "you do?", "Fight the monster FOR your friend", "Help your "
                + "friend fight the monster", "Try to outsmart the monster", 
                "Steal your friend's money");

       QuestionGUI questionGUI10 = new QuestionGUI(question10, tracker);
        
      
  
        // constructs an object for the result page
        SortingResult result = new SortingResult(tracker);
        
        // sets the GUI for the first question on the intro page 
        introPage.setFirstQuestion(questionGUI1);
        
        // after the user answers a question, they are able to move to the 
        // next question in the quiz
        questionGUI1.setNextQuestion(questionGUI2);
        questionGUI2.setNextQuestion(questionGUI3);
        questionGUI3.setNextQuestion(questionGUI4);
        questionGUI4.setNextQuestion(questionGUI5);
        questionGUI5.setNextQuestion(questionGUI6);
        questionGUI6.setNextQuestion(questionGUI7);
        questionGUI7.setNextQuestion(questionGUI8);
        questionGUI8.setNextQuestion(questionGUI9);
        questionGUI9.setNextQuestion(questionGUI10);
        
        // links the final question to the result
        questionGUI10.setSortingResult(result);

        
        // displays the intro page to the user
        introPage.showIntroPage();
    }

}

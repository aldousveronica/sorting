
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * IntroPage.java
 * by Veronica Aldous 
 * 5/13/19
 * 
 * This class creates the welcome page that the users see before beginning
 * the quiz. This class contains a listener that responds to a button clicked.
 * This allows for the user to click a button and be transported to a new page
 * to begin taking the quiz. 
 * 
 */
public class IntroPage extends JFrame implements ActionListener 
{
    // The GUI page for the first question
    protected QuestionGUI firstQuestion;
    
    // sets first question to null as the default value 
    public IntroPage()
    {
       this.firstQuestion = null;
       
    }
    
    // sets the first question
    public void setFirstQuestion(QuestionGUI firstQuestion)
    {
        this.firstQuestion = firstQuestion;
    }
    
    // sets up the GUI for the intro page
    public void showIntroPage()
    {
        // Creates a title on the window    
        this.setTitle("Sorting Hat Quiz");
        
        // Sets the size of the window and does not allow the user to resize
        this.setSize(SortingHat.DIMENSION);
        this.setResizable(false);
        
        // Organizes the layout
        JPanel panel = new JPanel();
        this.add(panel);
        
        // creates text and sets font and color 
        JLabel introText = new JLabel ("WELCOME TO THE SORTING HAT QUIZ!");
        introText.setForeground(Color.red);
        Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 28);
        introText.setFont(font);
        
        // adds text to the panel
        panel.add(introText);
        
        // creates a button for the user to click and adds the button to panel 
        JButton startButton = new JButton("Click here to start the quiz");
        panel.add(startButton);
        
        // setup listener when the user clicks on the button
        // this refers to an ActionListener object 
        startButton.addActionListener(this);
        

        // constructs an object for an image file and adds it in a label 
        // to panel because you cannot add an ImageIcon to a panel
        ImageIcon mainPic = new ImageIcon("hogwarts.jpg");
        JLabel mainPicHolder = new JLabel(mainPic);
        panel.add(mainPicHolder);

        // sets the page visible for the user 
        this.setVisible(true);
        
        // closes the program when the user clicks the x on the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    // when the button is clicked, this method is called behind the scenes 
    public void actionPerformed(ActionEvent e)
    {
        // this disposes the window
        this.dispose();
        
        // shows the first question
        firstQuestion.showQuestion();
        
        
    

    }
}


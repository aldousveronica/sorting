
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * QuestionGUI.java
 * by Veronica Aldous 
 * 5/13/19
 * 
 * This will display a window for a single question.
 * 
 */
public class QuestionGUI extends JFrame implements ActionListener
{
    // contains the text of the question and values for all the answers
    protected Question question;
    
    // links to the next question 
    protected QuestionGUI nextQuestion;
    
    // links to the result page
    protected SortingResult result;
    
    // each of these buttons represent an answer choice 
    protected JButton gButton;
    protected JButton hButton;
    protected JButton rButton;
    protected JButton sButton;
    
    // tracks the results based on the user's answer choices 
    protected ResultTracker tracker;
    
    
    // sets the default values for nextQuestion and result and sets tracker
    // and question to the given values 
    public QuestionGUI(Question question, ResultTracker tracker)
    {
       this.nextQuestion = null;
       this.result = null;
       this.tracker = tracker;
       this.question = question;
    }
    
    // sets the page for the next question
    public void setNextQuestion(QuestionGUI nextQuestion)
    {
        this.nextQuestion = nextQuestion;
    }
    
    // sets the result page 
    public void setSortingResult(SortingResult result)
    {
        this.result = result;
    }
    
    // sets up the GUI for the question page
    public void showQuestion()
    
    {
        // creates a panel and sets color to white
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        
        // constructs an object for an image file and adds it in a label 
        // to panel because you cannot add an ImageIcon to a panel
        ImageIcon image = new ImageIcon("hogwartsCrest.jpg");
        JLabel label = new JLabel(image);
        panel.add(label);

        
        // creates text and sets font and color 
        JLabel textLabel = new JLabel("<html> <p style=\"margin-left:50px; "
                + "margin-right:50px; text-align:center;\">" 
                + this.question.getText() + " </p> </html>");
        textLabel.setForeground(new Color (31, 61, 49));
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 36);
        textLabel.setFont(font);

        

        // constructs buttons and calls methods to get the house answer values
        this.gButton = new JButton(this.question.getGryffindor());
        this.hButton = new JButton(this.question.getHufflepuff());
        this.rButton = new JButton(this.question.getRavenclaw());
        this.sButton = new JButton(this.question.getSlytherin());
        
        // designs the button text color and font
        Color darkBlue = new Color (75, 66, 244);
        this.gButton.setForeground(darkBlue);
        this.hButton.setForeground(darkBlue);
        this.rButton.setForeground(darkBlue);
        this.sButton.setForeground(darkBlue);
        this.gButton.setFont(font);
        this.hButton.setFont(font);
        this.rButton.setFont(font);
        this.sButton.setFont(font);
        
     
        // aligns the content on the page
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setAlignmentX(CENTER_ALIGNMENT);
        this.gButton.setAlignmentX(CENTER_ALIGNMENT);
        this.hButton.setAlignmentX(CENTER_ALIGNMENT);
        this.rButton.setAlignmentX(CENTER_ALIGNMENT);
        this.sButton.setAlignmentX(CENTER_ALIGNMENT);

        
        // this sets the layout for the JPanel 
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        
        // adds text to the panel
        panel.add(textLabel);
        
        // randomizes the answer choices for the user using if statements
        Random randomize = new Random();
        int combo = randomize.nextInt(4);

        if (combo == 0)
        {
            panel.add(this.gButton);
            panel.add(this.hButton);
            panel.add(this.rButton);
            panel.add(this.sButton);
        }
        
        else if (combo == 1)
        {
            panel.add(this.rButton);
            panel.add(this.gButton);
            panel.add(this.sButton);
            panel.add(this.hButton);
        }
        else if (combo == 2)
        {
            panel.add(this.hButton);
            panel.add(this.rButton);
            panel.add(this.sButton);
            panel.add(this.gButton);
        }
        else 
        {
            panel.add(this.sButton);
            panel.add(this.gButton);
            panel.add(this.hButton);
            panel.add(this.rButton);
        }

        // adds panel to window
        this.add(panel);
        
        
        // configures and displays the window 
        this.setResizable(false);
        this.setSize(SortingHat.DIMENSION);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // when the button is clicked by the user, it will call the 
        // actionPerformed method
        this.gButton.addActionListener(this);
        this.hButton.addActionListener(this);
        this.rButton.addActionListener(this);
        this.sButton.addActionListener(this);
    }

    // responds when the user clicks a button 
    public void actionPerformed(ActionEvent e)
    {
        
        // this closes the JFrame window
        this.dispose();
        
        // when a button is clicked, it increments the counter to award a point 
        // towards that particular house associated with that button 
        if (this.gButton == e.getSource())
        {
            tracker.incrementGCount();
           
        }
        else if (this.hButton == e.getSource())
        {
            tracker.incrementHCount();
            
        }
        
        else if (this.rButton == e.getSource())
        {
            tracker.incrementRCount();
            
        }
        else
        {
            tracker.incrementSCount();
           
        }
        
        // if there is no link to the sorting result page, it is assumed that
        // there must be another question-- shows next question
        // else show the result page
        if (result == null)
        {
            nextQuestion.showQuestion();
        }
        else 
        {
            result.showSortingResult();
        }
        

    }
  
}

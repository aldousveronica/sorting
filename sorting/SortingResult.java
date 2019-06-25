package sorting;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * SortingResult.java
 * by Veronica Aldous 
 * 5/13/19
 * 
 * This class contains the user's result at the end of the quiz. It
 * will display a message informing the user their quiz outcome. 
 * 
 */
public class SortingResult extends JFrame
{
    // tracks the user's results 
    protected ResultTracker tracker; 

    // constructor assigns the value for tracker 
    public SortingResult(ResultTracker tracker)
    {
        this.tracker = tracker;
    }
   
    // takes info from the trackers and returns image file, message and color 
    // corresponding to the house with the most points and point percentages.
    // returns an Object array, where index 0 = message, index 1 = image,
    // index 2 = percents, index 3 = color
    public Object[] determineSort()
    {
        // calls the count methods and stores the values for each house 
        // and calculates the total 
        int g = tracker.getGCount();
        int h = tracker.getHCount();
        int r = tracker.getRCount();
        int s = tracker.getSCount();
        int total = g + h + r + s;
        
        // variables that hold percentage for each house 
        double percentG  = ((double) g / total) * 100;
        double percentH  = ((double) h / total) * 100;
        double percentR  = ((double) r / total) * 100;
        double percentS  = ((double) s / total) * 100;
        
        // rounds the percentages 
        String roundedG = String.format("%.2f", percentG);
        String roundedH = String.format("%.2f", percentH);
        String roundedR = String.format("%.2f", percentR);
        String roundedS = String.format("%.2f", percentS);
        
        // makes a String to display all of the percentages 
        String percents = 
                "<html><p>Gryffindor: " + roundedG + "% <br />" + 
                        "Hufflepuff: " + roundedH + "% <br />" +
                        "Ravenclaw: " + roundedR + "% <br />" + 
                        "Slytherin: " + roundedS + "% </p></html>";
        
        // return values for the various outcomes 
        Object[] gSorting = {"You are in Gryffindor!", "Gryf.png", 
                percents, Color.red};
        Object[] hSorting = {"You are in Hufflepuff!", "Huffle.png",
                percents, Color.black};
        Object[] rSorting = {"You are in Ravenclaw!", "Raven.png",  
                percents, Color.blue};
        Object[] sSorting = {"You are in Slytherin!", "slytherin.png",
                percents, Color.green};
        Object[] tie  = {"There was a tie!", "tie.jpg", percents, Color.pink};
        
        
        // if Gryffindor has the most points
        if ((g > h) && (g > r) && (g > s))
        {

            return gSorting;
        }
        
        // if Hufflepuff has the most points
        else if ((h > g) && (h > r) && (h > s))
        {

            return hSorting;
        }
        
        // if Ravenclaw has the most points
        else if ((r > g) && (r > h) && (r > s))
        {
            
            return rSorting;
        }
        // if Slytherin has the most points
        else if ((s > g) && (s > h) && (s > r))
        {
            
            return sSorting;
        }
        
        // if tie
        else
        {
            
            return tie;
        }
        
        
    }
    
    // sets up the GUI for the result page
    public void showSortingResult()
    {
      
        // determines the house with the highest points and 
        // sets variables based on the returned values
        Object [] sorting =  determineSort();
        String message = (String) sorting[0];
        String imageFile = (String) sorting[1];
        String percentages = (String) sorting[2];
        Color color = (Color) sorting[3];
        
        
        // Sets the size of the window and does not allow the user to resize
        this.setSize(SortingHat.DIMENSION);
        this.setResizable(false);
     
        // creates the panel and sets the background color 
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        
        // displays image and message based on the house with the most points
        // and sets font and color 
        ImageIcon image = new ImageIcon(imageFile);
        JLabel label = new JLabel(image);
        JLabel sortedMessage = new JLabel(message);
        sortedMessage.setForeground(color);
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
        sortedMessage.setFont(font);
        
        // displays the percentages
        JLabel percentLabel = new JLabel(percentages);
        percentLabel.setForeground(color);
        percentLabel.setFont(font);
        
        // layout for the JPanel 
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        
        // aligns content of the page 
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setHorizontalAlignment(JLabel.CENTER);
        sortedMessage.setAlignmentX(CENTER_ALIGNMENT);
        sortedMessage.setHorizontalAlignment(JLabel.CENTER);
        percentLabel.setAlignmentX(CENTER_ALIGNMENT);
        percentLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // adds the contents to the panel and panel to the window
        panel.add(sortedMessage);
        panel.add(label);
        panel.add(percentLabel);
        this.add(panel);
        
        // shows the window and sets default close operation
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

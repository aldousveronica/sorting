
/*
 * Question.java
 * by Veronica Aldous 
 * 5/13/19
 * 
 * This class holds a content for a single question.
 * 
 */
public class Question
{   // This holds the text that asks the user a question 
    protected String text;
    
    // These are the values for each of the answers 
    protected String gryffindor;
    protected String hufflepuff;
    protected String ravenclaw;
    protected String slytherin;
    
    // The constructor sets the values for all of the fields
    public Question(String text, String gryffindor, String hufflepuff, String 
            ravenclaw, String slytherin)
    {
        this.text = text;
        this.gryffindor = gryffindor;
        this.hufflepuff = hufflepuff;
        this.ravenclaw = ravenclaw;
        this.slytherin = slytherin;
        
    }


    // gets the text of the question 
    public String getText()
    {
        return text;
    }

    // sets the text for the question 
    public void setText(String text)
    {
        this.text = text;
    }


    // gets the Gryffindor answer value 
    public String getGryffindor()
    {
        return gryffindor;
    }

    // sets the Gryffindor answer value 
    public void setGryffindor(String gryffindor)
    {
        this.gryffindor = gryffindor;
    }

    // gets the Hufflepuff answer value 
    public String getHufflepuff()
    {
        return hufflepuff;
    }

    // sets the Hufflepuff answer value 
    public void setHufflepuff(String hufflepuff)
    {
        this.hufflepuff = hufflepuff;
    }

    // gets the Ravenclaw answer value 
    public String getRavenclaw()
    {
        return ravenclaw;
    }

    // sets the Ravenclaw answer value 
    public void setRavenclaw(String ravenclaw)
    {
        this.ravenclaw = ravenclaw;
    }

    // gets the Slytherin answer value 
    public String getSlytherin()
    {
        return slytherin;
    }

    // sets the Slytherin answer value 
    public void setSlytherin(String slytherin)
    {
        this.slytherin = slytherin;
    }
    
    
    
    
}

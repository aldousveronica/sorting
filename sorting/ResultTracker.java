package sorting;

/*
 * ResultTracker.java
 * by Veronica Aldous 
 * 5/13/19
 * 
 * This class will hold the point values to determine the result and 
 * can increment the point values by one.
 * 
 */
public class ResultTracker
{
    // counts for each house
    protected int gCount;
    protected int hCount;
    protected int rCount;
    protected int sCount;
    
    
    // sets the result values to zero before the start of the quiz
    public ResultTracker()
    {
        this.gCount = 0;
        this.hCount = 0;
        this.rCount = 0;
        this.sCount = 0;
 
    }
    
    // gets Gryffindor count
    public int getGCount()
    {
        return this.gCount;
    }
    
    // gets Hufflepuff count
    public int getHCount()
    {
        return this.hCount;
    }
    
    // gets Ravenclaw count
    public int getRCount()
    {
        return this.rCount;
    }
    
    // gets Slytherin count
    public int getSCount()
    {
        return this.sCount;
    }
    
    // increments Gryffindor count by one
    public void incrementGCount()
    {
        this.gCount++;
    }
    
    // increments Hufflepuff count by one 
    public void incrementHCount()
    {
        this.hCount++;
    }
    
    // increments Ravenclaw count by one
    public void incrementRCount()
    {
        this.rCount++;
    }
    
    // increments Slytherin count by one
    public void incrementSCount()
    {
        this.sCount++;
    }
    
    
    
}

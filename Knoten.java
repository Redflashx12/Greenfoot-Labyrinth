/**
 * Write a description of class Knoten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knoten  
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private boolean besucht;

    /**
     * Constructor for objects of class Knoten
     */
    public Knoten(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean istBesucht(){
        return besucht;
    }
    
    public void setBesucht(){
        besucht = true;
    }
    
    @Override
    public String toString(){
        return "("+ x +"/"+y+")";
    }
}

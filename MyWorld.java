import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Spielfigur spielfigur;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(20, 15, 50); 
        
        prepare();

    }

    public void prepare(){

        spielfigur = new Spielfigur();
        addObject(spielfigur,10,7);
        Mauer mauer = new Mauer();
        addObject(mauer,5,5);
        Mauer mauer2 = new Mauer();
        addObject(mauer2,5,4);
        Mauer mauer3 = new Mauer();
        addObject(mauer3,5,6);
        Mauer mauer4 = new Mauer();
        addObject(mauer4,6,4);
        Mauer mauer5 = new Mauer();
        addObject(mauer5,6,3);
        Mauer mauer6 = new Mauer();
        addObject(mauer6,5,7);
        spielfigur.setLocation(1,9);
        Monster monster = new Monster();
        addObject(monster,7,6);
        monster.setLocation(6,6);
        monster.setLocation(6,5);
        monster.setLocation(4,8);
        monster.setLocation(8,9);
    }
    
    public Spielfigur spielfigurGeben(){
        return spielfigur;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Spielfigur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spielfigur extends Actor
{
    public Spielfigur(){
        super();
        getImage().scale(50,50);
    }

    /**
     * Act - do whatever the Spielfigur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        String key = Greenfoot.getKey();

        if(Greenfoot.isKeyDown("right")){
            setRotation(0);
            walk();
        }
        if(Greenfoot.isKeyDown( "left")){
            setRotation(180);
            walk();
        }
        if(Greenfoot.isKeyDown("down" )){
            setRotation(90);
            walk();
        }
        if(Greenfoot.isKeyDown( "up" )){
            setRotation(270);
            walk();
        }

        // if(Greenfoot.mouseClicked(getWorld())){
        // MouseInfo mouseInfo = Greenfoot.getMouseInfo();
        // int mx = mouseInfo.getX();
        // int my = mouseInfo.getY();
        // System.out.println("Gesuchter Weg: " + mx + "  " + my);
        // breitenSuche(new Knoten(mx,my),mx,my);
        // }

        // Add your action code here.
    }

    public void breitenSuche(Knoten a, int x, int y){
        ArrayList<Knoten> warteschlange = new ArrayList<Knoten>();
        warteschlange.add(new Knoten(getX(), getY()));
        Knoten[][] vorgänger = new Knoten[getWorld().getWidth()][getWorld().getHeight()];
        boolean zielErreicht = false;
        boolean[][] besucht = new boolean[getWorld().getWidth()][getWorld().getHeight()];
        while( !warteschlange.isEmpty() && !zielErreicht){
            Knoten k = warteschlange.remove(0);
            int kx = k.getX();
            int ky = k.getY();
            if(k.getX()+1>=0 && k.getX()+1<= 20 && !besucht[kx+1][ky]){
                System.out.println("Aufruf erfolgreich");
                Knoten b = new Knoten(kx+1 , ky);
                warteschlange.add( b );
                besucht[kx+1][ky]=true;
                System.out.println(warteschlange);

                System.out.println("Vorheriger X-Wert: " + getX());
                System.out.println("X von B: " + b.getX() + "/" + (k.getX()+1) + " vs gesuchtes X: " + x);
                if(k.getX()+1 == x && k.getY() == y){
                    System.out.println("Ziel erreicht");
                }
                else{
                    setRotation(0);
                    Greenfoot.delay(30);
                    walk();
                }
                //System.out.println("Koordinaten von Knoten b" + b.getX() + "  " + b.getY());
            }
            //warteschlange.add( new Knoten(x+1, y) );
            //warteschlange.add( new Knoten(x, y-1) );
            //warteschlange.add( new Knoten(x-1, y) );

        }
    }

    public void walk(){
        move(1);
        if(isTouching(Mauer.class)){
            move(-1);
        }
        setRotation(0);
    }
}

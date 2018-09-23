import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    int zielX;
    int zielY;
    boolean changed=false;
    private final int clock = 5;
    private final int maxSearch = 30;
    private int tick;

    public Monster(){
        super();
        getImage().scale(50,50);
    }

    public void zielSetzen(int x, int y){
        zielX = x;
        zielY = y;
        changed = true;
    }

    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(getWorld())){
            MouseInfo mouseInfo = Greenfoot.getMouseInfo();
            int mx = mouseInfo.getX();
            int my = mouseInfo.getY();
            System.out.println("Gesuchter Weg: " + mx + "  " + my);
            zielSetzen(mx,my);
        }

        // MyWorld welt = (MyWorld) getWorld();
        // zielX = welt.spielfigurGeben().getX();
        // zielY = welt.spielfigurGeben().getY();

        ArrayList<Knoten> warteschlange = new ArrayList<Knoten>();
        int startX = getX();
        int startY = getY();    
        Knoten startknoten = new Knoten(startX, startY);
        warteschlange.add(startknoten);
        int breite = getWorld().getWidth();
        int hoehe = getWorld().getHeight();
        boolean[][] besucht = new boolean[breite][hoehe];
        Knoten[][] vorgänger = new Knoten[breite][hoehe];

        boolean zielErreicht = false;
        if(changed==true && tick > clock) {
            tick = 0;
            for(int x = 0; x<breite; x++){
                for(int y= 0; y<hoehe; y++){
                    if(!getWorld().getObjectsAt(x, y, Mauer.class).isEmpty()){
                        besucht[x][y] = true;
                    }
                }
            }
            while(!warteschlange.isEmpty() && !zielErreicht){    
                Knoten k = warteschlange.remove(0);
                // falls rechter Nachbar noch nicht besucht, diesen zu Warteschlange hinzuzufügen
                int x = k.getX();
                int y = k.getY();

                if( x+1 < getWorld().getWidth() && !besucht[x+1][y]){
                    Knoten nachbarRechts = new Knoten (x+1, y);
                    warteschlange.add(nachbarRechts);
                    besucht[x+1][y]= true;
                    vorgänger[x+1][y] = k;
                    if(x+1==zielX && y==zielY){ 
                        zielErreicht = true;
                        System.out.println("Ziel erreicht :)");
                    }
                }

                if( x-1 >= 0 && !besucht[x-1][y]){
                    Knoten nachbarLinks = new Knoten (x-1, y);
                    warteschlange.add(nachbarLinks);
                    besucht[x-1][y]= true;
                    vorgänger[x-1][y] = k;
                    if(x-1==zielX && y==zielY){ 
                        zielErreicht = true;
                        System.out.println("Ziel erreicht :)");
                    }
                }

                if( y+1 < hoehe && !besucht[x][y+1]){
                    Knoten nachbarOben = new Knoten (x, y+1);
                    warteschlange.add(nachbarOben);
                    besucht[x][y+1]= true;
                    vorgänger[x][y+1] = k;
                    if(x==zielX && y+1==zielY){ 
                        zielErreicht = true;
                        System.out.println("Ziel erreicht :)");
                    }
                }

                if( y-1 >=0 && !besucht[x][y-1]){
                    Knoten nachbarUnten = new Knoten (x, y-1);
                    warteschlange.add(nachbarUnten);
                    besucht[x][y-1]= true;
                    vorgänger[x][y-1] = k;
                    if(x==zielX && y-1==zielY){ 
                        zielErreicht = true;
                        System.out.println("Ziel erreicht :)");
                    }
                }

            }

            if(zielErreicht){
                int x = zielX;
                int y = zielY;
                int letztesX = x;
                int letztesY = y;
                while(x != startX || y != startY){
                    Knoten k = vorgänger[x][y];
                    letztesX = x;
                    letztesY = y;
                    x = k.getX();
                    y = k.getY();
                }
                setLocation(letztesX, letztesY);
            }
        }   
        else{
            tick++;
        }
    } 
}

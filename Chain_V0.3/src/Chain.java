import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import enigma.console.TextAttributes;
import java.awt.Color;

public class Chain {
	
	
	public static enigma.console.Console cn = Enigma.getConsole("Chain", 100, 30, 25);
	public enigma.console.TextWindow ct = cn.getTextWindow();
   
	SingleLinkedList chain = new SingleLinkedList();
	
	private int THREADTIME = 100;
	private int SEED = 34;
	
   public TextMouseListener tmlis; 
   public KeyListener klis; 

   Random rnd = new Random(SEED);
   
   // ------ Standard variables for mouse and keyboard ------
   public int mousepr;          // mouse pressed?
   public int mousex, mousey;   // mouse text coords.
   public int keypr;   // key pressed?
   public int rkey;    // key   (for press/release)
   // ----------------------------------------------------
   
   public void clear()
   {
	   for(int j = 0;j<20;j++) for(int i = 0;i<50;i++) ct.output(i,j, ' ');
   }
   
   public int elementFinder(int[][] arr,int inputX, int inputY , int size)
   {   
	   for(int i = 0; i<size;i++)
	   {
		   if(arr[i][0] == inputX && arr[i][1] == inputY)
		   {
			   return +1;
		   }
	   }
	   
	   return -1;
   }
   
   public Chain() throws Exception {   // --- Contructor
      
	   char[][] gameMap = new char[19][31];
	   
	   int[][] plusPositions = new int[999][2];
	   int[][] numberPositions = new int[999][2];
	   
	   int plusCounter = 0;
	   int numberCounter = 0;
	   int round = 1;
	   int score = 0;
	   
	   boolean gameBegin = true;
	   
	   	/*boolean comesFromTop = false;
		boolean comesFromLeft = false;
		boolean comesFromRight = false;
		boolean comesFromDown = false;*/

	   Cursor cursor = new Cursor(10,10);
	   
	   boolean finish = false;
	   
	   
	  // Map Declaring
	   
	   for(int j = 0; j<19;j++)
	   {
		   for(int i = 0; i<31;i++)
		   {
			   if(i%2==0 && j%2==0) {gameMap[j][i] = Character.forDigit(rnd.nextInt(1,5),10);}
			   else
			   {
				   gameMap[j][i] = ' ';
			   }
		   }
	   }
	   
      // ------ Standard code for mouse and keyboard ------ Do not change
	   
      /*tmlis=new TextMouseListener() {
         public void mouseClicked(TextMouseEvent arg0) {}
         public void mousePressed(TextMouseEvent arg0) {
            if(mousepr==0) {
               mousepr=1;
               mousex=arg0.getX();
               mousey=arg0.getY();
            }
         }
         public void mouseReleased(TextMouseEvent arg0) {}
      };
      cn.getTextWindow().addTextMouseListener(tmlis);*/
    
      klis=new KeyListener() {
         public void keyTyped(KeyEvent e) {}
         public void keyPressed(KeyEvent e) {
            if(keypr==0) {
               keypr=1;
               rkey=e.getKeyCode();
            }
         }
         public void keyReleased(KeyEvent e) {}
      };
      
      cn.getTextWindow().addKeyListener(klis);
      // ----------------------------------------------------
      
      ct.setCursorPosition(10, 2);
		ct.output("			*Welcome to the Chain Game*");
		ct.setCursorPosition(10, 3);
		ct.output("			---------------------------");
		
	    Scanner inputMenu = new Scanner(System.in);
	    int choice = 0;
	    while (true) {
	    	
			ct.setCursorPosition(30, 5);
	        System.out.println("===========");
			ct.setCursorPosition(29, 6);
	        System.out.println("  GAME MENU");
			ct.setCursorPosition(30, 7);
	        System.out.println("===========");
			ct.setCursorPosition(30, 8);
	        System.out.println("1. Start game");
			ct.setCursorPosition(30, 9);
	        System.out.println("2. High score");
			ct.setCursorPosition(30, 10);
	        System.out.println("3. Exit");
			ct.setCursorPosition(30, 11);
	        System.out.print("Enter your choice: ");
	        try {
	            choice = inputMenu.nextInt();
	            switch (choice) {
	                case 1:
	                	
	                    break;
	            		// ----------------------------------------------------
	                case 2:
	                	ct.setCursorPosition(30, 5);
	        	        System.out.println("============");
	            		ct.setCursorPosition(29, 6);
	                    System.out.println("  HIGH SCORE");
	            		ct.setCursorPosition(30, 7);
	        	        System.out.println("============");
	            		ct.setCursorPosition(30, 8);
	                    System.out.println("		     ");
	            		ct.setCursorPosition(30, 9);
	                    System.out.println("		     ");
	            		ct.setCursorPosition(30, 10);
	                    System.out.println("	   ");
	            		ct.setCursorPosition(30, 11);
	                    System.out.print("					    ");
	                    ct.setCursorPosition(30, 12);
	                    System.out.println("								 ");
	            		ct.setCursorPosition(30, 13);
	    	            System.out.println("									 ");
	        			ct.setCursorPosition(30, 5);
	                    break;
	            		// ----------------------------------------------------
	                case 3:
	    	            System.exit(0);
	                    break;
	            		// ----------------------------------------------------
	                default:
	            		ct.setCursorPosition(30, 12);
	                    System.out.println("Invalid choice. Please try again.");
	                    continue; // loop back to show the menu again
	            }
	        } catch (InputMismatchException e) {
      		ct.setCursorPosition(30, 13);
	            System.out.println("									 ");
	            System.out.println("Invalid input. Please enter a number.");
	            inputMenu.nextLine();
	        }
	        break;
	    } 
      
	    clear();
	    
      while(!finish) {
    	  if (gameBegin) {
  	    	Scanner input = new Scanner(System.in);
  	    	    
  	    	// Ask for player's name
  	        ct.setCursorPosition(28, 5);
  	    	System.out.print("Enter your name: ");
  	        ct.setCursorPosition(45, 5);
  	    	String playerName = cn.readLine();
  	        ct.setCursorPosition(45, 5);
  	        ct.output("                       									");
  	        ct.setCursorPosition(28, 4);
  	        System.out.println("Welcome, " + playerName + "!");
  	        ct.setCursorPosition(25, 5);
  	        ct.output("PRESS ENTER TO START");        
  	        System.in.read();
  	        ct.setCursorPosition(25, 5);
  	        ct.output("                    ");
  	        
  	        clear();
  	        	
  	        
  	        gameBegin = false;
  	    }
         if(mousepr==1) {  // if mouse button pressed
            
         }
         if(keypr==1) {    // if keyboard button pressed
            if(rkey==KeyEvent.VK_LEFT)  
            	if(cursor.getX()>0) 
            	{
            		cn.getTextWindow().output(cursor.getX(), cursor.getY(), ' ');
            		cursor.setX(cursor.getX()-1);
            	}
            if(rkey==KeyEvent.VK_RIGHT) 
            	if(cursor.getX()<31) 
            	{
            		cn.getTextWindow().output(cursor.getX(), cursor.getY(), ' ');
            		cursor.setX(cursor.getX()+1);
            	}
            if(rkey==KeyEvent.VK_UP) 
            	if(cursor.getY()>0) 
            	{
            		cn.getTextWindow().output(cursor.getX(), cursor.getY(), ' ');
            		cursor.setY(cursor.getY()-1);
            	}
            if(rkey==KeyEvent.VK_DOWN) 
            	if(cursor.getY()<=19) 
            	{
            		cn.getTextWindow().output(cursor.getX(), cursor.getY(), ' ');
            		cursor.setY(cursor.getY()+1);
            	}
            
            if(rkey==KeyEvent.VK_ENTER) 
            	{          	
            		boolean error = false;
            		if(numberCounter <=4)
            		{
            			error = true;
            		}
            		for(int i = 0 ; i<chain.size()-1;i++)
            		{
            			if(Integer.parseInt(chain.getDataFromIndex(i).toString())+1 == Integer.parseInt(chain.getDataFromIndex(i+1).toString()) || Integer.parseInt(chain.getDataFromIndex(i).toString())-1 == Integer.parseInt(chain.getDataFromIndex(i+1).toString()))
            			{
            				
            			}
            			else {
            				error = true;
            			}
            		}
            		if(error)
            		{
            			cn.getTextWindow().setCursorPosition(40, 15);
            		    cn.getTextWindow().output(String.format("ERROR IN CHAIN" ));
            		    finish = true;
            		}
            		else 
            		{
            			ChainTable.construtTable(chain);
            			
            			score+=(chain.size()*chain.size());
            			round+=1;
            			
            			for(int i = 0;i<chain.size();i++)
            		    {
            		    	cn.getTextWindow().setCursorPosition(40+i, 5);
            		        cn.getTextWindow().output(String.format(" "));
            		    }
            			
            			for(int i = 0;i<plusCounter;i++)
                		{
                			gameMap[plusPositions[i][1]][plusPositions[i][0]] = ' ';
                			plusPositions[i][0] = 0;
                			plusPositions[i][1] = 0;
                		}
            			
                		plusCounter = 0;
                		
                		for(int i = 0;i<numberCounter;i++)
                		{
                			gameMap[numberPositions[i][1]][numberPositions[i][0]] = '.';
                			numberPositions[i][0] = 0;
                			numberPositions[i][1] = 0;
                		}
                		
                		numberCounter = 0;
                		
                		chain = new SingleLinkedList();
            		}
            	}
            
            if(rkey==KeyEvent.VK_E) 
        	{
        		finish = true;
        	}
            
            char rckey=(char)rkey;
            //        left          right          up            down
            if(rckey=='%' || rckey=='\'' || rckey=='&' || rckey=='('); // VK kullanmadan test teknigi
			
            
            if(rkey==KeyEvent.VK_SPACE) 
            {
            	boolean flag = false;
            	boolean horizontal = false;
         	    boolean vertical = false;
            	
            	if(cursor.getX()%2==1 && cursor.getY()%2==1);
            	else if(cursor.getX()%2==0 && cursor.getY()%2==0);
            	else if(gameMap[cursor.getY()][cursor.getX()] == '+') 
            	{
            		for(int i = 0;i<chain.size();i++)
        		    {
        		    	cn.getTextWindow().setCursorPosition(40+i, 5);
        		        cn.getTextWindow().output(String.format(" "));
        		    }
            		
            		for(int i = 0;i<plusCounter;i++)
            		{
            			gameMap[plusPositions[i][1]][plusPositions[i][0]] = ' ';
            			plusPositions[i][0] = 0;
            			plusPositions[i][1] = 0;
            		}
            		plusCounter = 0;
            		
            		for(int i = 0;i<numberCounter;i++)
            		{
            			numberPositions[i][0] = 0;
            			numberPositions[i][1] = 0;
            		}
            		
            		numberCounter = 0;
            		
            		chain = new SingleLinkedList();
            	}
            	else 
            	{
            		if(plusCounter == 0) // ilk +
            		{
            			flag = true;
            		
            			if(cursor.getX()%2==0 && cursor.getY()%2 == 1) // dikeyse
                		{
                			vertical = true;
                		}
                		else if(cursor.getX()%2==1 && cursor.getY()%2 == 0) // yataysa
                		{
                			horizontal = true;
                		}
            		}
            		else if(plusPositions[plusCounter-1][0]%2==0 && plusPositions[plusCounter-1][1]%2 == 1) // dikeyse
            		{
            			if(cursor.getX() <= plusPositions[plusCounter-1][0]+1 && cursor.getX() >= plusPositions[plusCounter-1][0]-1 && cursor.getY() <= plusPositions[plusCounter-1][1]+2 && cursor.getY() >= plusPositions[plusCounter-1][1]-2)
            			{
            				vertical = true;
            				flag = true;
            			}
            		}
            		else if(plusPositions[plusCounter-1][0]%2==1 && plusPositions[plusCounter-1][1]%2 == 0) // yataysa
            		{
            			if(cursor.getX() <= plusPositions[plusCounter-1][0]+2 && cursor.getX() >= plusPositions[plusCounter-1][0]-2 && cursor.getY() <= plusPositions[plusCounter-1][1]+1 && cursor.getY() >= plusPositions[plusCounter-1][1]-1)
            			{
            				horizontal = true;
            				flag = true;
            			}
            		}
            		
            		if (flag)
            		{
            			gameMap[cursor.getY()][cursor.getX()] = '+';
            			plusPositions[plusCounter][0] = cursor.getX();
            			plusPositions[plusCounter][1] = cursor.getY();
            			plusCounter++;
            		}
            		
            		if(horizontal)
        			{
        				// önce sol
        				if(elementFinder(numberPositions, cursor.getX()-1,cursor.getY(),numberCounter+1) == -1 && gameMap[cursor.getY()][cursor.getX()-1] != ' ') 
        				{
        					numberPositions[numberCounter][0] = cursor.getX()-1;
                			numberPositions[numberCounter][1] = cursor.getY();
                			chain.add(gameMap[numberPositions[numberCounter][1]][numberPositions[numberCounter][0]]);
                			
                			numberCounter++;
        				}

        				// sonra sağ
        				
        				if(elementFinder(numberPositions, cursor.getX()+1,cursor.getY(),numberCounter+1) == -1 && gameMap[cursor.getY()][cursor.getX()+1] != ' ') 
        				{
        					numberPositions[numberCounter][0] = cursor.getX()+1;
                			numberPositions[numberCounter][1] = cursor.getY();
                			chain.add(gameMap[numberPositions[numberCounter][1]][numberPositions[numberCounter][0]]);
            				
                			numberCounter++;
        				}
            			horizontal = false;
            			vertical = false;
        			}
        			if (vertical)
        			{
        				// önce yukarı
        				
        				if(elementFinder(numberPositions, cursor.getX(),cursor.getY()-1,numberCounter+1) == -1 && gameMap[cursor.getY()-1][cursor.getX()] != ' ') 
        				{
        					numberPositions[numberCounter][0] = cursor.getX();
                			numberPositions[numberCounter][1] = cursor.getY()-1;
                			chain.add(gameMap[numberPositions[numberCounter][1]][numberPositions[numberCounter][0]]);
            				
                			numberCounter++;
        				}

        				// sonra aşağı
        				
        				if(elementFinder(numberPositions, cursor.getX(),cursor.getY()+1,numberCounter+1) == -1 && gameMap[cursor.getY()+1][cursor.getX()] != ' ') 
        				{
        					numberPositions[numberCounter][0] = cursor.getX();
                			numberPositions[numberCounter][1] = cursor.getY()+1;
                			chain.add(gameMap[numberPositions[numberCounter][1]][numberPositions[numberCounter][0]]);
            				
                			numberCounter++;
        				}
        				horizontal = false;
            			vertical = false;	
        			}
            	}
            }
            
            keypr=0;    // last action  
         }
         
         // Map Displaying
         
       for(int j = 0; j<=18;j++) for(int i = 0; i<=30;i++) cn.getTextWindow().output(i, j,gameMap[j][i]);
       
       for(int j = 0;j<=18;j++) cn.getTextWindow().output(31, j, ' ');
       
       for(int i = 0;i<=31;i++) cn.getTextWindow().output(i, 19, ' ');
       
       cn.getTextWindow().setCursorPosition(40, 0);
       cn.getTextWindow().output(String.format("Board Seed:   %d", SEED));
       cn.getTextWindow().setCursorPosition(40, 1);
       cn.getTextWindow().output(String.format("Round:        %d", round));
       cn.getTextWindow().setCursorPosition(40, 2);
       cn.getTextWindow().output(String.format("Score:        %d", score));
       
       /*for(int i = 0;i<chain.size();i++)
       {
    	   cn.getTextWindow().setCursorPosition(40+i, 5);
           cn.getTextWindow().output(String.format("%c", chain.getDataFromIndex(i)));
       }
       cn.getTextWindow().setCursorPosition(40, 6);
       cn.getTextWindow().output(String.format("%d", numberCounter));*/
       
       /*for(int i =0;i<plusXPositions.size();i++)
       {
    	   cn.getTextWindow().output((int)plusXPositions.getDataFromIndex(i),(int)plusYPositions.getDataFromIndex(i), '+');
       }*/
       
    // Cursor Display
       cn.getTextWindow().output(cursor.getX(), cursor.getY(), 'O');
         Thread.sleep(THREADTIME);
      }
   }
}

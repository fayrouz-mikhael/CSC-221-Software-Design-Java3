package application;

import java.util.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class PieChart {

	private double radius;
	private double x;
	private double y;
	static int number = 3; // the number of the events
;
	private Color color;
	 private Font  font; 
	
	public PieChart(double x , double y ,double radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius= radius;
		this.color = color;
	}
	public void setColor(Color color) { //  to set the color
		this.color= color;
	}	
	public void setRadius(double radius) { //  to set the radius
		this.radius=radius;
	}
	public void setx(double x) { //  to set x
		this.x=x;
	}
	public void sety(double y) { //  to set y
		this.y=y;
	}

	public double getRadius() { //  to get the radius
		return radius;
	}
	public double getx() { //  to get x
		return x;
	}
	public double gety() { //  to get y
		return y;
	}
	
	// This method is to find the area which is proportional to the Probability of the Event
	
	  public static double[] area() {
		 HistogramLetters x = new HistogramLetters(); //  calling HistogramLetters Class
		 double centralAngle = 0.0;
		double data [] = new double[number];		// new array to insert the centalAngle values in it
		 Map<Character, Double> source = x.readfile(); 
			 int i =0;
	 for (Map.Entry<Character, Double> entry:source.entrySet()) { // For loop to get all the entries of the map and insert it in an array
		
			centralAngle = 2*Math.PI*entry.getValue();
			
				data[i++]= centralAngle;
						}
	 
		 return data; // return the array
	  }
		  
	 public static double[] problegendShowing() { // this method is to show and print the probability of each event
		 HistogramLetters x = new HistogramLetters();	//  calling HistogramLetters Class
		 double probdata [] = new double[number]; // new array to insert the probabilities values in it
		 Map<Character, Double>  source = x.readfile(); 
		int i=0;
		  for (Map.Entry<Character, Double> entry:source.entrySet()) { // For loop to get all the entries of the map and insert it in an array
			  probdata[i++]=entry.getValue();
			 }
		  return probdata;
	  }
	 public static char[] charlegendShowing() { // this method is to show and print the character of each event
		 HistogramLetters x = new HistogramLetters();	//  calling HistogramLetters Class
		 char character[] = new char[number];  // new array to insert the characters values in it
		 Map<Character, Double>  source = x.readfile(); 
		int i=0;
		  for (Map.Entry<Character, Double> entry:source.entrySet()) { // For loop to get all the entries of the map and insert it in an array
			  character[i++]=entry.getKey();
			 }
		  return character;
	  }
	 
	
		
		public static double centralangleofother(double x)  // this method to get the center angle for the ALLotherEvents
		{
			double angle = 2*Math.PI*x;
			return angle;
			}
		
	
	  
	  public void drawShape(GraphicsContext gc) {
		  setx(110);
		  sety(80);
		  setRadius(200);
		  double Centralresult [] = null;
		  double probresult [] = null;
		  char characterresult [] = null;
		  
		  double Centralkey = 0 ,  probkey = 0;
		  char characterkey =0;
		  
		  double Centralkey0 = 0 ,  probkey0 = 0;
		  double Centralkey1 = 0 ,  probkey1 = 0 ;
		  double Centralkey2 = 0 ,  probkey2 = 0 ;
		  char characterkey0 = 0 , characterkey1=0 , characterkey2=0;
		  
		  
		  for(int i = 0 ; i < number ; i++) { // For loop to get all of the arrays in each of area(),problegendShowing(),charlegendShowing() methods
			  Centralresult =   area();
			  probresult =problegendShowing();
			  characterresult = charlegendShowing();
		  }
		  int j = 0 ;
		  //int second = 0;
		  double first =0;
		  double factor = 80 ;
		 // Color color = k ;
		  while(number >=j) { // while loop to initialize variable for each element in each of the arrays
			  Centralkey = Centralresult[j];
			  probkey = probresult[j];
			  characterkey = characterresult[j];
			  
			  if (number > j) {
			  String c = Character.toString(characterkey); // is to convert character to string 
				 Double.toString(probkey);
				String d = String.format("%.3f", probkey);
				  gc.setLineWidth(2);
				  //gc.setFill(color);
				  
			      font = new Font("Sanserif", 20);
			      
			      gc.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			      gc.fillArc( getx(), gety(), getRadius(),getRadius(), first+factor, Centralkey*40 ,ArcType.ROUND); // increasing the central angle by a factor of 40 appear 
			      gc.setTextAlign(TextAlignment.RIGHT);
			     gc.fillText(c+" , "+d, getx()+120, gety()-10);
			     
			  }
			     
			     else {
				
				double theOther = 1 - (probkey);
				  Double.toString(theOther);
				String d3 = String.format("%.3f", theOther);
			  
				 double  Centralother = centralangleofother(theOther);  // to get the central angle for allotherEvents by calling centralangleofother function 
				 System.out.println(centralangleofother(theOther));
				  
				 gc.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			      gc.fillArc( getx(), gety(), getRadius(),getRadius(), first+factor, Centralother*40 ,ArcType.ROUND); // increasing the central angle by a factor of 40 appear 
			      gc.setTextAlign(TextAlignment.RIGHT);
			     gc.fillText(theOther+" , "+d3, getx()+120, gety()-10);
			
				 
			     }
			  
			  j++;
			  number --;
			  first = Centralkey*40;
			  factor = 38;
			  
				
			  
			 /* if(j == 0) {
				  Centralkey2 = Centralresult[0];
				  probkey2 = probresult[0];
				  characterkey2 = characterresult[0]; 
				  
			  }
				 
			  else if(j==1) {
				  Centralkey1 = Centralresult[1];
				  probkey1 = probresult[1];
				  characterkey1 =characterresult[1];
		  }
			  else {
				  Centralkey0 = Centralresult[2]; 
			  probkey0 = probresult[2];
			  characterkey0 =characterresult[2];
		  }*/
			  
		  }
		 
		/*  
		 String c0 = Character.toString(characterkey0); // is to convert character to string 
		 Double.toString(probkey0);
		String d0 = String.format("%.3f", probkey0); // is to convert double to string and get only the first 3 decimals
		 String c1 = Character.toString(characterkey1);
		 Double.toString(probkey1);
		String d1 = String.format("%.3f", probkey1);
		 String c2 = Character.toString(characterkey2);
		 Double.toString(probkey2);
		String d2 = String.format("%.3f", probkey2);
		  
		  double theOther = 1 - (probkey1+probkey2+probkey0);
		  Double.toString(theOther);
		String d3 = String.format("%.3f", theOther);
		  */
			
	    
	      
	    
  
	      // Draw the first arc with event " a" and its probability
	    /*  gc.setFill( Color.BLACK );
	      gc.fillArc( getx(), gety(), getRadius(),getRadius(), 80, Centralkey0 *40 ,ArcType.ROUND); // increasing the central angle by a factor of 40 appear 
	      gc.setTextAlign(TextAlignment.RIGHT);
	     gc.fillText(c0+" , "+d0, getx()+120, gety()-10);

	     // Draw the second arc with event " t" and its probability
	     gc.setFill( Color.RED );
	      gc.fillArc( getx(), gety(), getRadius(),getRadius(), Centralkey0*40+42, Centralkey1 *40,ArcType.ROUND );// increasing the central angle by a factor of 40 appear
	      gc.setTextAlign(TextAlignment.RIGHT);
	      gc.fillText(c1+" , "+d1, getx()+170, gety()+1);
	      
	      // Draw the third arc with event " e" and its probability
	      gc.setFill( Color.BLUE );
	      gc.fillArc(  getx(), gety(), getRadius(),getRadius(), Centralkey1*40+9, Centralkey2 *40,ArcType.ROUND );// increasing the central angle by a factor of 40 appear
	      gc.setTextAlign(TextAlignment.RIGHT);
	      gc.fillText(c2+" , "+d2, getx()+220, gety()+30);
	      
	      // Draw the last arc with event " other letters " and its probability
	      gc.setFill( Color.GREEN);
	      gc.fillArc(  getx(), gety(), getRadius(),getRadius(), Centralkey2*40+68.6,Centralother*65 ,ArcType.ROUND );
	      gc.setTextAlign(TextAlignment.RIGHT);
	      gc.fillText("OTHER LETTERS"+" , "+d3, getx()+39, gety()+190);
	     */
	      
	      
	  }
	  
}

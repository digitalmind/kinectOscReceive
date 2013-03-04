import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import oscP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class kinectOscReceive extends PApplet {



OscP5 oscP5;
Head h;
public void setup()
{
  size(1280,480,P3D);
  smooth();
  oscP5 = new OscP5(this,12002);
  oscP5.plug(this,"setHead","/head");
  h = new Head();
  
}

public void draw()
{
 background(0);
 fill(200);
 text("Text\u00e9",640,200);
 h.display();
}

public void setHead(int _index, float x, float y, float z)
{
	x *= width;
	y *= height;

	println("("+x+","+y+","+z+")");
	h.update(new PVector(x,y,z));
	//ellipse(x,y, 200,200);
}

public void setLHand(int _index, float x, float y, float z)
{
	x *= width;
	y *= height;

	switch(_index)
	{
		case 0:
		
			fill(255,0,0);
			break;
		
		case 1:
		
			fill(0,255,0);
			break;
		
		case 2:
		
			fill(0,0,255);
			break;
		
	}
	pushMatrix();
	translate(x,y);
	fill(255,0,0);
	popMatrix();
}

/* incoming osc message are forwarded to the oscEvent method. */
public void oscEvent(OscMessage theOscMessage) {
  /* print the address pattern and the typetag of the received OscMessage */
  print("### received an osc message.");
  print(" addrpattern: "+theOscMessage.addrPattern());
  println(" typetag: "+theOscMessage.typetag());

//  if(theOscMessage.addrpattern == "")

}
class Head extends Joint{

}
class Joint{
	PVector position;
	Joint()
	{
		position = new PVector();
	}

	public void update(PVector _pos)
	{
		position = _pos.get();
		println(position);
	}

	public void display()
	{
		pushMatrix();
		translate(position.x,position.y,0.0f);
		fill(255);
		box(50);
		popMatrix();
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "kinectOscReceive" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

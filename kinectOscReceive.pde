import oscP5.*;

OscP5 oscP5;
Head h;
void setup()
{
  size(1280,480,P3D);
  smooth();
  oscP5 = new OscP5(this,12002);
  oscP5.plug(this,"setHead","/head");
  h = new Head();
  
}

void draw()
{
 background(0);
 fill(200);
 text("Texté",640,200);
 h.display();
}

void setHead(int _index, float x, float y, float z)
{
	x *= width;
	y *= height;

	println("("+x+","+y+","+z+")");
	h.update(new PVector(x,y,z));
	//ellipse(x,y, 200,200);
}

void setLHand(int _index, float x, float y, float z)
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
void oscEvent(OscMessage theOscMessage) {
  /* print the address pattern and the typetag of the received OscMessage */
  print("### received an osc message.");
  print(" addrpattern: "+theOscMessage.addrPattern());
  println(" typetag: "+theOscMessage.typetag());

//  if(theOscMessage.addrpattern == "")

}

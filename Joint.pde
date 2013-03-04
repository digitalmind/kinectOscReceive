class Joint{
	PVector position;
	Joint()
	{
		position = new PVector();
	}

	void update(PVector _pos)
	{
		position = _pos.get();
		println(position);
	}

	void display()
	{
		if(position)
		pushMatrix();
		translate(position.x,position.y,0.0f);
		fill(255);
		box(50);
		popMatrix();
	}
}
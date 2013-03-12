package com.example.circles;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Enemy extends GameObject
{
	public int x, y;
	public Bitmap bitmap;
	
	public Enemy(Bitmap bitmap, int x, int y, int speedX, int speedY)
	{
		super(bitmap, x, y);
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
	}
	public void update()
	{
		super.update();
	}
	public void draw(Canvas canvas)
	{
		super.draw(canvas, 50, 50);
	}
}

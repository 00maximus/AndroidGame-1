package com.example.circles;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Arrows extends GameObject
{
	public int x, y;
	public Bitmap bitmap;
	
	public Arrows(Bitmap bitmap, int x, int y)
	{
		super(bitmap, x, y);
		this.x = x;
		this.y = y;
		this.bitmap = bitmap;
		this.speedX = 0;
		this.speedY = 0;
	}
	public void update()
	{
		//bitmap = this.Rotate(bitmap,90, x, y);
	}
	public void draw(Canvas canvas)
	{
		super.draw(canvas, 100, 100);
	}
	public boolean IsTouchingArrow(Arrows arrow, int xPos, int yPos)
	{
		if(xPos >= arrow.getX() && xPos <= arrow.getX() + arrow.getBitmap().getWidth())
		{
			if(yPos >= arrow.getY() && yPos <= arrow.getY() + arrow.getBitmap().getHeight())
			{
				return true;
			}
			return false;
		}
		else
		{
			return false;
		}
	}

}

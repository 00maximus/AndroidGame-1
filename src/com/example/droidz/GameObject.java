package com.example.droidz;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class GameObject 
{	
	public Bitmap bitmap;
	public int x,y;
	
	public GameObject(Bitmap bitmap, int x, int y)
	{
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;
	}
	public void setBitmap(Bitmap bitmap)
	{
		this.bitmap = bitmap;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	
}

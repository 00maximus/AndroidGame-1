package com.example.circles;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class GameObject 
{	
	private Bitmap bitmap;
	public int x,y;
	public int speedX, speedY;
	
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
	public Bitmap getBitmap()
	{
		return bitmap;
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
	public void draw(Canvas canvas, int width, int height)
	{
		bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
		canvas.drawBitmap(bitmap, x - (bitmap.getWidth() / 2), y - (bitmap.getHeight() / 2),null);
	}
	public void update()
	{
		Move();
	}
	public void Move()
	{
		this.x += speedX;
		this.y += speedY;
	}
	
	public Bitmap Rotate(Bitmap bitmap, int angle)
	{
		 Matrix matrix = new Matrix();
		 matrix.postRotate(angle);
		 Bitmap rotated = Bitmap.createBitmap(bitmap, 0, 0,
				 bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		 return rotated;
	}
}

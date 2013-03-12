package com.example.circles;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Player extends GameObject
{
	public int moveSpeed;
	public Bitmap bitmap;
	public boolean isMovingLeft, isMovingRight, isMovingUp, isMovingDown = false;
	
	public Player(Bitmap bitmap, int x, int y) 
	{
		super(bitmap, x, y);
		this.bitmap = bitmap;
		this.speedX = 0;
		this.speedY = 0;
		this.moveSpeed = 3;
	}
	public void update()
	{
		super.update();
	}
	public void draw(Canvas canvas)
	{
		super.draw(canvas, 50, 50);
	}
	public void SetMovingLeft()
	{
		this.isMovingLeft = true;
		this.speedX = -moveSpeed;//=1 for acceleration
	}
	public boolean IsMovingLeft()
	{
		return isMovingLeft;
	}
	public void SetMovingRight()
	{
		this.isMovingRight = true;
		this.speedX = moveSpeed;//+=1 for acceleration
	}
	public boolean IsMovingRight()
	{
		return isMovingRight;
	}
	public void SetMovingUp()
	{
		this.isMovingUp = true;
		this.speedY = -moveSpeed;
	}
	public boolean IsMovingUp()
	{
		return isMovingUp;
	}
	public void SetMovingDown()
	{
		this.isMovingDown = true;
		this.speedY = moveSpeed;
	}
	public boolean IsMovingDown()
	{
		return isMovingDown;
	}
	public void SetNotMovingHorizontal()
	{
		this.isMovingLeft  = false;
		this.isMovingRight = false;
		this.speedX = 0;
	}
	public void SetNotMovingVertical()
	{
		this.isMovingUp  = false;
		this.isMovingDown = false;
		this.speedY = 0;
	}
}

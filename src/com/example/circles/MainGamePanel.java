package com.example.circles;

import com.example.circles.R;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback 
{
	private static final String TAG = MainGamePanel.class.getSimpleName();
	
	private MainThread thread;
	public Player player;
	
	public int width,height;
	
	public int level;
	
	public Arrows leftArrow, rightArrow, upArrow, downArrow;

	public static ArrayList<Arrows> arrowList = new ArrayList<Arrows>();
	public static ArrayList<Enemy>  enemyList = new ArrayList<Enemy>();
	
	public MainGamePanel(Context context) 
	{
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);
		
		context = getContext();
		DisplayMetrics displayMetrics = new DisplayMetrics(); 
		displayMetrics = context.getResources().getDisplayMetrics();
		width = displayMetrics.widthPixels;
		height = displayMetrics.heightPixels;

		level = 0;
		
		InitializeGame();
		// create the game loop thread
		thread = new MainThread(getHolder(), this);
		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}
	public void InitializeLevel(int level)
	{
		
	}
	public void InitializeGame()
	{
		Enemy enemy = new Enemy(
				BitmapFactory.decodeResource(getResources(), R.drawable.enemy),
				-5, 200, 4, 0
				);
		enemyList.add(enemy);
		
		player = new Player(
				BitmapFactory.decodeResource(getResources(), R.drawable.player),
				width/2,height/2);
		leftArrow = new Arrows(
				BitmapFactory.decodeResource(getResources(), R.drawable.triangle),
				width,height
				);
		rightArrow = new Arrows(BitmapFactory.decodeResource(getResources(), R.drawable.triangle),
				width,height
				);
		upArrow = new Arrows(
				BitmapFactory.decodeResource(getResources(), R.drawable.triangle),
				width,height
				);
		downArrow = new Arrows(
				BitmapFactory.decodeResource(getResources(), R.drawable.triangle),
				width,height
				);
		
		arrowList.add(leftArrow);
		arrowList.add(rightArrow);
		arrowList.add(upArrow);
		arrowList.add(downArrow);
		
		leftArrow.setX(width/10);
		rightArrow.setX(width/10 + rightArrow.getBitmap().getWidth());
		leftArrow.setY(height-leftArrow.getBitmap().getHeight());
		rightArrow.setY(height-leftArrow.getBitmap().getHeight());
		upArrow.setX(width-(upArrow.getBitmap().getWidth()));
		upArrow.setY(height-(upArrow.getBitmap().getHeight()*2));
		downArrow.setX(width-(downArrow.getBitmap().getWidth()));
		downArrow.setY(height-(downArrow.getBitmap().getHeight()));
		rightArrow.setBitmap(rightArrow.Rotate(rightArrow.getBitmap(),90));
		leftArrow.setBitmap(rightArrow.Rotate(rightArrow.getBitmap(),180));
		downArrow.setBitmap(downArrow.Rotate(downArrow.getBitmap(),180));
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) 
	{ }

	@Override
	public void surfaceCreated(SurfaceHolder holder) 
	{
		// at this point the surface is created and
		// we can safely start the game loop
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) 
	{
		Log.d(TAG, "Surface is being destroyed");
		// tell the thread to shut down and wait for it to finish
		// this is a clean shutdown
		boolean retry = true;
		while (retry) 
		{
			try 
			{
				thread.join();
				retry = false;
			} 
			catch (InterruptedException e) 
			{
				// try again shutting down the thread
			}
		}
		Log.d(TAG, "Thread was shut down cleanly");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			int xPos = (int)event.getX();
			int yPos = (int)event.getY();
			
			if(leftArrow.IsTouchingArrow(leftArrow, xPos, yPos))
			{
				player.SetMovingLeft();
			}
			if(rightArrow.IsTouchingArrow(rightArrow, xPos,yPos))
			{
				player.SetMovingRight();
			}
			if(upArrow.IsTouchingArrow(upArrow, xPos,yPos))
			{
				player.SetMovingUp();
			}
			if(downArrow.IsTouchingArrow(downArrow, xPos,yPos))
			{
				player.SetMovingDown();
			}
			
			
			//bucket.handleActionDown((int)event.getX(), (int)event.getY());
			if (event.getAction() == MotionEvent.ACTION_MOVE)
			{	
			}
		}
		
		if (event.getAction() == MotionEvent.ACTION_UP) 
		{
			if(player.IsMovingLeft())
			{
				player.SetNotMovingHorizontal();
			}
			if(player.IsMovingRight())
			{
				player.SetNotMovingHorizontal();
			}
			if(player.IsMovingUp())
			{
				player.SetNotMovingVertical();
			}
			if(player.IsMovingDown())
			{
				player.SetNotMovingVertical();
			}
		}
		return true;
	}
	
	
	/*
	public boolean onTouchEvent(MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			// delegating event handling to the droid
			bucket.handleActionDown((int)event.getX(), (int)event.getY());
			
			// check if in the lower part of the screen we exit
			if (event.getY() > getHeight() - 50) 
			{
				thread.setRunning(false);
				((Activity)getContext()).finish();
			} 
			else
			{
				Log.d(TAG, "Coords: x=" + event.getX() + ",y=" + event.getY());
			}
		} 
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
			// the gestures
			if (bucket.isTouched()) 
			{
				// the droid was picked up and is being dragged
				bucket.setX((int)event.getX());
				//bucket.setY((int)event.getY());
			}
		}
		if (event.getAction() == MotionEvent.ACTION_UP) 
		{
			// touch was released
			if (bucket.isTouched()) {
				bucket.setTouched(false);
			}
		}
		return true;
	}*/

	public void render(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		player.draw(canvas);
		for (int i=0;i<arrowList.size();i++)
		{
			arrowList.get(i).draw(canvas);
		}
		for (int j=0;j<enemyList.size();j++)
		{
			enemyList.get(j).draw(canvas);
		}
	}

	/**
	 * This is the game update method. It iterates through all the objects
	 * and calls their update method if they have one or calls specific
	 * engine's update method.
	 */
	public void update() 
	{
		player.update();
		for (int i=0;i<arrowList.size();i++)
		{
			arrowList.get(i).update();
		}
		for (int j=0;j<enemyList.size();j++)
		{
			enemyList.get(j).update();
		}
		
	}

}

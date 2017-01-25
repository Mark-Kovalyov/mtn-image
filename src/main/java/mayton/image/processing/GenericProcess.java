package mayton.image.processing;

import java.awt.*;

public abstract class GenericProcess
{
	public void goProcess()
	{
		
	}

	public boolean isReady()
	{
		return false;
	}

	/*
         *  [0..100]
         */
	public synchronized int getProgress()
	{
		return 0;
	}

}



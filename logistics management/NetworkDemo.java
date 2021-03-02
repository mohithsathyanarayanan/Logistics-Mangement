package demo19023;
import java.util.ArrayList;
import base.*;

class NetworkDemo extends Network 
{
	public NetworkDemo() 
	{
		
	}
	
	@Override
	public void add(Hub hub) 
	{
		hubs.add(hub);
	}
	@Override
	public void add(Highway hwy) 
	{
		highways.add(hwy);
	}
	@Override
	public void add(Truck truck) 
	{
		trucks.add(truck);
	}
	@Override
	public void start() 
	{
		for(Hub hub:hubs)
		{
			 hub.start();
		}
		for(Truck truck:trucks) 
		{
			truck.start();
		}
	}
	
	@Override
	public void redisplay(Display disp) 
	{
		for(Truck truck:trucks) 
		{
			truck.draw(disp);
		}
		for(Hub hub:hubs)
		{
			 hub.draw(disp);
		}
		for(Highway hwy:highways) 
		{
			hwy.draw(disp);
		}
		
	}
	@Override
	public Hub findNearestHubForLoc(Location loc) 
	{
		Hub hu=this.hubs.get(0);
		for(Hub hub:hubs)
		{
			if(hub.getLoc().distSqrt(loc)<hu.getLoc().distSqrd(loc))
			{
				hu=hub;
			}
		}
		return hu;
		
	}
	ArrayList<Hub>hubs=new ArrayList<Hub>();
	ArrayList<Highway>highways=new ArrayList<Highway>();
	ArrayList<Truck>trucks=new ArrayList<Truck>();
	
	
	
}

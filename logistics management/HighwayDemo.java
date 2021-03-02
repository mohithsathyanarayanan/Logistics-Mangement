package demo19023;

import java.util.*;
import base.Truck;
import base.Highway;
class HighwayDemo extends Highway
{
	public HighwayDemo()
	{
		trucks = new ArrayList<>();
	}
	@Override
	public boolean hasCapacity()
	{
		if(getCapacity()<trucks.size())
			return false;
		else
			return true;
	}
	
	@Override
	public boolean add(Truck truck)
	{
		if(hasCapacity())
		{
			trucks.add(truck);
			return true;
		}
		else
			return false;
	}
	
	@Override
	public void remove(Truck truck)
	{
		trucks.remove(truck);
	}
	




	ArrayList<Truck>trucks;
}

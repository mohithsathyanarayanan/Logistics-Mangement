package demo19023;
import java.util.ArrayList;
import base.*;
class HubDemo extends Hub
{
	public HubDemo(Location loc)
	{
		super(loc);
		trucks=new ArrayList<>();
	}

	@Override
	public boolean add(Truck truck)
	{
		if(getCapacity()>trucks.size())
		{
			trucks.add(truck);
			return true;
		}
		else
			return false;
	}

	@Override
	protected void remove(Truck truck)
	{
		trucks.remove(truck);
	}

	@Override
	public Highway getNextHighway(Hub last, Hub dest)
	{
		Highway hway = super.getHighways().get(0);
		for(Highway h : super.getHighways())
		{
					if(h.getEnd().getLoc().distSqrd(dest.getLoc()) < nextHighway.getEnd().getLoc().distSqrd(dest.getLoc()))
					{    
						hway = h;
					}
               
        }
        return hway;
		//return null;
    }
	

	@Override
	protected void processQ(int deltaT)
	{
		for(Truck truck:trucks)
		{
				Highway hwy;
				Hub nextDest=Network.getNearestHub(truck.getDest());
				if(nextDest!=truck.getLastHub())
				{
					hwy=this.getNextHighway(truck.getLastHub(),nextDest);
					if(hwy.hasCapacity())
					{
						hwy.add(truck);
						truck.enter(hwy);
						remove(truck);
					}
				}
				else
					truck.setLoc(truck.getDest());
		}
	}
	

	ArrayList<Truck>trucks;

}

package demo19023;

import java.util.ArrayList;
import base.*;
public class FactoryDemo extends Factory
{
	/*public FactoryDemo(){
	}*/

	@Override
	public Network createNetwork()
	{
		return new NetworkDemo();
	}
	
	@Override
	public Highway createHighway()
	{
		return new HighwayDemo();
	}
	
	@Override
	public Hub createHub(Location location)
	{
		return new HubDemo(location);
	}

	@Override
	public Truck createTruck()
	{
		return new TruckDemo();
	}

}

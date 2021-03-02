package demo19023;
import base.*;
import java.util.ArrayList;
import java.lang.*;
import java.lang.Math;
class TruckDemo extends Truck
{
	@Override
	public Hub getLastHub()
	{
		return hwy.getStart();
	}

	@Override
	public void enter(Highway hwy)
	{
		hwy.add(this);
		this.hwy=hwy;
	}
	
	@Override
	public String getTruckName()
	{
		return "Truck19023";
	}
	@Override
	protected void update(int deltaT)
	{
		int flag=0;
		Truck truck;
		if(this.getloc().getX()==this.getSource().getX())
		{
			if(this.getloc().getY()==this.getSource().getY())
			{
				this.setLoc(Network.getNearestHub(this.getSource()).getLoc());
				Network.getNearestHub(this.getSorce().add(this));
				flag=1;
				//state="halt";
				return ;
			}
		}
		if(flag==0)//state.equals("halt"))
			return;
		int x1=truck.getStart().getLoc().getX();
		int y1=truck.getStart().getLoc().getY();
		int x2=truck.getEnd().getLoc().getX();
		int y2=truck.getEnd().getLoc().getY();
		double dist=Math.sqrt((((y2-y1)/(x2-x1))*((y2-y1)/(x2-x1)))+1);
		int speed=truck.getmaxSpeed();
		double distance=(speed*deltaT)/1000;
		double X1=distance*(1/dist);
		double Y1=distance*(Math.abs((y2-y1)/(x2-x1))/dist);
		if(Y1<1){
			X1=1/((y2-y1)/(x2-x1));
			Y1=1;
		}
		else if(X1<1){
			X1=1;
			Y1=(y2-y1)/(x2-x1);
		}
		else{
			Location loca=new Location(getLoc().getX()+((int)X1),getLoc().getY()+((int)Y1));
			int up_x=loca.getX();
			int up_y=loca.getY();
			if(up_y>=truck.getEnd().getLoc().getY()){
				if(up_x>=truck.getEnd().getLoc().getX()){
					Location locat=new Location(truck.getEnd().getLoc().getX(),truck.getEnd().getLoc().getY());
					setLoc(locat);
					truck.getEnd().add(this);
					truck.remove(this);
				}
			}
			else
				setLoc(loca);
		}
	}
	private Highway hwy;
}


package mypackage;

import java.util.ArrayList;



public class Layers {

	int area;
	int height; //height in mm
	int weight;  //weigth in gram
	ArrayList<Items> iteminthislayer = new ArrayList<Items>();  //arraylist of items in this layer
	public Layers()
	{
		area=0;
		height=0;
		weight=0;
		
	}
	public void setlayers(int a , int h, ArrayList<Items> item,int w)
	{
		area=a;
		height=h;
		iteminthislayer=item;
		weight=w;
	}
	
	public int getarea()
	{
		return this.area;
	}
	public int getweight()
	{
		return this.weight;
	}
	
	public int getheight()
	{
		return this.height;
	}
	
	public ArrayList<Items> getitems()
	{return this.iteminthislayer;
		
	}
}



import mypackage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Software {
	// Pallet pallet =new Pallet();
	
	public static void main(String argv[])    //main function of java
	{

	 //Items items[]= new  Items[5000];
	//for(int i=0;i<5000;i++) 
	//items[i]=new Items();           //this is done to remove null pointer exception
		ArrayList<Items> aListItems = new ArrayList<Items>();           //creating list of array for articles
		ArrayList<Layers> aListLayers = new ArrayList<Layers>(); 
	
	Order order1 = new Order();   //object of the order
	Packlist pack1= new Packlist(); //object of the packlist
	
//	pallet.setPalletDimensions();
	sortItems s =new sortItems();
	SortLayers sl=new SortLayers();
	Myalgorithm Alg= new Myalgorithm();                  
	 
	 order1.parseorderfile(aListItems);  //finding the articles in array list of items
	 	 
	s.sortbyheight(aListItems);               //sorting the items
	//s.sortbylength(aListItems);
	System.out.println("to see sorted or not");
	for( int k=0;k<aListItems.size();k++)
	{
	System.out.println("length of item "+aListItems.get(k).getheight());
	System.out.println("Id of item "+aListItems.get(k).getid());
	}
	
	aListLayers=Alg.CreateLayers(aListItems);    //this function creates  the layers of items and return the list of layers 
	 
	
	System.out.println("Number of Layers printed in Software class="+aListLayers.size());
	
	sl.sortlayersbyarea(aListLayers);
	 
	System.out.println("Number of Layers printed in Software class after sorting by area="+aListLayers.size());
int layernum;
ArrayList<Items> listitemsinlayer=new ArrayList<Items>();   
ArrayList<Items> finallistofitems=new ArrayList<Items>();   

//this loop scans the sorted layers by area and assigns z value to items
//each items in a layer have same height


int layerheigth=0;
int totalweight=0;
float areaoccupancy;
for(layernum=0;layernum<aListLayers.size();layernum++)   //outer loop for each layer
		 {
		//just to see the values
		 //System.out.println("Area of the layer"+aListLayers.get(layernum).getarea());
	    // System.out.println("height of the layer"+aListLayers.get(layernum).getheight());
	 
	     listitemsinlayer=aListLayers.get(layernum).getitems();     //getting the items of this layer
	 
	      System.out.println("number of items in this layer="+listitemsinlayer.size()); 
	      Items arrayitemsinlayer[]=listitemsinlayer.toArray(new Items[listitemsinlayer.size()]);  //converting to array from array list
	 	 //inner loop for items in each layer 	
	      layerheigth=layerheigth+aListLayers.get(layernum).getheight();  //layer height goes on increasing
		   
	      for(int i=0;i<listitemsinlayer.size();i++)        //all the items in each layer has same z position
		   {arrayitemsinlayer[i].setZposition(layerheigth); //see here
             
		   // System.out.println(listitemsinlayer.get(i).getbarcode());  //displays items of each layers
		    finallistofitems.add(arrayitemsinlayer[i]);
		   }//end of inner loop
	  //areaoccupancy=(float)aListLayers.get(layernum).getarea()/(Integer.parseInt(Order.palletle)*Integer.parseInt(Order.palletwid));
	  //System.out.println("Area occupancy of this layer"+areaoccupancy);
	  
	 
	  totalweight=totalweight+aListLayers.get(layernum).getweight();
	 }  //end of outer loop
	
	 pack1.createpacklist(finallistofitems,order1);  //send the items to create packlist XML file
	
	 System.out.println("size of Final list"+finallistofitems.size());
	 
	/* for(int i=0;i<finallistofitems.size();i++)
	 {
	 System.out.println("z position"+finallistofitems.get(i).getzposition());
	 }*/
	 
	
	 System.out.println("total weight of the items "+totalweight);
	 
	 if(totalweight>Integer.parseInt(Order.palletmaxload))
		  System.out.println("Maximum weight exceeds");
	 if(layerheigth>Integer.parseInt(Order.palletmaxHeight))
		  System.out.println("Maximum heigth exceeded");
	}
}



package mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Myalgorithm{
Pallet pallet=new Pallet(); 
public  Node root = new Node();
Node node1=new Node();
Node node2=new Node();
Node node=new Node();//creating the object of the pallet

public ArrayList<Layers> layerlist=new ArrayList<Layers>();   //array list for the layers 
public ArrayList<Items> remainingitems=new ArrayList<Items>(); //array list for the unfitted items
public ArrayList<Items> itemsinlayer=new ArrayList<Items>(); //array list for items in each layers
public ArrayList<Items> tempitems=new ArrayList<Items>();
public ArrayList<Integer> itemheightlist=new ArrayList<Integer>();


public ArrayList<Layers> CreateLayers(ArrayList<Items> aListItems)  //this function creates layers of items 
{ 
	int temparea=0;
	int tempweight=0;
    pallet.setPalletDimensions();
    Layers layer=new Layers();
	//layerlist.add(layer);  
	//int tempx,tempy,tempz,orientation,apx1,apy1,apz1,apx2,apy2,apz2;
	
	Items item[]=aListItems.toArray(new Items[aListItems.size()]);   // changing arrayLIST OF Items to the array
	 System.out.println("size of array"+item.length);
	
	  ((Node) root).RootNode();   //create root node which is the size of the pallet
	// item[0].setplaceposition(root.x,root.y);   //setting place position for the 1st item
	  
	
	  for(int j=0;j<aListItems.size();j++) 
		 itemheightlist.add(aListItems.get(j).getheight());
		 
	  HashSet<Integer> unique = new HashSet<Integer>(itemheightlist);
      System.out.println("unique elements"+unique.size());
     
     int checkcordinate=0; 
      Layers layer1=new Layers(); 
     
  
      for (Integer key : unique)   //counting number of items of same height
      {
    	   	  
    	  System.out.println( "Number of items of height "+key +"="+ Collections.frequency(itemheightlist, key));
      
      }
      
      
      int palletarea=Integer.parseInt(Order.palletle)*Integer.parseInt(Order.palletwid);
      int status=0;
      
      for (Integer key : unique)   //counting number of items of same height
      {  System.out.println( "Number of items of height "+key +"="+ Collections.frequency(itemheightlist, key));
	 
	     System.out.println("Arranging for heigth"+key);
    
    for(int j=0;j<aListItems.size();j++) // for all the items in  order continue finding nodes i.e space for each items
	   {
    	
		 if(item[j].ht==key)
		 {checkcordinate=0;
			status=0;
			 System.out.println("Incoming Number of item"+j);
			
		 node1=((Node)node).findnode(root, item[j].len, item[j].wid);  //find the node for the item
			 		 
		 if(node1!=null)    
		 //check whether node is null or not
		 {
	 node1=((Node) node1).splitnode(node1, item[j].len, item[j].wid);     // once the node is found create child nodes
	   
	   System.out.println("Root node X="+node1.x);
		System.out.println("Root node Y="+node1.y);
		System.out.println("Root node Length="+node1.length);
		System.out.println("Root node Used="+node1.used);
		
		
	for(int l=0;l<itemsinlayer.size();l++)
		{
		//to check if same cordinate is returned
		if(node1.x==itemsinlayer.get(l).getxposition()&& node1.y==itemsinlayer.get(l).getyposition())
			{
				checkcordinate=1;
				break;
			}
			
		}
		if(checkcordinate==0)
		{
		item[j].Calculatearea();  
		tempweight=tempweight+item[j].wt; //adding weight  of each items
		temparea=temparea+item[j].area;  //adding area of each items
		itemsinlayer.add(item[j]);
		if(item[j].len%2!=0)
			 item[j].len=item[j].len+1;
		if(item[j].wid%2!=0)
			item[j].wid=item[j].wid+1;
		item[j].setplaceposition(node1.x+item[j].len/2,node1.y+item[j].wid /2); 
		//setting place position for items
		
		layer1.setlayers(temparea, key,itemsinlayer,tempweight);
				float occupancy=((float)temparea/(float)palletarea);
		System.out.println("occupancy ="+occupancy+"area"+temparea);
		if(occupancy>0.9)  //add to the layer if the occupancy is greater than 0.8
		{
			status=1;
			layerlist.add(layer1); 	
			tempweight=0;
			temparea=0;
			 layer1=new Layers();
			 itemsinlayer=new ArrayList<Items>();
			 ((Node) root).RootNode();
		}  //end of if  occupancy
		//layer1.setlayers(temparea, key,itemsinlayer,tempweight);  //set area of the each layer and and height
					
			 }             //end of if null
		 else //if node cannot be found  then add items to remaining
		 {
			 System.out.println("Printing null");
			//Layers layer2=new Layers();
			// Layers layer2=new Layers();   
			 remainingitems.add(item[j]);  //no  node is found for this item so it is kept in remaining items
	//height , area , list of items in this layer, and weight of the layer is assigned		 
			//layer2.setlayers(temparea, item[i].ht,itemsinlayer,tempweight);
			 System.out.println("Area of the this layer printed in myalgorithm class"+temparea);
		
		 }//end  else
		 }  //end of check for cordiante
		 else 
			 remainingitems.add(item[j]);
		 } //end of if check for height
		 
		 }//end of INNER for LOOP
	if(status==0)
	{
    layerlist.add(layer1);
    itemsinlayer=new ArrayList<Items>(); //cleaning the itemsinlayer to zero again for next layer
	 tempweight=0;
	 temparea=0;
	 ((Node) root).RootNode();
	 layer1=new Layers();
	}
		 
	   }//end of OUTER for
   
	//layerlist.add(layer1);
	 System.out.println("Total numbers of layers"+layerlist.size());
	
	 System.out.println("Number of remaining items"+remainingitems.size());
	 return layerlist;
	 }  //end of the function
	 
	 
}//end of the class




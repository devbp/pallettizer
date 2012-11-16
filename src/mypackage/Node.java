package mypackage;

public class Node {
int x,y;                    //data of the node. each node contains coordinate x, y, used status, length , breadth and two other left and rigth nodes 
int used;
int length, width,check;
Pallet p=new Pallet();

Node rightnode;;
Node upnode;
public Node(){}
public void RootNode()
{
	p.setPalletDimensions();
	x=0;                      //this function is used to create root node only root node x and y coordinate is zero
	y=0;
	used=0;  
check=1;             //it is not used so it's used is 0
	length=p.lengt;     //root node   length is same as the pallet length
	width= p.width;     //root node width is same as the pallet width
	rightnode=null;     //rightnode and upnode of the root node is always null
	upnode=null;;
	System.out.println("Lenght of thepallet printed in class Node"+length);
	
}

public Node splitnode(Node croot, int itemlength, int itemwidth)  //this function splits the root node into rightnode and upnode
{
	Node rtnode=new Node();  //temporary objects 
	Node unode=new Node();
	//System.out.println("Root node X="+x);
//	System.out.println("Root node Y="+croot.y);
	//System.out.println("Root node Length="+croot.length);
//	System.out.println("Root node Used="+croot.used);
	 
	
	
	/*rtnode.x=croot.x+itemlength;  //new x coordinate of rightnode will be same as the length of yhe item 
	 rtnode.y=croot.y;     //new y coordinate will be same as root node y coordinate
	 rtnode.used=0;       //it is assigned as unused
	
	 rtnode.length=croot.length-itemlength;   //length of the rigth node is root length minus itemlength
	 rtnode.width=croot.width;  //width of right node is same as width of root node 
	 rtnode.rightnode=null;  //assign null to the rightnode of rtnode
	 rtnode.upnode=null;
	 
	 unode.x=croot.x;     //upper node x coordinate same as root node x coordinate
	 unode.y=croot.y+itemwidth; //y coordinate is the  width of the item
	 unode.used=0;
	 unode.width=croot.width-itemwidth;
	 unode.length=croot.length;
	 unode.upnode=null;
	 unode.rightnode=null;
	 
	croot.rightnode=rtnode;   //assign rtnode to right of the root node
	 croot.upnode=unode;        //assign upnode to up of the rootnode
	 //System.out.println("RigthChild node X="+croot.rightnode.x);
	 //System.out.println("RigthChild node Y="+croot.rightnode.y);
	 //System.out.println("UpChild node X="+croot.upnode.x);
	 //System.out.println("UpChild node Y="+croot.upnode.y);
	  
	 croot.used=1;                //now root node is used so it's status is changed to 1
	 // root.length=itemlength;   //root length is changed to item length
	 // root.width=itemwidth;  // root width is changed to item width
*/

	rtnode.x=croot.x+itemlength;  //new x coordinate of rightnode will be same as the length of yhe item 
	 rtnode.y=croot.y;     //new y coordinate will be same as root node y coordinate
	 rtnode.used=0;       //it is assigned as unused
	
	 rtnode.length=croot.length-itemlength;   //length of the rigth node is root length minus itemlength
	 rtnode.width=croot.width;  //width of right node is same as width of root node 
	 rtnode.rightnode=null;  //assign null to the rightnode of rtnode
	 rtnode.upnode=null;
	 
	 unode.x=croot.x;     //upper node x coordinate same as root node x coordinate
	 unode.y=croot.y+itemwidth; //y coordinate is the  width of the item
	 unode.used=0;
	 unode.width=croot.width-itemwidth;
	 unode.length=croot.length;
	 unode.upnode=null;
	 unode.rightnode=null;
	 
	croot.rightnode=rtnode;   //assign rtnode to right of the root node
	 croot.upnode=unode;        //assign upnode to up of the rootnode
	 //System.out.println("RigthChild node X="+croot.rightnode.x);
	 //System.out.println("RigthChild node Y="+croot.rightnode.y);
	 //System.out.println("UpChild node X="+croot.upnode.x);
	 //System.out.println(/"UpChild node Y="+croot.upnode.y);
	  
	 croot.used=1;                //now root node is used so it's status is changed to 1
	// croot.length=itemlength;   //root length is changed to item length
	 //croot.width=itemwidth;  // root width is changed to item width

return croot;
	

}


public Node findnode(Node croot, int itemlength, int itemwidth)  //this function finds appropriate node for the item
{ 

	
	int itemarea, rightnodearea,upnodearea,diffwithright,diffwithup;
	
//
	if (croot.used==1)      //if the node is used go to find another node and recursively call function findnode()
	 {       
			
							  // return findnode(croot.upnode, itemlength,itemwidth ,root);
		
						if(findnode(croot.rightnode, itemlength,itemwidth)!=null)
					return findnode(croot.rightnode, itemlength,itemwidth);
					
					else if(findnode(croot.upnode, itemlength,itemwidth)!=null)
						return(findnode(croot.upnode, itemlength,itemwidth));
		      //      return findnode(croot.upnode,itemlength,itemwidth);
			
					else return null;
	 }
	 

	 
		 
			
			//return  findnode(croot.rightnode,itemlength,itemwidth);
		/*if(croot.rightnode.length>itemlength)          //compare the difference in area between right and upnode with item area and search for best node 
		{
		System.out.println("X prinitng in finnodevalue at root node="+croot.upnode.y);
	    return findnode(croot.rightnode, itemlength,itemwidth);
	     }     //make right node as root node
	 else 
		 return  findnode(croot.upnode,itemlength,itemwidth);  //make left node as root node
		*/
 
 
	else if(croot.length>itemlength && croot.width>itemwidth)    //if length of root node is greater than item length then return item length
	//else if(croot.length>itemlength)         
	return croot;
 
	   else
	     return null;  //if appropriate node is not found return null

}
}

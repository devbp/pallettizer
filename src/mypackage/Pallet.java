package mypackage;

//creating object of the pallet

public  class Pallet {

	 int   lengt, width, maxload, maxheight;
	
	
	 public  Pallet()
	{ //String s;
	//s=Order.palletle;
	//System.out.println("printlenght in pallet class"+s);
	//lengt=Integer.parseInt(s); //converting string to integer
	//width=Integer.parseInt(Order.palletwid);
	//maxheight=Integer.parseInt(Order.palletmaxHeight);
	//maxload=Integer.parseInt(Order.palletmaxload);
	//lengt=400;
	//width=400;
		}
	
	public  void setPalletDimensions()
	{
		//lengt=l;
		// width=w;
		 //maxload=maxl;
		 //maxheight=maxw;
		lengt=Integer.parseInt(Order.palletle); //converting string to integer
		width=Integer.parseInt(Order.palletwid);
		maxheight=Integer.parseInt(Order.palletmaxHeight);
		maxload=Integer.parseInt(Order.palletmaxload);
		
	}
	
	public int getpalletarea()
	{
	return lengt*width;	
	}
	
	
}

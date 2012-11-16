
package mypackage;


// class for items in the order package

public class Items {
	   public int len,wid,ht,wt,id,olnum;  //length breadth in mm and weigth is in gram
		public String describe,barcode;
		 public int placex, placey, placez,orientation;
		 public int ap1x,ap1y, ap1z, ap2x, ap2y, ap2z;
       public int area;
		 
		 public Items(){}
		public Items(String des,int l, int b, int h, int w,int itemid,int oln, String barc)
		{
		id=itemid;
		len=l;
		wid=b;
		ht=h;
		wt=w;
		describe= des;
		barcode=barc;
		olnum=oln;
	
		}
		
		public int getzposition()
		{
		return this.placez;
		}
		
		public int getxposition()
		{
		return this.placex;
		}
		
		public int getyposition()
		{
		return this.placey;
		}
		
		
		public void setZposition(int z)
		{placez=z;
			
		}
		
		public void Calculatearea()
		{
			area=len*wid;
		}
		public void setplaceposition(int x,int y)
		{
			placex=x;
			placey=y;
			
			
		}
		
		public int getorderlinenum()
		{
		return this.olnum;
		}
		
		public String getbarcode()
		{
			return this.barcode;
		}
		public int getid()
		{
			return this.id;
		}
		
		 public int getarea()
		 {
			 return this.area;
		 }
		
		public int getlength()
		{
			return this.len;
			
		}
		
		public int getheight()
		{
			return this.ht;
		} 
		
		public int getwidth()
		{
			return this.wid;
		} 
		
		public int getweight()
		{
			return this.wt;
		}
		
		public String getdescription()
		{
			return this.describe;
		}
		
	
		
}

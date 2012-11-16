


package mypackage;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
//import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;


//this program parses the order xml file and extract the values of the orders from xml and create a arraylist of Items.

public class Order {
	int count=0;           //this variable counts number of items in the order files
	int l=0,b=0,h=0,w=0,odrlin,artid;
	String description;
	//public Pallet pallet1=new Pallet();
	public static String palletle,palletwid,palletmaxload,palletmaxHeight,orderid;
                                                    //global variables for pallet dimensions

		   public void parseorderfile(ArrayList<Items> aListItems) {
			   
		  try {
	 
			File fXmlFile = new File("smallorder.xml");
			DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
	         Element root =doc.getDocumentElement();
	                System.out.println("Root element :" + root.getNodeName());
		
NodeList pallet =doc.getElementsByTagName("Pallet");        //create Node List of Pallet
	             
	                
	 Element palletcontents= (Element) pallet.item(0);  //create Element for the Nodelist pallet
	 
	 String palletnum= palletcontents.getElementsByTagName("PalletNumber").item(0).getFirstChild().getNodeValue();
	 
	 String palletdes= palletcontents.getElementsByTagName("Description").item(0).getFirstChild().getNodeValue();
	 
	 System.out.println("Pallet Description"+palletdes);
	 
	 NodeList palletdim=palletcontents.getElementsByTagName("Dimensions");
	           Element  palletdimcontent= (Element) palletdim.item(0);
	          
	          
	           palletle= palletdimcontent.getElementsByTagName("Length").item(0).getFirstChild().getNodeValue();
	           System.out.println("Length of pallet"+palletle);
	      	 palletwid= palletdimcontent.getElementsByTagName("Width").item(0).getFirstChild().getNodeValue();
	      	  palletmaxload= palletdimcontent.getElementsByTagName("MaxLoadWeight").item(0).getFirstChild().getNodeValue();
	      	  palletmaxHeight= palletdimcontent.getElementsByTagName("MaxLoadHeight").item(0).getFirstChild().getNodeValue();
	      	
	      	 System.out.println("Pallet Length............"+palletwid);
	      	 // pallet1.Palletvalue(Integer.parseInt(palletle), Integer.parseInt(palletwid), Integer.parseInt(palletmaxHeight), Integer.parseInt(palletmaxload));
	      //pallet1.Palletvalue(100,200,300,300);
	      	 NodeList orderline=doc.getElementsByTagName("OrderLine");	//create nodelist of order line	 
		      System.out.println("number of Orderlines in Order XML=" + orderline.getLength());
	         
	        for( int orderlineno=0;orderlineno<orderline.getLength();orderlineno++)     //checking for all the orderlines in the XML file
	           {

	          Element thisorderline= (Element) orderline.item(orderlineno);  
	 	 String OrderLineNo=thisorderline.getElementsByTagName("OrderLineNo").item(0).getFirstChild().getNodeValue();
		 //System.out.println("Order Line Number="+ OrderLineNo);
          odrlin=Integer.parseInt(OrderLineNo);

	                       //taking  element of the orderline
	         NodeList Article = thisorderline.getElementsByTagName("Article");                    //create nodelist for article of that order line
	         System.out.println("number of Articles in this OrderLine=" + Article.getLength());
	         
		 for( int articlenum=0;articlenum<Article.getLength();articlenum++)              //checking for all articles in that orderline

	            {      Element thisarticle= (Element) Article.item(articlenum);
	                   String articleid=thisarticle.getElementsByTagName("ID").item(0).getFirstChild().getNodeValue();
	                   String d=thisarticle.getElementsByTagName("Description").item(0).getFirstChild().getNodeValue();
	                   description=d;
	                   String length=thisarticle.getElementsByTagName("Length").item(0).getFirstChild().getNodeValue();
	                     String width=thisarticle.getElementsByTagName("Width").item(0).getFirstChild().getNodeValue();
	                  String height=thisarticle.getElementsByTagName("Height").item(0).getFirstChild().getNodeValue();
	                  String weigth=thisarticle.getElementsByTagName("Weight").item(0).getFirstChild().getNodeValue();	
	                   System.out.println("ID of the article"+ articleid);
	                   System.out.println("Description"+ d);
	                System.out.println("Length"+ length);
	               System.out.println("Width"+ width);
	                System.out.println("Width"+ height);
                   artid=Integer.parseInt(articleid);
	             l=Integer.parseInt(length);   //finding the integer value
	            b=Integer.parseInt(width);
	            h=Integer.parseInt(height);
	            w=Integer.parseInt(weigth);

	                     int area=l*b;
	                     int   volume=l*b*h;
	             }   

	        NodeList Barcodes=thisorderline.getElementsByTagName("Barcode");   //Nodelist for barcodes of that orderlines
		
	        System.out.println("number of Barcodes in this orderline" + Barcodes.getLength());
	 
	    for( int i=0;i<Barcodes.getLength();i++)
	      {
	    	             //add the object to the arraylist
	       // item[count].len=l;
	        //item[count].wid=b;
	        //item[count].ht=h;

	     Element thisbarcode= (Element)Barcodes.item(i);
	      String barcodeval= thisbarcode.getFirstChild().getNodeValue();   //barcode of the articles
	     System.out.println("Barcode value"+ barcodeval);
	     
	     Items item = new Items(description,l,b,h,w,artid,odrlin,barcodeval);   //assign the values from the order xml file
	    	aListItems.add(item);  
	     count=count+1;
	      }
		
	   }
		  } catch (Exception e) {
			e.printStackTrace();
		  }  //end of try and catch


	for( int k=0;k<aListItems.size();k++)
	{
	System.out.println("length of item "+aListItems.get(k).getlength());
	System.out.println("Id of item "+aListItems.get(k).getid());
	}

	  } //endof parsexmlfile

}

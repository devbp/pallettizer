package mypackage;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
public class Packlist {
	
	//String x="10";
	 //String y="30";
	// String z="50";
	 	 
	
	 public    void createpacklist(ArrayList<Items> aListItems, Order order)
	    {
	 
	 //for( int k=0;k<order.count;k++)
	//System.out.println("length of item "+order.listoflength[k] );

	      try {
	 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Response");
			doc.appendChild(rootElement);
	       Attr attr = doc.createAttribute("index");
	      attr.setValue("1");
	      rootElement.setAttributeNodeNS(attr);

			Element PackList = doc.createElement("PackList");
			rootElement.appendChild(PackList);
	 
		
			Element OrderID = doc.createElement("OrderID");
			OrderID.appendChild(doc.createTextNode("1"));
			PackList.appendChild(OrderID);
	 
			Element PackPallets = doc.createElement("PackPallets");
			
			PackList.appendChild(PackPallets);
	 
					Element PackPallet = doc.createElement("PackPallet");
			
			    PackPallets.appendChild(PackPallet);
	 
			
			       Element PalletNumber = doc.createElement("PalletNumber");
	                 PalletNumber.appendChild(doc.createTextNode("1"));
	                 PackPallet.appendChild(PalletNumber);
	                Element Description = doc.createElement("Description");
	               Description.appendChild(doc.createTextNode("2x_jj_er"));
	                 PackPallet.appendChild(Description);


	             Element Dimensions =doc.createElement("Dimensions");
			
	               PackPallet.appendChild(Dimensions);		
	                Element Length =doc.createElement("Length");
			Length.appendChild(doc.createTextNode(Order.palletle));
	                Dimensions.appendChild(Length);		
	            
	                Element Width =doc.createElement("Width");
			Width.appendChild(doc.createTextNode(Order.palletwid));
	                Dimensions.appendChild(Width);	
	                Element MaxLoadHeight =doc.createElement("MaxLoadHeight");
			MaxLoadHeight.appendChild(doc.createTextNode(Order.palletmaxHeight));
	                Dimensions.appendChild(MaxLoadHeight);	
	                
	                Element MaxLoadWeight =doc.createElement("MaxLoadWeight");
	    			MaxLoadWeight.appendChild(doc.createTextNode(Order.palletmaxload));
	    	                Dimensions.appendChild(MaxLoadWeight);	
	    	                Element Overhang =doc.createElement("Overhang");                   	    
	    		             PackPallet.appendChild(Overhang);
	    		             
	    		             Element overhanglength =doc.createElement("Length");
	    		    			overhanglength.appendChild(doc.createTextNode("0"));
	    		    	                Overhang.appendChild(overhanglength);	
	    		    	                Element overhangwidth =doc.createElement("Width");
	    	    		    			overhangwidth.appendChild(doc.createTextNode("0"));
	    	    		    	                Overhang.appendChild(overhangwidth);	
	    		             
	    	      Element Packages =doc.createElement("Packages");                   	    
	             PackPallet.appendChild(Packages);
	             Items item[]=aListItems.toArray(new Items[aListItems.size()]); //converting arraylist to array
	     
	     int packseq=1;        
	             for(int packnumber=0;packnumber<aListItems.size();packnumber++)                          //here loop is runned number of times the items in the orderlist
	                 {
	            	 
	             //int temp=packnumber;
	             String packsequence = Integer.toString(packseq);
	              String strlength = Integer.toString(aListItems.get(packnumber).getlength());                  //convert integer to string
                  String strheigth = Integer.toString(aListItems.get(packnumber).getheight());
                  String strarticleid=Integer.toString(aListItems.get(packnumber).getid());
                  String strwidth=Integer.toString(aListItems.get(packnumber).getwidth());
                  String strweight=Integer.toString(aListItems.get(packnumber).getweight());
                  String strx= Integer.toString(item[packnumber].placex);
                  String stry= Integer.toString(item[packnumber].placey);
                  String strz= Integer.toString(item[packnumber].placez);
                  String barcode= (aListItems.get(packnumber).getbarcode());
                  Element Package =doc.createElement("Package");                   		     
	                Packages.appendChild(Package);

	                Element PackSequence =doc.createElement("PackSequence");
			PackSequence.appendChild(doc.createTextNode(packsequence));              //assign packsequence number
	                Package.appendChild(PackSequence);
	                packseq++;

	               // Element IncomingSequence =doc.createElement("IncomingSequence");
			//IncomingSequence.appendChild(doc.createTextNode(packsequence));
	       //Package.appendChild(IncomingSequence);	

	               // Element OrderLineNo =doc.createElement("OrderLineNo");
			//OrderLineNo.appendChild(doc.createTextNode("12"));
	              //  Package.appendChild(OrderLineNo);
	              
			//Element ParentLayer=doc.createElement("ParentLayer");
			//ParentLayer.appendChild(doc.createTextNode("1"));
	              //  Package.appendChild(ParentLayer);		
	               Element Article =doc.createElement("Article");                      
			//IncomingSequence.appendChild(doc.createTextNode("1"));
	                Package.appendChild(Article);	
	                Element ID =doc.createElement("ID");
			ID.appendChild(doc.createTextNode(strarticleid));
	                Article.appendChild(ID);	
		
	                Element description =doc.createElement("Description");    //I used small case for description because upper case is already defined 
			description.appendChild(doc.createTextNode(aListItems.get(packnumber).getdescription()));
	                Article.appendChild(description);

	               Element Type =doc.createElement("Type");
			Type.appendChild(doc.createTextNode("12"));
	                Article.appendChild(Type);

			Element length =doc.createElement("Length");
			length.appendChild(doc.createTextNode(strlength));
	                Article.appendChild(length);


	                Element width =doc.createElement("Width");
			width.appendChild(doc.createTextNode(strwidth));
	                Article.appendChild(width);
	                Element Height =doc.createElement("Height");
			Height.appendChild(doc.createTextNode(strheigth));
	                Article.appendChild(Height);

	               Element Weight =doc.createElement("Weight");
			Weight.appendChild(doc.createTextNode(strweight));
	                Article.appendChild(Weight);

	                Element Family =doc.createElement("Family");
			Family.appendChild(doc.createTextNode("12"));
	                Article.appendChild(Family);

	                //Element Rank =doc.createElement("Rank");
			//Rank.appendChild(doc.createTextNode("120"));
	               // Article.appendChild(Rank);
	               //Element MaxRankOnTop =doc.createElement("MaxRankTop");
			//MaxRankOnTop.appendChild(doc.createTextNode("1"));
	              //  Article.appendChild(MaxRankOnTop);

	               // Element HandlingAngles =doc.createElement("HandlingAngles");
		//	HandlingAngles.appendChild(doc.createTextNode("All"));
	           //     Article.appendChild(HandlingAngles);

	               // Element MinTorque =doc.createElement("MinTorque");
			//MinTorque.appendChild(doc.createTextNode("10"));
	          //      Article.appendChild(MinTorque);

			//Element MaxTorque =doc.createElement("MaxTorque");
			//MaxTorque.appendChild(doc.createTextNode("100"));
	             //   Article.appendChild(MaxTorque);

	                Element Barcode =doc.createElement("Barcode");
			         Barcode.appendChild(doc.createTextNode(barcode));
	                Package.appendChild(Barcode);
	                 
	                 

	                 Element PlacePosition =doc.createElement("PlacePosition");
			//Orientation.appendChild(doc.createTextNode("1"));
	                Package.appendChild(PlacePosition);

	                Element X =doc.createElement("X");                        //x position for the packet
			X.appendChild(doc.createTextNode(strx));    //assigning x position for the article
	                PlacePosition.appendChild(X);
	                Element Y =doc.createElement("Y");
			Y.appendChild(doc.createTextNode(stry));
	                PlacePosition.appendChild(Y);
	                Element Z =doc.createElement("Z");
			Z.appendChild(doc.createTextNode(strz));
	                PlacePosition.appendChild(Z);
	                Element Orientation =doc.createElement("Orientation");
		            Orientation.appendChild(doc.createTextNode("1"));
                   Package.appendChild(Orientation);


	              Element ApproachPoint1 = doc.createElement("ApproachPoint1");   //Approach point for the packet
	               Package.appendChild(ApproachPoint1);
	              Element AP1x =doc.createElement("X");
	               AP1x.appendChild(doc.createTextNode("0"));
	                ApproachPoint1.appendChild(AP1x);
	               Element AP1y =doc.createElement("Y");
	               AP1y.appendChild(doc.createTextNode("0"));
	                ApproachPoint1.appendChild(AP1y);
	               Element AP1z =doc.createElement("Z");
	               AP1z.appendChild(doc.createTextNode("0"));
	               ApproachPoint1.appendChild(AP1z);

	              Element ApproachPoint2 = doc.createElement("ApproachPoint2");
	               Package.appendChild(ApproachPoint2);
	              Element AP2x =doc.createElement("X");
	               AP2x.appendChild(doc.createTextNode("0"));
	                ApproachPoint2.appendChild(AP2x);
	              Element AP2y =doc.createElement("Y");
	               AP2y.appendChild(doc.createTextNode("0"));
	                ApproachPoint2.appendChild(AP2y);
	               Element AP2z =doc.createElement("Z");
	               AP2z.appendChild(doc.createTextNode("0"));
	               ApproachPoint2.appendChild(AP2z);

	             Element ApproachPoint3 = doc.createElement("ApproachPoint3");
	               Package.appendChild(ApproachPoint3);
	              Element AP3x =doc.createElement("X");
	               AP3x.appendChild(doc.createTextNode("0"));
	                ApproachPoint3.appendChild(AP3x);

	               Element AP3y =doc.createElement("Y");
	               AP3y.appendChild(doc.createTextNode("0"));
	                ApproachPoint3.appendChild(AP3y);
	               Element AP3z =doc.createElement("Z");
	               AP3z.appendChild(doc.createTextNode("0"));
	               ApproachPoint3.appendChild(AP3z);
	               
	               Element StackHeightBefore =doc.createElement("StackHeightBefore");
			         StackHeightBefore.appendChild(doc.createTextNode("0"));
	                Package.appendChild(StackHeightBefore);	
	}            //end of for loop

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("packlist.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		}  //end of the function

}

package mypackage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class sortItems {
	private static Comparator<Items> COMP1= new Comparator<Items>()
    {
    // This is where the sorting happens.
        public int compare(Items o1, Items o2)
        {
        	int codeDifference = o1.getheight() - o2.getheight();
        	     // If the height  is the same then sort on the length of the items.
        		        if (codeDifference == 0)
        		        return (o1.getlength() - o2.getlength());
        		        else
        		        return codeDifference;
        }
    };
    
    private static Comparator<Items> COMP2= new Comparator<Items>()
    {
    // This is where the sorting happens.
        public int compare(Items o1, Items o2)
        {
            return o1.getlength() - o2.getlength();
        }
    };
	
    
    public void sortbylength(ArrayList<Items> aListitems)
    {
	for(int i=0;i<aListitems.size();i++)
		System.out.println("ArrayList of item's height before sort " + aListitems.get(i).getheight());
	
Collections.sort(aListitems,COMP2);
Collections.reverse(aListitems);  //reversing the sorted order

for(int i=0;i<aListitems.size();i++)
System.out.println("ArrayList of item's height after sort " + aListitems.get(i).getlength());
}
	
           
	public void sortbyheight(ArrayList<Items> aListitems)
           {
//ArrayList<Items> aListitems = new ArrayList<Items>(Arrays.asList(items));
// for(int i=0;i<aListitems.size();i++)
//System.out.println("Array list"+aListitems.get(i).getheight());
		for(int i=0;i<aListitems.size();i++)
			System.out.println("ArrayList before sort " + aListitems.get(i).getheight());
		
Collections.sort(aListitems,COMP1);
Collections.reverse(aListitems);  //reversing the sorted order

for(int i=0;i<aListitems.size();i++)
System.out.println("ArrayList after sort " + aListitems.get(i).getheight());
}
}
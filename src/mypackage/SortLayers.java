package mypackage;


import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortLayers {
	public SortLayers(){}
	private static Comparator<Layers> COMP1= new Comparator<Layers>()
    {
    // This is where the sorting happens.
        public int compare(Layers o1, Layers o2)
        {
        	int areadifference = o1.getarea() - o2.getarea();
        	           		        return areadifference;
        }
    };
    private static Comparator<Layers> COMP2= new Comparator<Layers>()
    {
    // This is where the sorting happens.
        public int compare(Layers o1, Layers o2)
        {
        	int areadifference = o1.getweight() - o2.getweight();
        	           		        return areadifference;
        }
    };
    
    public void sortlayersbyweight(ArrayList<Layers> aListlayers)
    {

	for(int i=0;i<aListlayers.size();i++)
		System.out.println("ArrayList before sort " + aListlayers.get(i).getweight());
	Collections.sort(aListlayers,COMP2);
 Collections.reverse(aListlayers);  //reversing the sorted order

for(int i=0;i<aListlayers.size();i++)
System.out.println("ArrayList after sort " + aListlayers.get(i).getweight());
}
    
           
	public void sortlayersbyarea(ArrayList<Layers> aListlayers)
           {

		for(int i=0;i<aListlayers.size();i++)
			System.out.println("ArrayList of Area of layers before sort " + aListlayers.get(i).getarea());
		Collections.sort(aListlayers,COMP1);
        Collections.reverse(aListlayers);  //reversing the sorted order

for(int i=0;i<aListlayers.size();i++)
System.out.println("ArrayList Area of layer after sort " + aListlayers.get(i).getarea());
}
}
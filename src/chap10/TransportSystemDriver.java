/* Westley W Williams
 *  CIS 2212-800 Java I FlexPace
 *  Assignment 08 - Classes, Objects, UML Diagram
 *  Finished 3/8/21
 */

package chap10;

import java.util.Scanner;

//the normal structure of the air transport system today is such that pilots communicate with air traffic controllers
//However, this program simulates what the beginning version of an autonomous air traffic controller system might look like
//In other words, what if pilots, rather than communicating with an air traffic controllers to gain clearance to enter an airspace
//(which is typically not class E or C or D or G airspace, but rather class B and A airspace)
//what if pilots had computers in their aircraft that communicated with computers within the airspace they wish to enter?
//that way, their clearance comes from a computer that manages all the aircraft arriving and departing that respective airspace.
//This would free up pilots to fly the plane. This is a crude beginning of what may be possible. Hopefully, it demonstrates
//sufficiently the techniques used up until this point.
public class TransportSystemDriver {

	// beginning of main method
	public static void main(String[] args) {
		// I commented out lines 24 and 25, as, it appeared in the homework problem that
		// we could use user input, but, did not have to.
		// Scanner mainScanner = new Scanner(System.in);
		// System.out.println("Input number of airspace layers");

		// test the validate method by placing a "-" sign in front of one of the
		// arguments of the below variables (line 19-21) as an example
		// an error message should be output in the console if an argument is below 0.
		// Again, the validate method only let's us know if our input is below zero.
		int numberOfLayersB = 3;// typically there are three layers in class B airspace, each layer stacked like
		// the layers of a wedding cake (upside down)
		int[] layerRadiusB = { 4, 10, 20 };// radius' of class B airspace. They are probably different in real life as
		// most are custom, I believe.
		int[] layerHeightB = { 2500, 5000, 10000 };// height of class B airspace. I think they are mostly customized in
		// real life, so these values may not reflect actual values.

		// first populated object
		// class is reserved in Java. So, instead of using classB as an airspace
		// variable name, I used zoneB.
		Airspace zoneB = new Airspace(numberOfLayersB, layerRadiusB, layerHeightB);

		int numberOfLayersC = 2;// typical amount of layers of class C airspace.
		int[] layerRadiusC = { 5, 10 };// typical radius' for class c airspace for the smaller and larger radius.
		int[] layerHeightC = { 1200, 4000 }; // These numbers are in feet above the airport elevation

		// second populated object
		Airspace zoneC = new Airspace(numberOfLayersC, layerRadiusC, layerHeightC);

		int numberOfLayersD = 1;// typically there's only one layer of class D airspace
		int[] layerRadiusD = { 4 };// typical radius class D airspace
		int[] layerHeightD = { 2500 };// the typical height in feet of class D airspace

		// third populated object
		Airspace zoneD = new Airspace(numberOfLayersD, layerRadiusD, layerHeightD);

		int numberOfLayersE = 2;// we assume that this airspace area is class E (Echo airspace)
		int[] layerRadiusE = { 2, 4 };// radius 2 at the lower layer and 4 at the higher layer
		int[] layerHeightE = { 700, 1200 };// height 700 and then height 1200

		// fourth populated object
		Airspace zoneE = new Airspace(numberOfLayersE, layerRadiusE, layerHeightE);

		int numberOfLayersMOA = 1;// we assume that this airspace area is a military operations area (MOA)
		int[] layerRadiusMOA = { 25 };// radius of 25 nm
		int[] layerHeightMOA = { 3000 };// altitude of 3000 ft

		// fifth populated object
		Airspace zoneMOA = new Airspace(numberOfLayersMOA, layerRadiusMOA, layerHeightMOA);

		int numberOfLayersTFR = 1;// we assume that this airspace area is a temporary flight restriction
		int[] layerRadiusTFR = { 10 };// radius of 10 nm
		int[] layerHeightTFR = { 3000 };// 3000 ft above ground level (AGL)

		// sixth populated object
		Airspace zoneTFR = new Airspace(numberOfLayersTFR, layerRadiusTFR, layerHeightTFR);

		Airspace zoneZ = new Airspace();// there is no such thing as class Z ( or zone C airspace in the case of this
		// program), but maybe in the new digital world there will be.
		Airspace zoneY = new Airspace();// there is also no such thing as class Y (zone Y), however, again, maybe there
		// will be new types of airspace in the future. In this program's case, we can
		// call it zone Y.

		// define the arrays that will go into zoneZ setters
		int[] layerRadiusZ = { 20 };
		int[] layerHeightZ = { 2500 };
		// populate zoneZ object using setters
		zoneZ.setNumberOfLayers(1);
		zoneZ.setAirspaceLayerRadius(layerRadiusZ);
		zoneZ.setAirspaceLayerHeight(layerHeightZ);

		// define the arrays that will go into zoneY setters
		int[] layerRadiusY = { 30 };
		int[] layerHeightY = { 5000 };

		// populate zoneY with the above arrays using setter methods
		zoneY.setNumberOfLayers(1);
		zoneY.setAirspaceLayerRadius(layerRadiusY);
		zoneY.setAirspaceLayerRadius(layerHeightY);
		// this is the only airspace where I executed the clearedToEnter method.
		// in the output below, you can see where zoneY airspace is cleared for entry when the other airspace objects are not. 
		zoneY.setClearedToEnter();
		

		// print to the console these objects
		System.out.println(zoneB);
		System.out.println(zoneC);
		System.out.println(zoneD);
		System.out.println(zoneE);
		System.out.println(zoneMOA);
		System.out.println(zoneTFR);
		System.out.println(zoneZ);
		System.out.println(zoneY);

	}// end of main method

}

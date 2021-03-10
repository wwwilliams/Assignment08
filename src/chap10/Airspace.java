package chap10;

import java.util.Arrays;

public class Airspace {
	// this link will help one understand many of the concepts below as it relates
	// to airspace:
	// https://www.faasafety.gov/gslac/ALC/course_content.aspx?cID=42&sID=505&preview=true
	private int numberOfLayers; // every block of airspace has a certain amount of layers
	// airspace looks like an upside down wedding cake. If that wedding cake only
	// has one layer, like class D airspace, then airspaceLayers = 1.
	// do a quick search for class B airspace and one can see what I mean by an
	// "upside down wedding cake."
	// airspace typically has 1 to 3 layers, but no more than 3. Again, these layers
	// are like the layers of a wedding cake. Each layer will be of a different
	// radius. It is structured like this for aircraft arrivals and departures
	// (they'll fly at an angle to earth's surface).
	private int[] airspaceLayerRadius;// class D airspace, for example, usually has a radius of 4 NM.
	private int[] airspaceLayerHeight = { 0, 0, 0 };// class D airspace, for example, typically extends from the surface
	// to 2,500 feet above the airport elevation. We can have three layers, however, as in the case of class B airspace.
	// therefore, I set an initial value with three fields.
	private boolean airspaceCleared;
	private static int numberOfAirspaceObjects;

	// default constructor one. I'm using class A airspace as the default, since it
	// doesn't really change that I know of.
	public Airspace() {
		numberOfAirspaceObjects++;// this is static, and it counts every time an object is created. So, it tells
		// us the quantity of airspace objects.
	}

	// constructor two, overloaded constructor
	public Airspace(int numberOfLayers, int[] airspaceLayerRadius, int[] airspaceLayerHeight) {
		// set the number of layers of an airspace object
		// set the radius of the airspace layer (IN NAUTICAL MILES!)
		// set the height of the airspace layer (in nautical miles)
		// remember, each layer will likely be of a different radius.
		this.numberOfLayers = numberOfLayers;
		this.airspaceLayerRadius = airspaceLayerRadius;
		this.airspaceLayerHeight = airspaceLayerHeight;

		this.airspaceCleared = false;// we assume when the object is created, this is first set to false, so no
		// clearance yet.
		numberOfAirspaceObjects++;// this is static, and it counts every time an object is created. So, it tells
		// us the quantity of airspace objects.

		// call the method to validate parameters.
		validateParameters(numberOfLayers);
		validateParameters(airspaceLayerRadius, airspaceLayerHeight);

	}

	// this returns the number of layers of the particular airspace area
	public int getNumberOfLayers() {
		return this.numberOfLayers;
	}

	// this setter function sets the number of layers of the specific airspace area
	public void setNumberOfLayers(int numberOfLayers) {
		this.numberOfLayers = numberOfLayers;
	}

	// pass an integer into the getter function, which serves as the index
	public int getAirspaceLayerRadius(int layerOfAirspace) {
		return this.airspaceLayerRadius[layerOfAirspace];
	}

	// set, with an array parameter, the radius' of each airspace layer
	public void setAirspaceLayerRadius(int[] airspaceLayerRadius) {
		this.airspaceLayerRadius = airspaceLayerRadius;
	}

	// pass an integer into the getter function, which serves as the index
	public int getAirspaceLayerHeight(int layerOfAirspace) {
		return airspaceLayerHeight[layerOfAirspace];
	}

	// set the airspace layer heights using an array parameter
	public void setAirspaceLayerHeight(int[] airspaceLayerHeight) {
		this.airspaceLayerHeight = airspaceLayerHeight;
	}

	// we just simply change the airspaceCleared data field to true.
	// pilots need a clearance to enter some types of airspace, such as Class A or
	// class B airspace.
	public void setClearedToEnter() {
		this.airspaceCleared = true;
	}

	// calculate the total volume of the airspace area. This is done by adding the
	// volume of the bottom layer to the volume of the top layer.
	// this really is just a method to demonstrate a calculation rather than simply
	// printing something to the screen.
	// It's probably not a method a pilot would need, but it may be a method a
	// computer could use to calculate the density of airplanes inside airspace
	// and therefore to compute a clearance or no clearance until traffic congestion
	// goes down.
	public double calculateVolume() {
		final double conversionFactor = 0.000164579; // I'll use this conversion number to convert the feet of
		// airspaceLayerHeight to nautical miles. Otherwise, I can't
		// calculate the volume correctly.
		// initialize the volume of airspace to 0. Later, this will serve as the total
		// volume of the airspace
		double volumeOfAirspace = 0;// total volume of airspace, initialized
		// create a loop to loop through the layers, and adding the volume of each
		// layer.
		for (int i = 0; i < numberOfLayers; i++) {
			// I'm calculating the volume of this object's airspace.

			// access Pi, which is 3.14, through the Math class. no object creation
			// necessary since PI is public.
			volumeOfAirspace += Math.PI * (airspaceLayerRadius[i] * airspaceLayerRadius[i])
					* (airspaceLayerHeight[i] * conversionFactor);
		}

		return volumeOfAirspace; // and return the total volume of the airspace.

	}

	// this method tells us if we have been cleared to enter airspace or not.
	// if we have not been cleared, the system will print "not cleared to enter
	// airspace."
	// otherwise, the system prints "cleared to enter."
	// in order to enter class B airspace in the current air transportation system,
	// a pilot must receive a clearance to enter.
	public void airspaceClearance() {
		if (this.airspaceCleared) {
			System.out.println("Yes, we are cleared to enter the airspace");
		} else {
			System.out.println("No, we are not cleared to enter");

		}
	}

	@Override
	public String toString() {
		// I used source -> generate toString to automatically display this code below
		// (internet source:
		// https://stackoverflow.com/questions/2653268/what-are-the-shortcut-to-auto-generating-tostring-method-in-eclipse)
		// this also coincides with the advice offered in assignment 7
		String str1 = "Airspace data fields: " + "\n[Number of layers= " + numberOfLayers + ", "
				+ (airspaceLayerRadius != null ? "Airspace layer radius=" + Arrays.toString(airspaceLayerRadius) + ", "
						: "")
				+ (airspaceLayerHeight != null
				? "Airspace layer height=" + Arrays.toString(airspaceLayerHeight) + " feet, \n"
						: "")
				+ "Airspace cleared? " + airspaceCleared + "," + " Total airspace objects in operation "
				+ numberOfAirspaceObjects + ",";
		// don't confuse the units of NM (nautical miles) in the string with units of
		// nanometers.
		String str2 = String.format(" Volume of this airspace object: %,.3f NM^3]\n", calculateVolume());

		// add str1 and str2 and return it. I divided them up so I could use
		// String.format to change the decimal places of the volume.
		return str1 + str2;

		// helpful piece of code to draw upon is shown below
		/*
		 * return String.format( "Country Name: %s" + "\n\tTotal Population: %,d" +
		 * "\n\tPopulation per Square Mile: %,.2f" + "\n\tPopulation per State: %,.2f",
		 * this.nameOfCountry, calculateTotalPopulation(),
		 * calculatePopulationPerSquareMile(), calculatePopulationPerState());
		 */
	}// end of toString overriding method

	// this method doesn't return anything, it just validates (or rather fails to
	// validate) parameters entered in the driver method
	// by outputting text notifying user of a lack of validation if a negative
	// number is entered.
	// one could probably create a public data field that stores true or false on
	// the validation. In this case, I won't be using it so I did not.
	public void validateParameters(int... argsOfAirspaceParameters) {
		for (int i : argsOfAirspaceParameters) {
			if (i < 0) {
				System.out.println("Error, a parameter entered from the class of the main method is below zero.");
			}
		}

	}// end of validation method

	// overloaded validation method
	public void validateParameters(int[]... argsOfAirspaceParameters) {
		// i and j are simply loop variables
		// the parameter, argsOfAirspaceParameters, is an array of arrays
		// therefore, I have to loop through each number (with j) of each array (with i)
		for (int i = 0; i < argsOfAirspaceParameters.length; i++) {
			for (int j = 0; j < argsOfAirspaceParameters[i].length; j++) {
				if (argsOfAirspaceParameters[i][j] < 0) {
					System.out.println("Error, a parameter entered from the class of the main method is below zero.");
				}
			}
		}

	}// end of validation method

}

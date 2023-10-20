package com.skilldistillery.jets.app;

public class Snippet {
	private List<Planet> readPlanets(String fileName) {
			// Declare outside the try/catch.
			List<Planet> planets = new ArrayList<>();
			try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
				String line;
				while ((line = bufIn.readLine()) != null) {
					String[] planetRecord = line.split(", ");
					String name = planetRecord[0];
					long orbit = Long.parseLong(planetRecord[1]);
					int diameter = Integer.parseInt(planetRecord[2]);
					Planet p = new Planet(name, orbit, diameter);
					// System.out.println(p);
					planets.add(p);
				}
			} catch (IOException e) {
				System.err.println(e);
			}
			return planets;
		}
}


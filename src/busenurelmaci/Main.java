package busenurelmaci;

import java.util.Random;

public class Main {

	public static void main(String[] args) throws Exception {
		MapInterface map = new Map();
		ZoneCounterInterface area = new ZoneCounter();
		CreateRandomMap(map);
		area.init(map);
		map.show();
		System.out.println("\nTotal Area : " + area.solve());

	}

	public static void CreateRandomMap(MapInterface map) throws Exception {
		
		Random random = new Random();
		int randomWidth = random.nextInt(5) + 30;
		int randomHeight = random.nextInt(5) + 20;
		int randomAmountOfBorders = random.nextInt(5) + 7;

		Dimension dim = new Dimension(randomWidth, randomHeight);
		map.setSize(dim);
		for (int i = 0; i <= randomAmountOfBorders; i++) {
			int randomBorderPointX, randomBorderPointY;
			do {
				randomBorderPointX = (random.nextInt((randomWidth + 1)));
				randomBorderPointY = (random.nextInt(randomHeight + 1));

			} while (map.isBorder(randomBorderPointX, randomBorderPointY));

			int hypotenus = (int) Math.sqrt(Math.pow(randomWidth, 2) + Math.pow(randomHeight, 2));
			int borderHorizontal = random.nextInt(5) + 30;
	        int borderVertical = random.nextInt(5) + 30;
	        int borderDiagonal = random.nextInt(5) + 30;
	        
	        if (borderHorizontal % 2 == 0) {
	        	borderHorizontal = 1;
			} else {
				borderHorizontal = -1;
			}

			if (borderVertical % 2 == 0) {
				borderVertical = 1;
			} else {
				borderVertical = -1;
			}
			
			if (borderDiagonal % 2 == 0) {
				borderDiagonal = 1;
			} else {
				borderDiagonal = -1;
			}
	             
	        if (borderDiagonal == 1) {
				for (int j = 0; j <= hypotenus; j++) {
					map.setBorder(randomBorderPointX + j * borderHorizontal,
							randomBorderPointY + j * borderVertical);
				}
			} else if (i % 2 == 0) { 
				for (int m = 0; m <= randomBorderPointY; m++) {
					map.setBorder(randomBorderPointX, randomBorderPointY + m * borderVertical);
				}
			} else {
				for (int m = 0; m <= randomBorderPointX; m++) { 
					map.setBorder(randomBorderPointX + m * borderHorizontal, randomBorderPointY);
				}
			}
	        
	       
		}
	}
}

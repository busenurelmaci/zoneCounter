package busenurelmaci;

public class Map implements MapInterface {

	Dimension dim;
	boolean[][] mapArray;

	@Override
	public void setSize(Dimension dim) {
		mapArray = new boolean[dim.getWidth()][dim.getHeight()];
		for (int i = 0; i < dim.getWidth(); i++) {
			for (int j = 0; j < dim.getHeight(); j++) {
				mapArray[i][j] = false;
			}
		}
	}

	@Override
	public Dimension getSize() {
		if (mapArray.length <= 0) {
			dim = new Dimension(0, 0);
		} else {
			dim = new Dimension(mapArray.length, mapArray[0].length);
		}
		return dim;
	}

	@Override
	public void setBorder(int x, int y) throws Exception {
		if (x >= 0 && x < mapArray.length && y >= 0 && y < mapArray[0].length) {
			mapArray[x][y] = true;
		}
	}

	@Override
	public void clearBorder(int x, int y) throws Exception {
		mapArray[x][y] = false;
	}

	@Override
	public boolean isBorder(int x, int y) throws Exception {
		dim = getSize();
		if (dim.CheckWrithin(x, y)) {
			return mapArray[x][y];
		} else {
			return true;
		}
	}

	@Override
	public void show() {
		
		System.out.print(System.lineSeparator());
		for (int j = 0; j < (mapArray.length) + 2; j++) {
			System.out.print("X");
		}
		System.out.print(System.lineSeparator());
		for (int i = 0; i < mapArray[0].length; i++) {
			System.out.print("X");
			for (int j = 0; j < mapArray.length; j++) {
				if (mapArray[j][i] == true) {
					System.out.print("X");
				} else
					System.out.print(" ");
			}
			System.out.println("X");
		}
		for (int j = 0; j < (mapArray.length) + 2; j++) {
			System.out.print("X");
		}
		System.out.print(System.lineSeparator());
	}
}

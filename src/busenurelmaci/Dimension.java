package busenurelmaci;

public class Dimension {

	private int width;
	private int height;

	public Dimension() {
	}

	public Dimension(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean CheckWrithin(int x, int y) {
		return (x >= 0 && x < width && y >= 0 && y < height);
	}

	public int total() {
		int tot = width * height;
		return tot;
	}
}

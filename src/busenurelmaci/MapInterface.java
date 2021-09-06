package busenurelmaci;

public interface MapInterface {
	
	public void setSize(Dimension dim);
	public Dimension getSize();
	public void setBorder(int x, int y) throws Exception;
	public void clearBorder(int x, int y) throws Exception;
	public boolean isBorder(int x, int y) throws Exception;
	public void show();
}

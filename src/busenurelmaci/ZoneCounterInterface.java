package busenurelmaci;

public interface ZoneCounterInterface {
	
	public void init(MapInterface map) throws Exception;
	public int solve() throws Exception;
	public void search(int x, int y, int width, int height, boolean visited[]) throws Exception;
}

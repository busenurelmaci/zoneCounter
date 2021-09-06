package busenurelmaci;

public class ZoneCounter implements ZoneCounterInterface {

	Dimension dim;
	boolean[] visited;
	MapInterface m_map;

	@Override
	public void init(MapInterface map) throws Exception {
		m_map = map;
	}

	@Override
	public int solve() throws Exception {
		if (m_map.equals(null)) {
			return 0;
		}
		dim = m_map.getSize();
		visited = new boolean[dim.total()];
		int count = 0;
		dim = m_map.getSize();

		for (int i = 0; i < dim.getWidth(); i++) {
			for (int j = 0; j < dim.getHeight(); j++) {
				visited[j * dim.getWidth() + 1] = false;
			}
		}
		for (int i = 0; i < dim.getWidth(); i++) {
			for (int j = 0; j < dim.getHeight(); j++) {
				if (m_map.isBorder(i, j) == false && visited[j * dim.getWidth() + i] == false) {
					search(i, j, dim.getWidth(), dim.getHeight(), visited);
					count++;
				}
			}
		}
		return count;
	}

	@Override
	public void search(int x, int y, int width, int height, boolean[] visited) throws Exception {
		if (!m_map.isBorder(x, y) && !visited[y * width + x] && dim.CheckWrithin(x, y)) {
			visited[y * width + x] = true;
			search(x - 1, y, width, height, visited);
			search(x + 1, y, width, height, visited);
			search(x, y - 1, width, height, visited);
			search(x, y + 1, width, height, visited);
		}
	}
}

package min.md.service;

import java.util.List;

import min.md.domain.Board;

public interface BoardService {
	
	List<Board> list();
	void insert(Board board);
	Board read(long seq);
	void update(Board board);
	void delete(long seq);

}

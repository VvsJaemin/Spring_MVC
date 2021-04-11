package min.md.service;

import java.util.List;

import min.md.domain.Board;
import min.md.domain.Criteria;

public interface BoardService {
	
	List<Board> getList();
	List<Board> getList(Criteria cri);	
	void insert(Board board);
	Board read(long seq);
	void update(Board board);
	void delete(long seq);

}
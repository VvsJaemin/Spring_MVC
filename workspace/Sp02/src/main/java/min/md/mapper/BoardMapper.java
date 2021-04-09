package min.md.mapper;

import java.util.List;


import min.md.domain.Board;


public interface BoardMapper {
	
	List<Board> list();
	Board read(long seq);
	void insert(Board board);
	void update(Board board);
	void delete(long seq);
}

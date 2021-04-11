package min.md.mapper;

import java.util.List;


import min.md.domain.Board;
import min.md.domain.Criteria;


public interface BoardMapper {
	
	List<Board> getList();
	List<Board> getListWithPaging(Criteria cri);
	Board read(long seq);
	void insert(Board board);
	void update(Board board);
	void delete(long seq);
}

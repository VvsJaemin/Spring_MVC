package min.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import min.md.domain.Board;
import min.md.mapper.BoardMapper;

@Log4j
@Service

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	public List<Board> list() {
		// TODO Auto-generated method stub
		return boardMapper.list();
	}

	@Override
	public void insert(Board board) {
		// TODO Auto-generated method stub

		boardMapper.insert(board);
	}


	@Override
	public void delete(long seq) {
		// TODO Auto-generated method stub

		boardMapper.delete(seq);
	}

	@Override
	public Board read(long seq) {
		// TODO Auto-generated method stub
		return boardMapper.read(seq);
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		boardMapper.update(board);
	}





}

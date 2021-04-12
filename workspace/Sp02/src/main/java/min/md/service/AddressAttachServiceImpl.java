package min.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import min.md.domain.AddressAttachVO;
import min.md.mapper.AddressAttachMapper;

@Log4j
@Service
public class AddressAttachServiceImpl implements AddressAttachService {
	
	@Autowired
	
	private AddressAttachMapper mapper;
	
	@Override
	public void insert(AddressAttachVO vo) {
		// TODO Auto-generated method stub
		mapper.insert(vo);
	}

	@Override
	public void delete(long seqf) {
		// TODO Auto-generated method stub
		mapper.delete(seqf);
	}

	@Override
	public List<AddressAttachVO> findBySeq(long seq) {
		// TODO Auto-generated method stub
		return mapper.findBySeq(seq);
	}

}

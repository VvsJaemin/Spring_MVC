package min.md.service;

import java.util.List;

import min.md.domain.AddressAttachVO;

public interface AddressAttachService {
	
	void insert(AddressAttachVO vo);
	void delete(long seqf);
	List<AddressAttachVO> findBySeq(long seq);

}

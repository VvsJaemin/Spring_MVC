package min.md.mapper;

import java.util.List;

import min.md.domain.Address;
import min.md.domain.AddressAttachVO;

public interface AddressAttachMapper {
	

	void insert(AddressAttachVO vo);
	void delete(long seqf);
	List<AddressAttachVO> findBySeq(long seq);

}

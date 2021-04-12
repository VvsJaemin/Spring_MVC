package min.md.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import min.md.domain.Address;

public interface AddressMapper {
	
	List<Address> list();
	void insert(@Param ("name")String name, @Param("addr") String addr,Address address, ArrayList<MultipartFile> files);
	void delete(long seq);

}

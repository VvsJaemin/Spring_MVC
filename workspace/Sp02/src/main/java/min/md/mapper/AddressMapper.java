package min.md.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import min.md.domain.Address;
import min.md.domain.AddressFile;

public interface AddressMapper {

	List<Address> list();

	void insertSelectKey(Address address);

	void insertF(AddressFile addressFile);

	List<AddressFile> fileListForRemove(long seq);

	void delete(long seq);

}

package min.md.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import min.md.domain.Address;
import min.md.domain.AddressFile;

public interface AddressService {

	List<Address> list();
	ArrayList<AddressFile> insert(Address address, ArrayList<MultipartFile> files);
	void removeFiles(long seq);
	
	void delete(long seq);
	void removeFiles(); // 업로드

}

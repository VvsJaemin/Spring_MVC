package min.md.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import min.md.domain.Address;

public interface AddressService {

	List<Address> list();
	void insert(String name, String addr, Address address, ArrayList<MultipartFile> files);
	void delete(long seq);

}

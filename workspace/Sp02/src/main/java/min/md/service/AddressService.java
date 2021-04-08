package min.md.service;

import java.util.List;

import min.md.domain.Address;

public interface AddressService {

	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
}

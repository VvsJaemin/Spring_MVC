package min.md.mapper;

import java.util.List;

import min.md.domain.Address;
 // DAO
public interface AddressMapper {
	
	List<Address> list();
	void insert(Address address);
	void delete(long seq);

}

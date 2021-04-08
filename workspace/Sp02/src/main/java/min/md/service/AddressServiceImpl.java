package min.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import min.md.dao.AddressDao;
import min.md.domain.Address;

@Log4j
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired // setter injection
	private AddressDao addressDao;

	@Override
	public List<Address> listS() {

		return addressDao.list();
	}

	@Override
	public void insertS(Address address) {
		// TODO Auto-generated method stub
		addressDao.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		// TODO Auto-generated method stub
		addressDao.delete(seq);
	}

}

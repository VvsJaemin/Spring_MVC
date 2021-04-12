package min.md.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import min.md.domain.Address;
import min.md.mapper.AddressMapper;

@Log4j
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired // setter injection
	private AddressMapper mapper;

	@Override
	public List<Address> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}


	@Override
	public void delete(long seq) {
		// TODO Auto-generated method stub
		mapper.delete(seq);
	}

	@Override
	public void insert(String name, String addr,Address address, ArrayList<MultipartFile> files) {
		// TODO Auto-generated method stub
		mapper.insert(name, addr, address, files);
	}

}

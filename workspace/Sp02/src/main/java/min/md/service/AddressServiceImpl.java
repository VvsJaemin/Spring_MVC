package min.md.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import min.md.domain.Address;
import min.md.domain.AddressFile;
import min.md.filesetting.Path;
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
	
	
	ArrayList<AddressFile> uploadedFileList;
	@Transactional
	@Override
	public ArrayList<AddressFile> insert(Address address, ArrayList<MultipartFile> files) {
		// 1. 주소록 데이터를 insert

		mapper.insertSelectKey(address);
		log.info("#address.getSeq() : " + address.getSeq());
		

		// 2. 파일들을 업로딩
		ArrayList<AddressFile> uploadedFileList = new ArrayList<AddressFile>();
		for (MultipartFile file : files) {
			String ofname = file.getOriginalFilename();
			if (ofname != null)
				ofname = ofname.trim();
			if (ofname.length() != 0) {
				AddressFile addressFile = saveStore(file);
				uploadedFileList.add(addressFile);
				if (addressFile != null) {
					// 3. 파일 데이터들을 insert
					addressFile.setSeq(address.getSeq());
					mapper.insertF(addressFile);
				}

			}

		}
		
		return uploadedFileList;
	}

	private AddressFile saveStore(MultipartFile file) {
		// TODO Auto-generated method stub
		String ofname = file.getOriginalFilename();
		int idx = ofname.lastIndexOf("."); // 파일이름과 확장자를 분리 .기준으로
		String ofheader = ofname.substring(0, idx); // aaa
		String ext = ofname.substring(idx); // .txt\
		long ms = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder(); // 저장소
		sb.append(ofheader);
		sb.append("_");
		sb.append(ms);
		sb.append(ext);
		// ofheader + "-" + ms + ext...
		// + 연산을 할경우 계속 중간 단계 객체를 생성하기에 append(창고를 사용(성능 저하)
		String saveFileName = sb.toString(); // 실제 변경된 파일(클라이언트가 올린 파일) 이름을 DB에 저장

		long fsize = file.getSize();
		// 원래의 파일 이름
		log.info("#ofname : " + ofname + ", saveFileName : " + saveFileName + ",fsize: " + fsize);

		boolean flag = writeFile(file, saveFileName);
		// 파일 먼저 올리고 db sql 쿼리 맵핑
		if (flag) {
			log.info("#업로드 성공" + saveFileName);
			return new AddressFile(-1L, ofname, saveFileName, fsize, -1L);
			// dao에서 saveFileName, ofname, fsize 정보를 넘기는 메소드 호출
		} else {
			log.info("#업로드 실패");
			return null;
		}

	}

	private boolean writeFile(MultipartFile file, String saveFileName) {
		// TODO Auto-generated method stub

		File dir = new File(Path.FILE_STORE); // 저장소 경로 객체 생성

		if (!dir.exists())
			dir.mkdirs();

		FileOutputStream fos = null;
		try {
			byte data[] = file.getBytes();
			fos = new FileOutputStream(Path.FILE_STORE + saveFileName);
			fos.write(data);
			fos.flush();

			return true;
		} catch (IOException io) {
			return false;
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException io) {

			}
		}

	}

	@Override
	public void removeFiles() {
		for(AddressFile addressFile : uploadedFileList) {
//			log.info("#AddressServiceImpl removeFiles() addressFile : " + addressFile);
			File f = new File(Path.FILE_STORE, addressFile.getSfname());
			if(f.exists()) f.delete();
		}
		
	}

	@Override
	public void removeFiles(long seq) {
		// TODO Auto-generated method stub
		List<AddressFile> listFiles = mapper.fileListForRemove(seq);
		
		for(AddressFile addressFile : listFiles) {
			File f = new File(Path.FILE_STORE, addressFile.getSfname());
			if(f.exists()) f.delete();
		}
	
	}



}

package min.md.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import min.md.filesetting.Path;

@Service
@Log4j
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public String saveStore(MultipartFile file) {
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
			log.info("#업로드 성공");
			//dao에서 saveFileName, ofname, fsize 정보를 넘기는 메소드 호출
		} else {
			log.info("#업로드 실패");
		}

		return Path.FILE_STORE + saveFileName;
	}

	@Override
	public boolean writeFile(MultipartFile file, String saveFileName) {
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

}

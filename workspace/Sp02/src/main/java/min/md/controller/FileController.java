package min.md.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import min.md.filesetting.Path;
import min.md.service.FileUploadService;
import oracle.jdbc.proxy.annotation.Post;

@Log4j
@Controller
@RequestMapping("file")
@AllArgsConstructor
public class FileController {

	private final FileUploadService service; // AutoInjection

	@GetMapping("form.do")
	public String form() {

		return "file/form";

	}

	@PostMapping("upload.do")
	public String upload(@RequestParam String name, MultipartFile file) {

		log.info("#name : " + name + " #File : " + file);

		String ofname = file.getOriginalFilename(); // 원래 파일을 업로드

		if (ofname != null)
			ofname = ofname.trim();

		if (ofname.length() != 0) {
			String url = service.saveStore(file);
			log.info("#업로드 된 url : " + url);
		}
		return "redirect:list.do";

	}

	@GetMapping("list.do")
	public ModelAndView fileList() {
		File fstore = new File(Path.FILE_STORE);

		if (!fstore.exists())
			fstore.mkdirs();

		File files[] = fstore.listFiles();

		return new ModelAndView("file/list", "files", files);

	}

	@GetMapping("del.do")
	public String del(@RequestParam String fname) {

		File file = new File(Path.FILE_STORE, fname);

		if (file.exists())
			file.delete();

		return "redirect:list.do";
	}

	@GetMapping("form_mt.do")
	public String formMt() {

		return "file/form_mt";
	}

	@PostMapping("upload_mt.do")
	public String uploadMt(@RequestParam ArrayList<MultipartFile> files) {

		for (MultipartFile file : files) {
			String ofname = file.getOriginalFilename(); // 원래 파일을 업로드

			if (ofname != null)
				ofname = ofname.trim();

			if (ofname.length() != 0) {
				String url = service.saveStore(file);
				log.info("#업로드 된 url : " + url);
			}
		}

		return "redirect:list.do";
	}

	@GetMapping("download.do")
	public ModelAndView download(@RequestParam String fname) {

		File file = new File(Path.FILE_STORE, fname);

		if (file.exists()) {
			return new ModelAndView("fileDownloadView", "downloadFile", file);
		} else {
			return new ModelAndView("redirect:list.do");
		}

	}

}

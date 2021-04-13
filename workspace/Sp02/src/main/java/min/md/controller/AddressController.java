package min.md.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;
import min.md.domain.Address;
import min.md.domain.AddressFile;
import min.md.service.AddressService;

@Log4j
@Controller
@RequestMapping("/address/*")
public class AddressController {
	@Autowired
	private AddressService addressService;

	@GetMapping("list.do")
	public ModelAndView list() {
		List<Address> list = addressService.list();
		/*
		 * ModelAndView mv = new ModelAndView(); mv.setViewName("address/list"); //View
		 * mv.addObject("list", list); //Model
		 */
		ModelAndView mv = new ModelAndView("address/list", "list", list);

		return mv;
	}

	@GetMapping("write.do")
	public String write() {
		return "address/write";
	}

	@PostMapping("write.do")
	public String write(Address address, @RequestParam ArrayList<MultipartFile> files) {
		ArrayList<AddressFile> uploadedFileList = null;

		try {
			uploadedFileList = addressService.insert(address, files);
		} catch (Exception ex) {
			log.info("#AddressController write ex :  " + uploadedFileList); //null
			addressService.removeFiles();
		}

		return "redirect:list.do";
	}

	@GetMapping("del.do")
	public String delete(long seq) {
		addressService.removeFiles(seq);// 업로드된 파일들 제거 
		addressService.delete(seq); // DB 데이터 제거 

		return "redirect:list.do";
	}
}

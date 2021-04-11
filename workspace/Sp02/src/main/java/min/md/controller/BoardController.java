package min.md.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;
import min.md.domain.Board;
import min.md.domain.Criteria;
import min.md.domain.PageDTO;
import min.md.service.BoardService;
import oracle.jdbc.proxy.annotation.Post;
@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("list.do")
	public String list(Criteria cri, Model model) {

		log.info("list : " + cri);
		model.addAttribute("list", boardService.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri,123));
//		ModelAndView mv = new ModelAndView("board/list", "list", list);

		return "board/list";
	}

	@GetMapping("write.do")
	public String write() {

		return "board/write";
	}

	@PostMapping("write.do")
	public String write(Board board) {

		boardService.insert(board);

		return "redirect:list.do";

	}

	@GetMapping("content.do")
	public ModelAndView read(long seq) {

		Board board = boardService.read(seq);

		ModelAndView mv = new ModelAndView("board/content", "board", board);

		return mv;

	}

	@GetMapping("update.do")
	public ModelAndView update(long seq) {

		Board board = boardService.read(seq);

		ModelAndView mv = new ModelAndView("board/update", "board", board);

		return mv;

	}

	@PostMapping("update.do")
	public String update(Board board) {

		boardService.update(board);

		return "redirect:list.do";
	}

	@GetMapping("del.do")

	public String delete(long seq) {

		boardService.delete(seq);

		return "redirect:list.do";
	}
}

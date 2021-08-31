package com.mhs.s1.bankbook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo (plain Old Java Object) 순수한 자바 클래스, 외부 라이브러리 상속x
	
	@RequestMapping(value = "bankbookList.do", method = RequestMethod.GET)
	public ModelAndView list(Integer [] num, ModelAndView mv) {
		for(Integer i : num) {
			System.out.println(i);
		}
		System.out.println("bankbook list");
		
		//ModelAndView mv = new ModelAndView ();
		mv.setViewName("bankbook/bankbookList");
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public String Select(@RequestParam(defaultValue = "1", value = "n") Integer num, String name, Model model) {
		System.out.println("Value : "+num);
		System.out.println("Name : "+name);
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("BookName");
		model.addAttribute("dto", bankBookDTO);
		model.addAttribute("test", "jun");
		return "bankbook/bankbookSelect";
	}
	
	@RequestMapping("bankbookInsert.do")
	public String insert(BankBookDTO bankBookDTO, Integer [] num) {
		System.out.println(bankBookDTO.getBookName());
		System.out.println("insert");
		return "redirect:../";
	}

}

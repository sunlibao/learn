package com.shares.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.front.vo.Customer;
import com.shares.dto.SharesDTO;
import com.shares.service.SharesService;
import com.shares.vo.SharesVO;
import com.util.Contans;

@Controller
public class SharesController {
	
	@Autowired
	private SharesService sharesService;
	
	
	/**
	 * 股票首页
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/sharesIndex")
	public ModelAndView sharesIndex(HttpServletRequest request){
		
		
		ModelAndView modelAndView = new ModelAndView("shares/sharesIndex");
		
		
		return modelAndView;
	}
	
	
	/**
	 * 我的股票
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/myShares")
	public ModelAndView myShares(HttpServletRequest request){
		
		HttpSession session =	request.getSession();
		
		Customer customer =  (Customer) session.getAttribute(Contans.LoginCustomer);
		ModelAndView modelAndView = null;
		if(customer != null){
			List<SharesDTO> list = sharesService.findMyShares(customer.getId());
			modelAndView = new ModelAndView("shares/myShares");
			modelAndView.addObject("sharesList", list);
		}else{
			modelAndView = new ModelAndView("shares/sharesIndex");
		}
		
		
		
		
	
		
		
		return modelAndView;
	}

}

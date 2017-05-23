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
import com.shares.vo.UserSharesRecordVO;
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
	
	
	/**
	 * 查看单个股票的操作记录
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/findShareOption")
	public ModelAndView findShareOption(HttpServletRequest request){
		
		//用户股票id
		String userSharesId = request.getParameter("userSharesId");
		//股票id
		String shareId = request.getParameter("shareId");
		
		
		
		ModelAndView modelAndView =   new ModelAndView("shares/userSharesOptionList");
		
		List<UserSharesRecordVO> userSharesOptionList =  this.sharesService.findShareOptionByUserSharesId(userSharesId);
		
		//查询股票基本信息
		SharesVO sharesVO = this.sharesService.findShareById(shareId);
		
		modelAndView.addObject("userSharesOptionList", userSharesOptionList);
		modelAndView.addObject("sharesVO", sharesVO);
		modelAndView.addObject("userSharesId", userSharesId);
		
		
		return modelAndView;
	}
	
	
	
	/**
	 * 查看单个股票的操作记录
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/toAddSharesOption")
	public ModelAndView toAddSharesOption(HttpServletRequest request){
			
		//用户股票id
		String userSharesId = request.getParameter("userSharesId");
		
		ModelAndView modelAndView =   new ModelAndView("shares/userSharesOptionAdd");
		modelAndView.addObject("userSharesId", userSharesId);
		
		
		return modelAndView;
	}
	

	/**
	 * 保存用户操作
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/saveUserOption")
	public ModelAndView saveUserOption(HttpServletRequest request){
			
		//用户股票id
		String userSharesId = request.getParameter("userSharesId");
		String price = request.getParameter("price");
		String dealOption = request.getParameter("dealOption");
		String dealOptionTime = request.getParameter("dealOptionTime");
		String note = request.getParameter("note");
		
		Integer result = this.sharesService.saveUserOptionRecord(userSharesId,price,dealOption,dealOptionTime,note);
		
		ModelAndView modelAndView =   new ModelAndView("shares/userSharesOptionAdd");
		modelAndView.addObject("msg", "保存成功");
		modelAndView.addObject("userSharesId", userSharesId);
		
		return modelAndView;
	}
	
	
	

}

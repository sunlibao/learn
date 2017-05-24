package com.shares.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	private static final Logger logger =LoggerFactory.getLogger(SharesController.class);
	
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
	 * 系统股票列表
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/shares")
	public ModelAndView shares(HttpServletRequest request){
		
		
		List<SharesVO> sharesList = this.sharesService.findSharesList();
		
		ModelAndView modelAndView = new ModelAndView("shares/shares");
		modelAndView.addObject("sharesList", sharesList);
		
		return modelAndView;
	}
	
	/**
	 * 跳转到添加系统股票页面
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/toAddShares")
	public ModelAndView toAddShares(HttpServletRequest request){
		
		ModelAndView modelAndView = new ModelAndView("shares/sharesAdd");
		return modelAndView;
		
	}
	
	
	/**
	 * 系统股票列表
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/saveShares")
	public ModelAndView saveShares(HttpServletRequest request){
		
		//股票编号
		String code = request.getParameter("code");
		//股票名称
		String name = request.getParameter("name");
		//股票简介
		String note = request.getParameter("note");
		
		logger.info("name="+name);
		
		Integer result = this.sharesService.saveShares(code,name,note);
		
		ModelAndView modelAndView = new ModelAndView("shares/sharesAdd");
		
		
		return modelAndView;
	}
	
	/**
	 * 删除系统股票
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/deleteShares")
	public ModelAndView deleteShares(HttpServletRequest request){
		
		//系统股票id
		String sharesId = request.getParameter("sharesId");
		
		Integer result = this.sharesService.deleteShares(sharesId);
		
		ModelAndView modelAndView = new ModelAndView("redirect:shares");
		
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
	 * 我的股票
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/toAddUserShares")
	public ModelAndView toAddUserShares(HttpServletRequest request){
		
		HttpSession session =	request.getSession();
		
		Customer customer =  (Customer) session.getAttribute(Contans.LoginCustomer);
		ModelAndView modelAndView = null;
		if(customer != null){
			modelAndView = new ModelAndView("shares/userSharesAdd");
		}else{
			modelAndView = new ModelAndView("shares/sharesIndex");
		}
		
		return modelAndView;
	}
	
	/**
	 * 保存用户
	 * @param request 请求字符串
	 * @return
	 */
	@RequestMapping("shares/saveUserShares")
	public ModelAndView saveUserShares(HttpServletRequest request){
		
		HttpSession session =	request.getSession();
		Customer customer =  (Customer) session.getAttribute(Contans.LoginCustomer);
		//股票编号
		String sharesCode = request.getParameter("sharesCode");
		
		ModelAndView modelAndView = null;
		if(customer != null){
			Integer result = this.sharesService.saveUserShares(customer.getId(),sharesCode);
			
			modelAndView = new ModelAndView("shares/userSharesAdd");
		}else{
			modelAndView = new ModelAndView("shares/sharesIndex");
		}
		
		return modelAndView;
	}
	
	
	/**
	 * 删除用户股票
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/deleteUserShares")
	public ModelAndView deleteUserShares(HttpServletRequest request){
		
		//系统股票id
		String id = request.getParameter("id");
		
		Integer result = this.sharesService.deleteUserShares(id);
		
		ModelAndView modelAndView = new ModelAndView("redirect:myShares");
		
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
		modelAndView.addObject("shareId", shareId);
		
		
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
	
	
	
	/**
	 * 保存用户操作
	 * @param request
	 * @return
	 */
	@RequestMapping("shares/deleteUserSharesOption")
	public ModelAndView deleteUserSharesOption(HttpServletRequest request){
			
		//用户股票id
		String id = request.getParameter("id");
		String userSharesId = request.getParameter("userSharesId");
		String shareId = request.getParameter("shareId");
		
		Integer result = this.sharesService.deleteUserSharesOptionById(id);
		
		
		ModelAndView modelAndView = new ModelAndView("redirect:findShareOption");
		modelAndView.addObject("userSharesId", userSharesId);
		modelAndView.addObject("shareId", shareId);
		
		return modelAndView;
	}
	
	

}

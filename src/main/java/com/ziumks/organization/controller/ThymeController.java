package com.ziumks.organization.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ziumks.organization.model.Organization;
import com.ziumks.organization.service.OrganizationService;

@Controller
//@RequestMapping("/orgs")
public class ThymeController {

	@Autowired
	private OrganizationService orgService;
	
	@RequestMapping("list")
	public ModelAndView notice(HttpServletRequest request, Organization organization) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		// 목록 갯수
		int totalCnt = this.orgService.selectOrganizationListCnt(request, organization);
		
		// 목록
		List<Organization> list = null;
		if (totalCnt > 0) {
			list = this.orgService.selectOrganizationList(request, organization);
		}
		
		mv.addObject("totalCnt", totalCnt);
		mv.addObject("list", list);
		mv.addObject("organization", organization);
		
		return mv;
	}
}

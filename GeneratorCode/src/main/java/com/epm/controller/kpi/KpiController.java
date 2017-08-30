package com.epm.controller.kpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.epm.service.kpi.KpiServcie;

/**
 * kpi管理
 * @author sunlibao
 *
 */
@Controller
public class KpiController {
	
	@Autowired
	private KpiServcie kpiServcie;

}

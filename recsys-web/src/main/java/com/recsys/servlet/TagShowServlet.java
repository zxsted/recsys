package com.recsys.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.recsys.base.bean.TagBean;
import com.recsys.service.TagShowService;
import com.recsys.vo.ShowResultVo;

public class TagShowServlet extends HttpServlet{

	private static final long serialVersionUID = 4205968341137393483L;
	private static Logger logger = LoggerFactory.getLogger("TagShowServlet");
	
	private TagShowService<TagBean> tagShowService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext servletContext = this.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		this.tagShowService = (TagShowService<TagBean>) ctx.getBean("tagShowService");
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		long start = System.currentTimeMillis();
		res.setCharacterEncoding("UTF-8");
		String tag = req.getParameter("tag");
		int pageSize = req.getParameter("pageSize") == null ? 10 : Integer.parseInt(req.getParameter("pageSize").toString());
		int currentPage = req.getParameter("currentPage") == null ? 1 : Integer.parseInt(req.getParameter("currentPage").toString());
		int sortType = req.getParameter("sortType") == null ? 1 : Integer.parseInt(req.getParameter("sortType").toString());
		int refresh = req.getParameter("refresh") == null ? 0 : Integer.parseInt(req.getParameter("refresh").toString());

		String jsonResult = null;
		if (jsonResult == null || jsonResult.isEmpty() || refresh == 1) {
			long queryStart = System.currentTimeMillis();
			ShowResultVo<TagBean> tagResult = this.tagShowService.query(tag, 1, currentPage, pageSize);
			long queryEnd = System.currentTimeMillis();
			if (queryEnd - queryStart > 100) {
				logger.warn("solrReq=[{}]", (queryEnd - queryStart) + "@"
						+ ("tag=" + tag + "&pageSize=" + pageSize + "&currentPage=" + currentPage + "&sortType=" + sortType));
			}
			JSONObject json = new JSONObject();
			if (tagResult != null && !tagResult.isNull()) {
				Map<String, Object> pageMap = new HashMap<String, Object>();
				pageMap.put("currentPage", currentPage);
				pageMap.put("totalPage", tagResult.getTotalPage());
				pageMap.put("totalRecord", tagResult.getTotalNum());
				pageMap.put("pageSize", pageSize);
				json.element("page", pageMap);

				List<com.recsys.base.bean.TagBean> tagList = tagResult.getTagList();
				Collection<Long> coll = new ArrayList<Long>();
				for (TagBean bean : tagList) {
					coll.add(bean.getId());
				}
				json.element("obj", coll);
			} else {
				Map<String, Object> pageMap = new HashMap<String, Object>();
				pageMap.put("currentPage", currentPage);
				pageMap.put("totalPage", 0);
				pageMap.put("totalRecord", 0);
				pageMap.put("pageSize", pageSize);
				json.element("page", pageMap);
				json.element("obj", new ArrayList<Long>());
			}
			res.getWriter().print(json.toString());
		} else {
			res.getWriter().print(jsonResult);
		}
		long end = System.currentTimeMillis();
		if (end - start > 200) {
			logger.warn("req.getRequestURL=[{}]", (end - start) + "@" + ("tag=" + tag + "&pageSize=" + pageSize + "&currentPage=" + currentPage + "&sortType=" + sortType + "&refresh=" + refresh));
		}
	}

	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("currentPage", 1);
		pageMap.put("totalPage", 100);
		pageMap.put("totalRecord", 101);
		pageMap.put("pageSize", 2);
		json.element("page", pageMap);
		System.out.println(json.toString());
	}
}

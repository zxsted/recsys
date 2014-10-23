<%@page import="java.util.List"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.recsys.service.TagShowService"%>
<%@page import="com.recsys.vo.ShowResultVo"%>
<%@page import="com.recsys.base.bean.TagBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	String tag=request.getParameter("tag")==null?"":request.getParameter("tag").trim();
	int pageNo = request.getParameter("pageNo")==null?1:Integer.parseInt(request.getParameter("pageNo").trim());
	int pageSize = request.getParameter("pageSize")==null?20:Integer.parseInt(request.getParameter("pageSize").trim());
%>

<html>
<body>
<form action="tagShow.jsp" name="form1">
<table width="100%">
<tr><td width="50%">
输入：<input type="text" name="tag" value="<%=tag%>" ><br />
页码：<input type="text" name="pageNo" value="<%=pageNo %>" ><br />
每页条数：<input type="text" name="pageSize" value="<%=pageSize %>" ><br />
</td>
<td>
<input type="submit" value="查询">
</td></tr>
</table>
</form>
<hr />
<%
if(!tag.isEmpty()){
	ServletContext servletContext = request.getSession().getServletContext();
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);

	final TagShowService<TagBean> tagShowService = (TagShowService<TagBean>) ctx.getBean("tagShowService");

	ShowResultVo<TagBean> tagResult = tagShowService.query(tag, 1, pageNo, pageSize);
	int totalPage = tagResult.getTotalPage();
	long totalNum = tagResult.getTotalNum();
	int currentPage = tagResult.getPageNO();
%>
	<h3>当前第<%=currentPage %>页&nbsp;&nbsp;&nbsp;&nbsp;每页<%=pageSize%>&nbsp;&nbsp;&nbsp;&nbsp;共：<%=totalPage%>页&nbsp;&nbsp;&nbsp;&nbsp;共找到：<%=totalNum %>条记录&nbsp;&nbsp;&nbsp;&nbsp;</h3>

	<table width="100%" border="1">
	<tr bgcolor="#55aa55"><td width="15%">id</td><td width="15%">标签词</td></tr>
<%
	List<TagBean> tagList = tagResult.getTagList();
	int count = 0;
	for(TagBean bean : tagList){
		if(count++%2==0){
%>
			<tr bgcolor="#fa9f22"><td><%=bean.getId() %></td><td><%=bean.getName()%></td></tr>
<%	
		}else{
%>
			<tr><td><%=bean.getId() %></td><td><%=bean.getName()%></td>></tr>
<%
		}
	}
%>
	</table>
<%
}
%>
</body>


</html>


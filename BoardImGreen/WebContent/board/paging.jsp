<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 

<%!
	public Integer toInt(String x){
		int a = 0;
		try{
			a = Integer.parseInt(x);
		}catch(Exception e){}
		return a;
	}
%>
<%
	int pageno = toInt(request.getParameter("pageno"));
	if(pageno<1){//현재 페이지
		pageno = 1;
	}
	int total_record = (int)request.getAttribute("recordCount");
	int page_per_record_cnt = 10;  //페이지 당 레코드 수
	int group_per_page_cnt =5;   										

	int record_end_no = pageno*page_per_record_cnt;				
	int record_start_no = record_end_no-(page_per_record_cnt-1);
	if(record_end_no>total_record){
		record_end_no = total_record;
	}
										   
										   
	int total_page = total_record / page_per_record_cnt + (total_record % page_per_record_cnt>0 ? 1 : 0);
	if(pageno>total_page){
		pageno = total_page;
	}

	

// 	현재 페이지(정수) / 한페이지 당 보여줄 페지 번호 수(정수) + (그룹 번호는 현제 페이지(정수) % 한페이지 당 보여줄 페지 번호 수(정수)>0 ? 1 : 0)
	int group_no = pageno/group_per_page_cnt+( pageno%group_per_page_cnt>0 ? 1:0);
  
	
	int page_eno = group_no*group_per_page_cnt;		
//		현재 그룹 끝 번호 = 현재 그룹번호 * 페이지당 보여줄 번호 
//	ex) 	70		=	14	*	5
	int page_sno = page_eno-(group_per_page_cnt-1);	
// 		현재 그룹 시작 번호 = 현재 그룹 끝 번호 - (페이지당 보여줄 번호 수 -1)
//	ex) 	66	=	70 - 	4 (5 -1)
	
	if(page_eno>total_page){
//	   현재 그룹 끝 번호가 전체페이지 수 보다 클 경우		
		page_eno=total_page;
//	   현재 그룹 끝 번호와 = 전체페이지 수를 같게
	}
	
	int prev_pageno = page_sno-group_per_page_cnt; 
		
	int next_pageno = page_sno+group_per_page_cnt;

	if(prev_pageno<1){
	
		prev_pageno=1;

	}
	if(next_pageno>total_page){
	
		next_pageno=total_page/group_per_page_cnt*group_per_page_cnt+1;

	}


%>


<a href="BoardServlet?command=board_list&pageno=1">[맨앞으로]</a>
<a href="BoardServlet?command=board_list&pageno=<%=prev_pageno%>">[이전]</a> 
<%for(int i =page_sno;i<=page_eno;i++){%>
	<a href="BoardServlet?command=board_list&pageno=<%=i %>">
		<%if(pageno == i){ %>
			[<%=i %>]
		<%}else{ %>
			<%=i %>
		<%} %>
	</a> 
<%--	콤마	 --%>	
	<%if(i<page_eno){ %>
		,
	<%} %>
<%} %>
 
<a href="BoardServlet?command=board_list&pageno=<%=next_pageno%>" >[다음]</a>
<a href="BoardServlet?command=board_list&pageno=<%=total_page %>">[맨뒤로]</a>
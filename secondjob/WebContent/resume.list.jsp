<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.ResumeEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="part/head.jsp" />
</head>


<body>

    <jsp:include page="part/header.jsp" />

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-8 column">
				<table class="table">
				<thead>
					<tr>
						 						<th>
							name
						</th>						<th>
							person_information_id
						</th>
						<th>修改</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
			<%
				ResumeEntity entity = new ResumeEntity();
				
				List<ResumeEntity> list = (List<ResumeEntity>)request.getAttribute("list");
				if(list==null){
					list = new ArrayList<ResumeEntity>();
				}
				
				for(ResumeEntity e : list){
					
			%>
				<tr>
											<td>
							<%=e.getName() %>
						</td>
						<td>
							<%=e.getPerson_information_id() %>
						</td>
						<td><a href='resume!update.action?id=<%=e.getId() %>' >修改</a></td>
						<td><a href='resume!delete.action?id=<%=e.getId() %>' >删除</a></td>

				</tr>
			<%		
					
				}
				
			%>

				</tbody>

	</table>
            </div>

            <div class="col-md-4 column">
                <jsp:include page="part/slider.jsp" />
            </div>
        </div>
    </div>
    <jsp:include page="part/footer.jsp" />
</body>
</html>

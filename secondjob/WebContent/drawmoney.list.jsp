<%@page import="java.util.ArrayList"%>
<%@page import="com.entity.DrawmoneyEntity"%>
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
							userid
						</th>						<th>
							money
						</th>						<th>
							bankid
						</th>						<th>
							peoplename
						</th>						<th>
							banktype
						</th>						<th>
							status
						</th>						<th>
							comment
						</th>						<th>
							date
						</th>
					</tr>
				</thead>
				<tbody>
			<%
				DrawmoneyEntity entity = new DrawmoneyEntity();
				
				List<DrawmoneyEntity> list = (List<DrawmoneyEntity>)request.getAttribute("list");
				if(list==null){
					list = new ArrayList<DrawmoneyEntity>();
				}
				
				for(DrawmoneyEntity e : list){
					
			%>
				<tr>
											<td>
							<%=e.getUserid() %>
						</td>
						<td>
							<%=e.getMoney() %>
						</td>
						<td>
							<%=e.getBankid() %>
						</td>
						<td>
							<%=e.getPeoplename() %>
						</td>
						<td>
							<%=e.getBanktype() %>
						</td>
						<td>
							<%=e.getStatus() %>
						</td>
						<td>
							<%=e.getComment() %>
						</td>
						<td>
							<%=e.getDate() %>
						</td>

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

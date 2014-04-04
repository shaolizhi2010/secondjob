<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.entity.ResumeEntity"%>

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
				<%
					if(request.getAttribute("entity") == null){
						
					}
					else{
						ResumeEntity entity = (ResumeEntity)request.getAttribute("entity");;
					
				%>
				
						            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							name
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getName() %>
						</p>
					</div>
				</div>	            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							person_information_id
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getPerson_information_id() %>
						</p>
					</div>
				</div>
				<%
					}
				%>
				
            </div>

            <div class="col-md-4 column">
                <jsp:include page="part/slider.jsp" />
            </div>
        </div>
    </div>
    <jsp:include page="part/footer.jsp" />
</body>
</html>

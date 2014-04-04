<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.entity.DrawmoneyEntity"%>

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
						DrawmoneyEntity entity = (DrawmoneyEntity)request.getAttribute("entity");;
					
				%>
				
						            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							userid
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getUserid() %>
						</p>
					</div>
				</div>	            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							money
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getMoney() %>
						</p>
					</div>
				</div>	            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							bankid
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getBankid() %>
						</p>
					</div>
				</div>	            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							peoplename
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getPeoplename() %>
						</p>
					</div>
				</div>	            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							banktype
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getBanktype() %>
						</p>
					</div>
				</div>	            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							status
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getStatus() %>
						</p>
					</div>
				</div>	            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							comment
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getComment() %>
						</p>
					</div>
				</div>	            <div class="row clearfix">
					<div class="col-md-6 column">
						<p>
							date
						</p>
					</div>
					<div class="col-md-6 column">
						<p>
							<%=entity.getDate() %>
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

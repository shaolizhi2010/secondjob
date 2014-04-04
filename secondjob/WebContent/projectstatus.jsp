 <%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<jsp:include page="part/head.jsp" />
</head>


<body>

    <jsp:include page="part/header.jsp" />

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-8 column">
				<h3>项目情况</h3>
				<div class="btn-group">
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> 项目情况</button>
					
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> 发布项目</button> 
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-center"></em> 项目进行中</button> 
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-right"></em> 结束项目</button> 
		 			<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em> 结算</button>
		 			<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em> 互评</button>
				</div>
				
				<h3>人员情况</h3>
				<div class="btn-group">
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> 人员情况</button>
					
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-left"></em> 欲参加</button> 
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em>试用中</button>
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-center"></em> 已参加</button> 
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-right"></em> 已完成</button> 
		 			<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em> 待评价</button>
					<button class="btn btn-default" type="button"><em class="glyphicon glyphicon-align-justify"></em> 已评价</button>
				</div>
            </div>

            <div class="col-md-4 column">
                <jsp:include page="part/slider.jsp" />
            </div>
        </div>
    </div>
    <jsp:include page="part/footer.jsp" />
</body>
</html>

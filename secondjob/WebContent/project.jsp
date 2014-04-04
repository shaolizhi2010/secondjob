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

                				<h3> $title$ </h3> 
               <form role="form" action="project!create.action" method="POST">
				
								<div class="form-group">
					 <label for="name">name</label>
					 <input class="form-control" name="name" id="name" type="text" />
				</div>
				<div class="form-group">
					 <label for="description">description</label>
					 <textarea class="form-control" name="description" id="description" rows="3"></textarea>
				</div>
				<div class="form-group">
					 <label for="payperhour">payperhour</label>
					 <input class="form-control" name="payperhour" id="payperhour" type="text" />
				</div>
				<div class="form-group">
					 <label for="project_request">project_request</label>
					 <textarea class="form-control" name="project_request" id="project_request" rows="3"></textarea>
				</div>

				
				<button type="submit" class="btn btn-default">完成</button>
			</form>


            </div>

            <div class="col-md-4 column">
                <jsp:include page="part/slider.jsp" />
            </div>
        </div>
    </div>
    <jsp:include page="part/footer.jsp" />
</body>
</html>

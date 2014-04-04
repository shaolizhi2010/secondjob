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

                				<h3> resume </h3> 
               <form role="form" action="resume!update.action" method="POST">
				
								<div class="form-group">
					 <label for="name">name</label>
					 <input class="form-control" name="name" id="name" type="text" />
				</div>
				<div class="form-group">
					 <label for="person_information_id">person_information_id</label>
					 <input class="form-control" name="person_information_id" id="person_information_id" type="text" />
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

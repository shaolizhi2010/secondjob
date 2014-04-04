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
               <form role="form" action="experience!create.action" method="POST">
				
								<div class="form-group">
					 <label for="start">start</label>
					 <input class="form-control" name="start" id="start" type="text" />
				</div>
				<div class="form-group">
					 <label for="end">end</label>
					 <input class="form-control" name="end" id="end" type="text" />
				</div>
				<div class="form-group">
					 <label for="comment">comment</label>
					 <textarea class="form-control" name="comment" id="comment" rows="3"></textarea>
				</div>
								<div class="form-group">
					 <label for="tag">tag</label>
					 <input class="form-control" name="tag" id="tag" type="text" />
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

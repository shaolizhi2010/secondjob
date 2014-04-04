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

                				<h3> drawmoney </h3> 
               <form role="form" action="drawmoney!create.action" method="POST">
				
								<div class="form-group">
					 <label for="userid">userid</label>
					 <input class="form-control" name="userid" id="userid" type="text" />
				</div>
				<div class="form-group">
					 <label for="money">money</label>
					 <input class="form-control" name="money" id="money" type="text" />
				</div>
				<div class="form-group">
					 <label for="bankid">bankid</label>
					 <input class="form-control" name="bankid" id="bankid" type="text" />
				</div>
				<div class="form-group">
					 <label for="peoplename">peoplename</label>
					 <input class="form-control" name="peoplename" id="peoplename" type="text" />
				</div>
				<div class="form-group">
					 <label for="banktype">banktype</label>
					 <input class="form-control" name="banktype" id="banktype" type="text" />
				</div>
				<div class="form-group">
					 <label for="status">status</label>
					 <input class="form-control" name="status" id="status" type="text" />
				</div>
				<div class="form-group">
					 <label for="comment">comment</label>
					 <input class="form-control" name="comment" id="comment" type="text" />
				</div>
				<div class="form-group">
					 <label for="date">date</label>
					 <input class="form-control" name="date" id="date" type="text" />
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

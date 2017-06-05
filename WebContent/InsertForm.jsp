<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<link href="http://localhost:8080/BioShareDAO/assets/css/bootstrap.min.css" rel="stylesheet">
		<link href="http://localhost:8080/BioShareDAO/assets/css/jquery-ui.css" rel="stylesheet">
		<link href="http://localhost:8080/BioShareDAO/assets/css/jquery-ui.theme.css" rel="stylesheet">
		<link href="http://localhost:8080/BioShareDAO/assets/css/style.css" rel="stylesheet">
		<script src="http://localhost:8080/BioShareDAO/assets/js/jquery-3.1.1.min.js"></script>
		<script src="http://localhost:8080/BioShareDAO/assets/js/jquery-ui.min.js"></script>
		<script src="http://localhost:8080/BioShareDAO/assets/js/bootstrap.min.js"></script>
		<script src="http://localhost:8080/BioShareDAO/assets/js/bootstrap-alerts.js"></script>
<title>Add new product</title>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$('#categories').change(function(){ 
			$("#products > option").remove();
			var category_id = $('#categories').val(); 
			$.ajax({
				type: "GET",
				url: "http://localhost:8080/BioShareDAO/GetProductTypes?category="+category_id, 
		 
				success: function(products) 
				{
					var first=true;
					$.each(products,function(product_id,product_data) 
					{
						if(first) {
							$("#categories option[value='#']").remove();
							first=false;
						}
						var opt = $('<option />'); 
						opt.val(product_data['product_id']);
						opt.text(product_data['product_label']);
						$('#products').append(opt); 
						
						
					});
				}

			});

		});
		$("#announce_date_from").datepicker({
			dateFormat: "dd/mm/yy",
			minDate: 0,
			onSelect: function (date) {
				var dt2 = $('#announce_date_to');
				var startDate = $(this).datepicker('getDate');
				var minDate = $(this).datepicker('getDate');
				dt2.datepicker('setDate', minDate);
				startDate.setDate(startDate.getDate() + 30);
				//sets dt2 maxDate to the last day of 30 days window
				dt2.datepicker('option', 'maxDate', startDate);
				dt2.datepicker('option', 'minDate', minDate);
			}
		});
		$('#announce_date_to').datepicker({
			dateFormat: "dd/mm/yy"
		});
	});

	</script>


<fieldset>
<legend>Nouvelle annonce</legend>
<div class="row">
	<div class="col-md-7">
		<form method="POST" action="ProductController" accept-charset="UTF-8">
					<fieldset>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-menu-hamburger"></i></span>
								<select name="categories" id="categories" class="form-control">
								<c:forEach items="${categories}" var="element"> 
									<option value="${element.categoryId}">${element.categoryLabel}</option>
								</c:forEach>
								<option value="#" selected="selected">Catégorie</option>
								</select>
							</div>
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-menu-hamburger"></i></span>
								<select name="products" id="products" class="form-control">
								<option value="#" selected="selected" disabled="disabled">Séléctionnez une catégorie avant</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<input class="form-control" placeholder="Titre de l'annonce" name="announce_label" type="text">
							</div>
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
								<textarea class="form-control" placeholder="Description" name="announce_text" rows="8"></textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-euro"></i></span>
								<input class="form-control" placeholder="Prix" name="announce_price" type="text" required>
							</div>
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-shopping-cart"></i></span>
								<input class="form-control" placeholder="Quantité" name="announce_quantity" type="text">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
								<input class="form-control" placeholder="Date de début" name="announce_date_from" type="text" id="announce_date_from" readonly="readonly">
							</div>
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
								<input class="form-control" placeholder="Date de fin" name="announce_date_to" type="text" id="announce_date_to" readonly="readonly">
							</div>
						</div>

						
						<p><button class="btn btn-lg btn-success btn-block" type="submit"><span class="glyphicon glyphicon-pencil"></span> Mettre en ligne</button></p>
					</fieldset>
					</form>
</div>
</div>
</fieldset>


     
</body>
</html>
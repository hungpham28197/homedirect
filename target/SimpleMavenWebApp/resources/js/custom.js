function clickThem() {
	$(document).ready(function(){
		$('select[name="category"]').css("display", "none");
		$("#btn-them").css("display", "none");
		$("#temp").css("display", "block");
		$("#btn-ok").css("display", "block");
		});
	
}

function myFunction() {
	$(document).ready(function(){
		$("#btn-ok").css("display", "none");
		var t = '<option value=' + $('#temp').val() + '>'+$('#temp').val() + '</option>';
		$("#category").append(t);
		$("#category").val($('#temp').val());
		
		$.ajax({
			  method: "POST",
			  url: "/category/add",
			  data: { nameCategory: $('#temp').val()}
			}).done(function( msg ) {
			    
		});
		
		console.log($("#category").val());
	});
    
}

function verifyRegistation() {
	if($("#email").val()==="" || 
	   $("#firstName").val()==="" || 
	   $("#lastName").val()==="" ||
	   $("#address").val()==="" ||
	   $("#phone").val()==="" ||
	   $("#password").val()==="" ||
	   $("#matchingPassword").val()==="" ||
	   $("#password").val()===$("#matchingPassword").val()) {
		alert("Hãy nhập thông tin chính xác");
	}
}


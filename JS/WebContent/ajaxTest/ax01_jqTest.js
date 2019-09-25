//$(document).ready(function(){
$(function(){
	$('#jqTest').click(function(){
		$.ajax({
			type:'Get', 
			// type:'Post',
			url:'ax01_paramResult.jsp',
			data: {
				id:$('#id').val(),
				password:$('#password').val(),
				name:$('#name').val()
				},
			success:function(result){
				$('#resultArea').html(result);
			}
		}); // ajax
	}); //click 
}); // ready
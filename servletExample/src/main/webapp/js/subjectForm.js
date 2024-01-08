$(function(){
	$.ajax({
		url : "/servletExample/subjectNumber",
		type : "post",
		dataType : "text",
		success : function(data) {
			$("#s_num").val(data);
		},
		error : function(xhr, textStatus) {
			alert(textStatus + " (HTTP - " + xhr.status + ")");
		}
	});
});
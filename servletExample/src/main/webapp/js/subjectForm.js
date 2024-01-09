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
	
	$(document).on("click", "#insertBtn", ()=> {
		if(!chkData ("#s_name", "학과명을 ")) return;
		else {
			$("#subject").attr ({
				"method":"post",
				"action":"/servletExample/insert"
			});
			$("#subject").submit();
		}
	});
	
	$(document).on("click", ".upBtn", () => {
		if(!chkData("#s_name","학과명을 ")) return;
		else {
			$("#subject").attr({
				"method":"post",
				"action":"/servletExample/update"
			});
			$("#subject").submit();
		}
	});
	
	$("#resetBtn").on("click", ()=> {
		$("#s_name").val("");
	});
	
	$("#listBtn").on("click", ()=>{
		location.href = "/servletExample/list";
	});
});
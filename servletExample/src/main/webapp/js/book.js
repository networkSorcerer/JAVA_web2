$(function(){
	$("#regBtn").on("click", () => {
		if (!chkData("#title","책제목을")) return;
		else if (!chkData("#author","저자를")) return;
		else if(!chkData("#publicsher", "출판사명을"))return;
		else{
			$("#bookForm").attr({
				"action":"/servletExample/bookInput",
				"method":"post"
			});
			$("#bookForm").submit();
		}
	})
})
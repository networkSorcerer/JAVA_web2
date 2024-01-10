$(function() {
	$("#searchBtn").on("click", ()=> {
		if(!chkData("#no","일련번호를 ")) return;
		else{
			$("#form").attr({
				"method" : "post",
				"action" : "/servletExample/searchResult"
			});
			$("#form").submit();
		}
	});
});

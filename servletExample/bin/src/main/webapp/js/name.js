$(function() {
	$("#btn").on("click", () => {
		const namePatten = /^[가-힣]+$/ㅎ;
		if($("#name").val().replace(/\s/g,"")=="") {
			$("#name").val("");
			$("#name").attr("placeholder","이름을 입력해주세요");
			return;
		}
		if($("#name").val().search(namePatten)<0) {
			$("#name").val("");
			$("#name").attr("placeholder", "한글이름으로만 작성해주세요");
			return;
		}
		$("#frm").attr({
			"method":"post",
			"action":"/selvetExample/configTest"
		});
		$("#frm").submit();
	})
})
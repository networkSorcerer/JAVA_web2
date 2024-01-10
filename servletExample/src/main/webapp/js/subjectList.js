$(function(){
	$("#subjectInsert").on("click", ()=> {
		location.href="/servletExample/subject/subjectForm.jsp";
	});
	$(".updateBtn").on("click", function(){
		let no = $(this).parents("tr").attr("data-no");
		console.log(no);
		$("#no").val(no);
		
		let s_num = $(this).parents("tr").find("td:eq(1)").html();
		console.log(s_num);
		$("#s_num").val(s_num);
		
		let s_name=$(this).parents("tr").find("td:eq(2)").html();
		console.log(s_name);
		$("#s_name").val(s_name);
		
		$("#insertBtn").html("수정완료");
		$("#insertBtn").addClass("upBtn");
		$(".upBtn").removeAttr("id");
	});
	//삭제 버튼 제어
	/*$(".deleteBtn").on("click", function(){
		let s_num = $(this).parents("tr").find("td:eq(1)").html();
		let no = $(this).parents("tr").attr("data-no");
		
		$.ajax({
			url : "/servletExample/studentCheck",
			type : "post",
			data : "s_num=" + s_num,
			dataType : "text",
			success : function(data) {
				console.log(s_num + "/" + data);
				if(data > 0 ) {
					alert("소속된 학생이 존재함을 학과 데이터를 삭제할 수없습니다");
					return;
				}else {
					if(confirm("삭제하시겠습니까?")) {
						console.log(no);
						location.href="/servletExample/delete?no=" +no;
					}
				}
			},
			error : function(xhr, textStatus) {
				alert(textStatus + " (HTTP -" + xhr.status + " )");
			}
		});
	});*/
	
	$(".deleteBtn").on("click", function(){
		if(confirm("삭제하시겠습니까?")){
			let no = $(this).parents("tr").attr("data-no");
			location.href="/servletExample/delete?no="+no;
		}
	});	
});

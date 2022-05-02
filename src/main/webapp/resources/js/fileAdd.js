/**
 * 글 작성시 파일추가
 */
 let count = 0;
 function fileDeleteInit(){
	$(".del").click(function(){
		let check = window.confirm("삭제하면 복구 할 수 없습니다. 삭제하겠습니까?");
		if(!check){
			return;
		}
		let fileNum= $(this).attr("data-num");
		let fileName = $(this).attr("data-name");
		let selector = $(this);
		//console.log(this); event.target 클릭한 element
		$.ajax({
			type:"POST",
			url:"./fileDelete",
			data:{
				fileNum:fileNum,
				fileName:fileName
			},
			success:function(data){
				if(data.trim()=='1'){
					$(selector).parent().remove();
					count--;
				}else{
					alert("파일 삭제 실패");
				}
			},
			error:function(){
				alert("File 삭제 실패")
			}
		})
	});
}
 
 
 function fileAddInit(c){
let v = '<div class="mb-3"><input class="form-control form-control-lg files" type="file" name="files"><button  type="button" class="col-1 btn btn-outline-success delBtn">x</button></div>'
count = c;
$("#fileAdd").click(function() {
	if (count > 4) {
		alert("파일을 최대 5개");
		return;
	}
	count++;
	$("#fileResult").append(v);
});
$("#fileResult").on("click", ".delBtn", function() {
	$(this).parent().remove();
	count--;
});
}
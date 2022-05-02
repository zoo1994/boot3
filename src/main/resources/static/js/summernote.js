/**
 * 
 */
 
function summernoteInit(selector,code){
		$('#'+selector).summernote({
			height : 400
		});
		$('#productDetail').summernote('code',code)
}
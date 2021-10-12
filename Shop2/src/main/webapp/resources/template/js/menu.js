/* 페이지 로딩 후 실행 */
$(document).ready(function(){
//	$(document).on('click', '선택자', function() {
//	});
	var loginModal = document.getElementById('loginModal');
	/*var loginModal = $('#loginModal');위에거가 이거랑 같은거임*/
	
	loginModal.addEventListener('hidden.bs.modal', function (event) {
 	 // do something...
 	 $('.modal input:not([type="butten"])').val('');
	})

});

/* 함수선언 영역*/
(function($){

})(jQuery);
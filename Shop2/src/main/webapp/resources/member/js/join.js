/* 페이지 로딩 후 실행 */
$(document).ready(function(){
	//ID INPUT 태그를 클릭시 빨간 글자 지우기.
	$(document).on('click', '#id', function() {
		$('#aaa').remove();
		$('#joinBtn').addClass('disabled'); //속성을 추가할때

	});
});

/* 함수선언 영역*/
(function($){
	//비밀번호 일치 확인 후 submit
	goJoin = function(){
		alert('실행하면 얼럿')
		var p1 = $('#pw').val();
		var p2 = $('#c_pw').val();
		alert(p1);
		alert(p2);
		if(p1 != p2){
			alert('비밀번호 다르면 이거');
			$('input[type="password"]').val('');
			$('#pw').focus();
			
			return; /*리턴 만나면 여기 js자체 종료 아래로 안내려감*/
		}
		alert('비밀번호 같으면 이거')
		$('#joinForm').submit();
	}
	
	//ID 중복 체크
	checkId = function(){
		var id = $('#id').val();
		
		if(id == ''){
		//	var aaa = $('#chechIdDiv').next().attr('id');
			$('#aaa').remove();
			
			//if(aaa != 'aaa'){
			
			$('#chechIdDiv').after('<div id="aaa" style="color: red; font-size: 12px; margin-top: 2px;">아이디를 입력하세요.</div>');
			
			return;
			//}
		}
		//
		$.ajax({
			url: '/member/checkId', //요청경로
			type: 'post',
			data: {'id':id}, //필요한 데이터
			success: function(result) {
				//기가입 : true, 미가입 : false 컨트롤러에서 리절트값으로 true, false 들고옴
				if(result){
					//리절트가 true일때는 회원이름이 중복인 경우다
					$('#aaa').remove();
					$('#chechIdDiv').after('<div id="aaa" style="color: red; font-size: 12px; margin-top: 2px;">아이디가 중복입니다.</div>');
				}
				else{
					//얘는 중복이 아닐때
					$('#aaa').remove();
					$('#chechIdDiv').after('<div id="aaa" style="color: blue; font-size: 12px; margin-top: 2px;">사용 가능한 아이디입니다.</div>');
					
					//중복이 아닐때만 join이 활성화됨
					//$('#joinBtn').addClass('disabled'); 속성을 추가할때
					$('#joinBtn').removeClass('disabled'); //속성을 지울때
				}
			},
			error: function() {
				//ajax 실행 실패 시 실행되는 구간
				alert('실패');
			}
		});
		
	}
	
})(jQuery);

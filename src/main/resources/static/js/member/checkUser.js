/**
 * 사용자 중복체크
 */
$(function(){
    // 아이디 중복체크
    const inputUid = document.getElementsByName('uid')[0];
    const msgId = document.getElementsByClassName('msgId')[0];

    if(inputUid != null) {
        inputUid.addEventListener("focusout", function(){
            const uid = inputUid.value;

            // 아이디 유효성 검증(중복 버튼을 눌렀을 때 서버로 보냄으로써 생기는 부하를 줄이기 위해 위치를 위로 올려준다.)
            if(!uid.match(reUid)){
                msgId.innerText = '유효한 아이디가 아닙니다.';
                msgId.style.color = 'red';
                isUidOk = false;
                return;
            }

            // 서버 전송
            const xhr = new XMLHttpRequest();
            xhr.open('GET', '/member/check/uid/'+uid);
            xhr.send();

            xhr.onreadystatechange = function(){
                if(xhr.readyState == XMLHttpRequest.DONE){
                    if(xhr.status == 200) {
                        console.log(xhr.response);
                        const data = JSON.parse(xhr.response);
                        if(data > 0){
                            feedback.text('이미 사용중인 아이디 입니다.');
                            input.addClass('is-invalid'); // 테두리 색상을 바꾸기 위한 클래스 추가
                            input.removeClass('is-valid'); // 테두리 색상을 바꾸기 위한 클래스 추가
                            isUidOk = false;
                        }else{
                            input.removeClass('is-invalid');
                            input.addClass('is-valid');// 유효한 경우 테두리 색상을 원래대로 복원
                            isUidOk = true;
                        }
                    }
                }// readyState end
            }//onreadystatechange end
        });// btnCheckUidonclick end
    }

    // 휴대폰 중복체크
    $('input[name=hp]').focusout(function() {
        const hp = $(this).val();
        console.log(hp);
        if(!hp.match(reHp)) {
            $('.msgHp').css('color', 'red').text('휴대폰 번호가 유효하지 않습니다.');
            isHpOk = false;
            return;
        }
        console.log("유효성검사통과!");
        console.log
        $.ajax({
            url: '/member/check/hp/'+hp,
            dataType: 'json',
            type: 'GET',
            contentType: 'application/json',
            success: function(data){
                console.log(data);
                if(data > 0) {
                    feedback.text('이미 사용중인 휴대폰 번호 입니다.');
                    input.addClass('is-invalid'); // 테두리 색상을 바꾸기 위한 클래스 추가
                    input.removeClass('is-valid'); // 테두리 색상을 바꾸기 위한 클래스 추가
                    isHpOk = false;
                }else {
                    input.removeClass('is-invalid');
                    input.addClass('is-valid');// 유효한 경우 테두리 색상을 원래대로 복원
                    isHpOk = true;
                }
            }
        });

    });

}); // onload end

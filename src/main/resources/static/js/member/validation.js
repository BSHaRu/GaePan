// 폼 데이터 검증 상태변수
let isUidOk 		= false;
let isPassOk1 	= false;
let isPassOk2 	= false;
let isNameOk 	= false;
let isEmailOk 	= false;
let isHpOk 		= false;

// 데이터 검증에 사용하는 정규표현식
const reUid   = /^[a-z]+[a-z0-9]{4,19}$/g;
const rePass  = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;
const reName  = /^[가-힣]{2,10}$/
const reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
const reHp    = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;

$(document).ready(function() {
    $(function () {

        $(function () {
            // 아이디 검사
            $('input[name=uid]').focusout(function () {
                const uid = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if (!uid.match(reUid)) {
                    feedback.text('사용 불가능한 아이디 입니다.');
                    input.addClass('is-invalid'); // 테두리 색상을 바꾸기 위한 클래스 추가
                    input.removeClass('is-valid'); // 테두리 색상을 바꾸기 위한 클래스 추가
                    isUidOk = false;
                } else {
                    input.removeClass('is-invalid');
                    input.addClass('is-valid');// 유효한 경우 테두리 색상을 원래대로 복원
                    isUidOk = true;
                }

            });


            $('input[name=uid]').focusout(function () {
                const uid = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if(uid == ''){
                    input.removeClass('is-invalid');
                    input.removeClass('is-valid');
                    feedback.text('');
                }
                isUidOk = false;
            });

            // 비밀번호 검사
            $('input[name=pass1]').focusout(function(){
                const pass1 = $('input[name=pass1]').val();
                const pass2 = $('input[name=pass2]').val();
                const feedback = $(this).siblings('.invalid-feedback');
                const feedback2 = $('input[name=pass2]').siblings('.invalid-feedback');
                const input = $(this);
                const input2 = $('input[name=pass2]');

                if(pass1.match(rePass)) {

                    feedback.css('color', 'green').text('사용할 수 있는 비밀번호 입니다.');
                    input.removeClass('is-invalid');
                    input.addClass('is-valid');

                    if(pass2 == '' && pass1 != pass2){

                        feedback2.css('color', 'red').text('비밀번호가 일치하지 않습니다.');
                        input2.addClass('is-invalid');

                        isPassOk2 = false;

                    }else {
                        feedback2.text('');
                        input2.addClass('is-valid');
                        isPassOk2 = true;
                    }
                }else {
                    feedback.css('color', 'red').text('사용할 수 없는 비밀번호 입니다.');
                    input.addClass('is-invalid');

                    isPassOk1 = false;
                }
            });

            $('input[name=pass2]').focusout(function(){
                const pass1 = $('input[name=pass1]').val();
                const pass2 = $('input[name=pass2]').val();
                const feedback = $('input[name=pass1]').siblings('.invalid-feedback');
                const feedback2 = $(this).siblings('.invalid-feedback');
                const input = $('input[name=pass1]');
                const input2 = $(this);
                if(pass2 != '' && pass1 == pass2) {
                    if (pass2.match(rePass)) {

                        feedback.text('');
                        feedback2.css('color', 'green').text('비밀번호가 일치합니다.');
                        input2.removeClass('is-invalid');
                        input2.addClass('is-valid');

                        isPassOk1 = true;
                        isPassOk2 = true;
                    } else {

                        feedback2.css('color', 'red').text('사용할 수 없는 비밀번호 입니다.');
                        input2.removeClass('is-valid');
                        input2.addClass('is-invalid');

                        isPassOk2 = false;
                    }

                } else {

                    feedback2.css('color', 'red').text('비밀번호가 일치하지않습니다.');
                    input2.removeClass('is-valid');
                    input2.addClass('is-invalid');

                    isPassOk2 = false;

                }
            });


            $('input[name=pass1]').focusout(function(){
                const pass1 = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if(pass1 == ''){
                    input.removeClass('is-invalid');
                    input.removeClass('is-valid');
                    feedback.text('');
                }
                isPassOk1 = false;
            });

            $('input[name=pass2]').focusout(function(){
                const pass2 = $(this).val();
                const feedback2 = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if(pass2 == ''){
                    input.removeClass('is-invalid');
                    input.removeClass('is-valid');
                    feedback2.text('');
                }
                isPassOk2 = false;
            });

            // 이름 검사
            $('input[name=name]').focusout(function () {
                const name = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if (name.match(reName)) {
                    feedback.text('');
                    input.removeClass('is-invalid');
                    input.addClass('is-valid');
                    isNameOk = true;
                } else {

                    feedback.css('color', 'red').text('유효한 이름이 아닙니다.');
                    input.removeClass('is-valid');
                    input.addClass('is-invalid');
                    isNameOk = false;
                }
            })

            $('input[name=name]').focusout(function () {
                const name = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if(name == ''){
                    input.removeClass('is-invalid');
                    input.removeClass('is-valid');
                    feedback.text('');
                }
                isNameOk = false;
            });


            // 휴대폰 검사
            $('input[name=hp]').focusout(function () {
                const hp = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if (hp.match(reHp)) {
                    feedback.css('color', 'green').text('사용가능한 휴대폰 번호입니다.');
                    input.removeClass('is-invalid');
                    input.addClass('is-valid');
                    isHpOk = true;
                } else {
                    feedback.css('color', 'red').text('유효하지 않은 휴대폰 번호입니다.');
                    input.addClass('is-invalid');
                    input.removeClass('is-valid');
                    isHpOk = false;
                }
            });

            $('input[name=hp]').focusout(function () {
                const hp = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if(hp == ''){
                    input.removeClass('is-invalid');
                    input.removeClass('is-valid');
                    feedback.text('');
                }
                isHpOk = false;
            });

            // 이메일 검사
            $('input[name=email]').focusout(function () {
                const email = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if (email.match(reEmail)) {
                    feedback.text('');
                    input.removeClass('is-invalid');
                    input.addClass('is-valid');
                    isEmailOk = true;
                } else {
                    feedback.css('color', 'red').text('유효하지 않은 이메일 주소입니다.');
                    input.addClass('is-invalid');
                    input.removeClass('is-valid');
                    isEmailOk = false;
                }
            });

            $('input[name=email]').focusout(function () {
                const email = $(this).val();
                const feedback = $(this).siblings('.invalid-feedback');
                const input = $(this);

                if(email == ''){
                    input.removeClass('is-invalid');
                    input.removeClass('is-valid');
                    feedback.text('');
                }
                isEmailOk = false;
            });

            // 최종 확인
            $('.registerForm').submit(function (e) {
                e.preventDefault(); // 폼 제출 이벤트 중지

                // true면 전송, false면 전송 취소
                if (!isUidOk || !isPassOk1 || !isPassOk2 || !isNameOk || !isEmailOk || !isHpOk) {
                    alert('입력 정보를 확인해주세요.');
                } else {
                    // 폼 전송
                    this.submit();
                }
            });
        });
    });
});
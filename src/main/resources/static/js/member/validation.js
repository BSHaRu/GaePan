$(document).ready(function () {

    // 폼 데이터 검증 상태 객체
    let formValidation = {
        isUidOk: false,
        isPassOk1: false,
        isPassOk2: false,
        isNameOk: false,
        isEmailOk: false,
        isHpOk: false,
    };

    // 데이터 검증에 사용하는 정규표현식
    const reUid = /^[a-z]+[a-z0-9]{4,19}$/g;
    const rePass = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{5,16}$/;
    const reName = /^[가-힣]{2,10}$/;
    const reEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    const reHp = /^01(?:0|1|[6-9])-(?:\d{4})-\d{4}$/;

    // 입력 검증 함수
    function validateInput(input, regex, feedbackMessage, fieldName) {
        const value = input.val();
        const feedback = input.siblings('.invalid-feedback');

        if (value.match(regex)) {
            feedback.text('');
            input.removeClass('is-invalid');
            input.addClass('is-valid');
            formValidation[fieldName] = true;

            // 추가: 중복 확인 (id, hp, email에 대해서만 수행)
            if (fieldName === 'isUidOk' || fieldName === 'isHpOk' || fieldName === 'isEmailOk') {
                // 중복 확인 함수 호출
                checkDuplication('/LotteON/member/check/' + fieldName.slice(2).toLowerCase() + '/' + value, '.msg' + fieldName.slice(2));
            }
        } else {
            feedback.css('color', 'red').text(feedbackMessage);
            input.removeClass('is-valid');
            input.addClass('is-invalid');
            formValidation[fieldName] = false;
        }
    }

    // 아이디 검사
    $('input[name=uid]').focusout(function () {
        validateInput($(this), reUid, '사용 불가능한 아이디 입니다.', 'isUidOk');
    });

    // 비밀번호 검사
    function validatePassword(passInput, passFeedback, isPassVariable) {
        const pass = passInput.val();
        const feedback = passFeedback;
        const input = passInput;

        if (pass.match(rePass)) {
            feedback.css('color', 'green').text('사용할 수 있는 비밀번호 입니다.');
            input.removeClass('is-invalid');
            input.addClass('is-valid');
            formValidation[isPassVariable] = true;
        } else {
            feedback.css('color', 'red').text('사용할 수 없는 비밀번호 입니다.');
            input.addClass('is-invalid');
            formValidation[isPassVariable] = false;
        }
    }

    $('input[name=pass1]').focusout(function () {
        validatePassword($(this), $(this).siblings('.invalid-feedback'), 'isPassOk1');
    });

    $('input[name=pass2]').focusout(function () {
        validatePassword($(this), $(this).siblings('.invalid-feedback'), 'isPassOk2');

        // pass2의 값을 따로 확인하여 유효성을 검사합니다.
        const pass1 = $('input[name=pass1]').val();
        const pass2 = $(this).val();
        const feedback = $(this).siblings('.invalid-feedback');

        if (pass2 === '' || pass1 !== pass2) {
            feedback.css('color', 'red').text('비밀번호가 일치하지 않습니다.');
            $(this).addClass('is-invalid');
            formValidation.isPassOk2 = false;
        } else {
            feedback.text('');
            $(this).removeClass('is-invalid');
            $(this).addClass('is-valid');
            formValidation.isPassOk2 = true;
        }
    });

    // 이름 검사
    $('input[name=name]').focusout(function () {
        validateInput($(this), reName, '유효한 이름이 아닙니다.', 'isNameOk');
    });

    // 휴대폰 검사
    $('input[name=hp]').focusout(function () {
        validateInput($(this), reHp, '유효하지 않은 휴대폰 번호입니다.', 'isHpOk');
    });

    // 이메일 검사
    $('input[name=email]').focusout(function () {
        validateInput($(this), reEmail, '유효하지 않은 이메일 주소입니다.', 'isEmailOk');
    });

    // 최종 확인
    $('.registerForm').submit(function (e) {
        e.preventDefault(); // 폼 제출 이벤트 중지

        // true면 전송, false면 전송 취소
        if (!formValidation.isUidOk || !formValidation.isPassOk1 || !formValidation.isPassOk2 || !formValidation.isNameOk || !formValidation.isEmailOk || !formValidation.isHpOk) {

            console.log('isUidOk:', formValidation.isUidOk);
            console.log('isPassOk1:', formValidation.isPassOk1);
            console.log('isPassOk2:', formValidation.isPassOk2);
            console.log('isNameOk:', formValidation.isNameOk);
            console.log('isEmailOk:', formValidation.isEmailOk);
            console.log('isHpOk:', formValidation.isHpOk);

            alert('입력 정보를 확인 해주세요.');
        } else {
            // 폼 전송
            this.submit();
        }
    });
});
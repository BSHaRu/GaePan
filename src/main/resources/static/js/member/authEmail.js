// 인증번호 발송 버튼 초기에 비활성화
$(document).ready(function () {
    $("#btnEmailAuth").prop('disabled', true);

    // 인증번호 발송 버튼 클릭 이벤트 처리
    $("#btnEmailAuth").click(function () {
        alert("인증번호가 발송되었습니다.")
        // 버튼 클릭 시 처리할 내용
        const division = $('input[name=division]').val();
        const name = $('input[name=name]').val();
        const uid = $('input[name=uid]').val();
        const email = $('input[name=email]').val();


        const jsonData = {
            "division": division,
            "name": name,
            "uid": uid,
            "email": email
        };

        setTimeout(function () {
            $.ajax({
                url: '/member/email/authEmail',
                type: 'GET',
                data: jsonData,
                dataType: 'json',
                success: function (data) {
                    console.log("result : " + data.result);
                    console.log("status : " + data.status);
                }

            });
        }, 1000);
        $(this).hide(); // 인증번호 발송 버튼 숨김
        $("#verificationCode").show(); // 인증번호 확인 입력창 보임
    });

        // 확인 버튼 클릭 시 처리할 내용
        $("#btnVerifyCode").click(function () {
            const email = $('#lo_email1').val() + "@" + $('#lo_email2').val();
            console.log("email : " + email);
            const code = $("#authCode").val();
            $.ajax({
                url: '/member/email/confirmEmail/' + code,
                type: 'POST',
                dataType: 'json',
                success: function (data) {
                    if (data > 0) {
                        alert("이메일 인증에 성공했습니다.")
                        $("#btnVerifyCode").hide();
                        $("#authCode").prop('readonly', true);
                        $("#email").prop('readonly', true);
                        isEmailOk = true;
                    } else {
                        alert("이메일 인증에 실패했습니다.")
                        isEmailOk = false;
                    }
                }
            });
        });
});
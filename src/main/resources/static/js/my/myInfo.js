// 탈퇴하기
$('#btnWithdraw').click(function(e){

    let result = confirm("회원 탈퇴를 희망하시는게 맞나요?");
    if(result){
        return true;
    }else{
        return false;
    }

/*
    if (result) {
        $('#popWithdraw').addClass('on'); // 비밀번호 입력 팝업

        $('.btnPopWithdraw').click(function(e){

            const uid = $('input[name=uid]').val();
            const inputPass = $('input[name=passCheck]').val();

            $.ajax({
                url: contextPath + '/my/withdraw',
                type: 'POST',
                data: {
                    uid: uid,
                    inputPass: inputPass
                },
                success: function(data) {
                    if (data === "success") {
                        alert('탈퇴가 완료되었습니다.');
                        window.location.href=contextPath + "/member/logout";
                    } else {
                        alert("비밀번호가 일치하지 않습니다.");
                    }
                }
            });
        });
    }*/
});
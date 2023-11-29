const path3 = "/admin/board/deleteComment";
const path4 = "/admin/board/view";

const path5 = "/admin/board/modifyComment";

$(".comment__modify").click(function(e) {
    e.preventDefault();

    const bno = $(this).data('cbno');
    const parent = $(this).data('parent');
    const comment = $(this).data('comment');

    console.log("bno : " + bno);
    console.log("parent : " + parent);
    console.log("comment : " + comment);

    let commentTextarea = $(this).closest('.admin_board_left').siblings('.comment').find('.commentArea');
    commentTextarea.attr('readonly', false).toggleClass('commentArea').focus();

    // focus() 이후에 setSelectionRange()를 사용하여 텍스트 맨 끝에 커서를 두도록 합니다.
    const textLength = commentTextarea.val().length;
    commentTextarea[0].setSelectionRange(textLength, textLength);

    $(".modifyComplete").click(function(e) {
        e.preventDefault();

        const bno = $(this).data("cbno");
        const parent = $(this).data("parent");
        // 수정된 내용을 가져옵니다.
        const comment = commentTextarea.val();
        console.log("bno : " + bno);
        console.log("parent : " + parent);
        console.log("comment : " + comment);

        $.ajax({
            type: "put",
            url: path5,
            data: {
                bno : bno,
                comment : comment
            },
            success: function(response) {
                console.log("댓글 수정");
                location.replace(path4+"?bno="+parent);
            },
            error: function(error) {
                console.log("댓글 수정 실패");
            }
        }); // ajax end
    });

});


$(".comment__delete").click(function(e) {
    e.preventDefault();

    const bno = $(this).data("cbno");
    const parent = $(this).data("parent");

    console.log("bno : " + bno);
    console.log("parent : " + parent);

    // debugger;

    if(confirm("정말 댓글 삭제 하시겠습니까?")){
        $.ajax({
            type: "delete",
            url: path3,
            data: {
                bno : bno
            },
            success: function(response) {
                console.log(1);
                alert("댓글이 삭제되었습니다.");
                location.replace(path4+"?bno="+parent);
            },
            error: function(error) {
                console.log(2);
                alert("댓글 삭제에 실패했습니다.");
            }
        }); // ajax end
    }
});

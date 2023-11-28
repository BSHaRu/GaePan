const path5 = "/admin/board/modifyComment";
const path4 = "/admin/board/view";

$(".comment__modify").click(function(e) {
    e.preventDefault();

    const bno = $(".commentArea").data("cbno");
    const parent = $(this).data("parent");
    const comment =$(".commentArea").val();
    const comment2 = $(".commentArea").data("comment");

    console.log("bno : " + bno);
    console.log("parent : " + parent);
    console.log("comment : " + comment);
    console.log("comment2 : " + comment2);

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
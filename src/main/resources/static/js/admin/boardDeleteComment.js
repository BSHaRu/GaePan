const path3 = "/admin/board/deleteComment";
const path4 = "/admin/board/view";

$(".comment__delete").click(function(e) {
   e.preventDefault();

    const bno = $(".commentArea").data("cbno");
    const parent = $(this).data("parent");

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
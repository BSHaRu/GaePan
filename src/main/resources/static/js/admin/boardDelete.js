$(function() {
    $(".board_deleteBtn").click(function(e) {
        e.preventDefault();

        const url1 = "/admin/board/delete";
        const url2 = "/admin/board/list";
        const bno = $(this).data("bno");
        // const uid = $(".admin__uid").data("uid");
        const group = $(".board__group").data("group");
        console.log("bno : " + bno);
        console.log("group : " + group);

        if(confirm("정말 게시글을 삭제하시겠습니까?")){
            $.ajax({
                type: "delete",
                url: url1,
                data: {
                    bno : bno
                },
                success: function(response) {
                    console.log(1);
                    alert("게시글이 삭제되었습니다.");
                    location.replace(url2+"?group="+group);
                },
                error: function(error) {
                    console.log(2);
                    alert("게시글 삭제에 실패했습니다.");
                }
            }); // ajax end
        } // confirm if end
    }); // deleteBtn end
});
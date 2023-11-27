// const path5 = "/admin/board/modifyComment";
// const path4 = "/admin/board/view";

$(".comment__modify").click(function(e) {
    e.preventDefault();

    const bno = $(".commentArea").data("cbno");
    const comment = $(".commentArea").data("cComment");
    const com = $(".commentArea").data("CComment");


    console.log("bno : " + bno);
    console.log("comment : " + comment);
    console.log("com : " + com);
});
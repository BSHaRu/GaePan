
window.onload = function(){

    console.log('test...1');
    const qnaCate = document.getElementById('qnaCate');
    const qnaType = document.getElementById('qnaType');

    console.log('test...2 : ' + qnaCate);
    // 이벤트 change ? select?
    qnaCate.addEventListener('change', (e)=>{
        alert('test!!!');
    });




}

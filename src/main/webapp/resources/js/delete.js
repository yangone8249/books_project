
function alertEvent(){
    console.log("alert이벤트 진입");
    console.log("bno : "+document.getElementById('bno').value);
    if(confirm("정말 삭제하시겠습니까?")){
        console.log('확인');
        location.href="/board/delete?bno="+document.getElementById('bno').value;

    }else{
        console.log('취소');
        return false;
    }

}
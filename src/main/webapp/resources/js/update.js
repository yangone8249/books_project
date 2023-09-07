
  
function fileChange() {
    
    console.log(document.getElementById('file').files);
    console.log(document.getElementById('file').files[0]);

    if (document.getElementById('file').files[0]) {
        var reader = new FileReader();

        
        reader.onload = function(e) {
            document.getElementById('img').src = reader.result;
        };
        reader.readAsDataURL(document.getElementById('file').files[0]);
    }

}

function alertEvent(){
    console.log("alert이벤트 진입");

    if(confirm("정말 수정하시겠습니까?")){
        console.log('확인');
        document.getElementById("sub").submit();

    }else{
        console.log('취소');
        return false;
    }

}
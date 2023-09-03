
  
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
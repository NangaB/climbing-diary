function showSth1() {
    var x = document.getElementById('addForm');
    if(x.style.display === 'none'){
        x.style.display = 'block'; // tj. właściwości elementu
    }
    // else {
    //     x.style.display = 'none'; // tj. znika
    // }
}

function showSth2() {
    var x = document.getElementById('showDiary');
    if(x.style.display === 'none'){
        x.style.display = 'block'; // tj. właściwości elementu
    } else {
        x.style.display = 'none'; // tj. znika
    }
}

function showSth3() {
    var x = document.getElementById('ranking');
    if(x.style.display === 'none'){
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}

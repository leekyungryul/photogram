// (1) 회원정보 수정
function update(userId, event) {
    event.preventDefault(); // form 태그 액션을 막는 코드
    let data = $('#profileUpdate').serialize();

    console.log(data);

    $.ajax({
        type: 'put',
        url: `/api/user/${userId}`,
        data: data,
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        dataType: 'json'
    }).done(res=>{
        console.log("성공", res);
        location.href=`/user/${userId}`;
    }).fail(error=>{
        console.log("실패", error);
        if (error.data == null) {
            alert(error.responseJSON.message);
        } else {
            alert(JSON.stringify(error.responseJSON.data));
        }
    });
}
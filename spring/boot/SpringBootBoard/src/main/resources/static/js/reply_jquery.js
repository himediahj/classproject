// 수정 모달
let editModal;

$().ready(function () {
    editModal = new bootstrap.Modal('#replyEditModal')

    // 댓글 등록 버튼 이벤트 등록
    $('#btn_reply').on('click', insertReply)
    // 수정 버튼 이벤트
    $('#btn_edit').click(editReply)

    // 리스트 항목의 수정 버튼 이벤트 등록, 동적으로 생성되는 tag에 이벤트 연결
    $('#replyList').on('click', '.edit', showEditModal)
    $('#replyList').on('click', '.del', deleteReply)

    // 리스트 출력
    setList()
})

function setList() {
    $.getJSON('/reply/' + bno, function (data) { // javascript 객체로 받는다 [{},{},{},...]
        console.log(data)

        $.each(data, function (index, reply) { // foreach는 index가 뒤로 감
            let html = '<td class="col-2">' + reply.replyer + '</td>'
            html += '<td>' + reply.reply + '</td>'
            html += '<td class="col-2">' + reply.replydate + '</td>'
            html += '<td class="col-2">' +
                '<a href="javascript:" class="badge bg-warning text-decoration-none edit">수정</a> '
                + ' <a href="javascript:" class="badge bg-danger text-decoration-none del">삭제</a></td>'

            const newTR = $('<tr></tr>').attr('class', 'fs-6 text-center').attr('tr-index', reply.rno).html(html)

            $('#replyList').append(newTR)
        })
    })
}

function insertReply(){
    // 서버로 전송할 payload (객체 형식)
    const payload = {
        bno : bno,  // 위에서 변수로 받아왔음
        reply : $('#reply').val(),
        replyer : $('#replyer').val()
    }
    // console.log("payload", payload)

    $.ajax({
        url: '/reply',
        type: 'post',
        data: JSON.stringify(payload),
        dataType: 'json',
        contentType: 'application/json',
        success: function (data){

            const reply = data

            let html = '<td class="col-2">'+reply.replyer+'</td>'
            html += '<td>'+reply.reply+'</td>'
            html += '<td class="col-2">'+reply.replydate+'</td>'
            html += '<td class="col-2">'+
                '<a href="javascript:" class="badge bg-warning text-decoration-none edit">수정</a> '
                +' <a href="javascript:" class="badge bg-danger text-decoration-none del">삭제</a></td>'

            const newTR = $('<tr></tr>').attr('class', 'fs-6 text-center').attr('tr-index', reply.rno).html(html)

            // 부모 태그에 요소 추가
            $('#replyList').append(newTR)

            $('#reply').val('')
            $('#replyer').val('')
        }
    })
}

function deleteReply(e){
    // a 기본 기능 제거
    e.preventDefault()

    if(!confirm('삭제하시겠습니까?')){
        return
    }

    // rno 구하기
    const rno = $(this).parent('td').parent('tr').attr('tr-index')
    console.log('rno >> ', rno)

    $.ajax({
        url: '/reply/'+rno,
        type: 'delete',
        success: function (data){
            console.log('delete - response =>', data)

            if(data == 1){
                // 화면에서 해당 tr-index == rno행 삭제
                $('tr[tr-index="'+rno+'"]').remove()
                alert('삭제되었습니다.')
            } else {
                alert('삭제할 대상이 존재하지 않습니다.')
            }
        }, error: function (request, httpStatus, error){
            console.log(request)
            console.log(httpStatus)
            console.log(error)
        }
    })
}


function showEditModal(e){
    // a 기본 기능 제거
    e.preventDefault()

    editModal.show()

    //const editTD = document.querySelectorAll('tr[tr-index="'+rno+'"]>td')
    const editTD = $(this).parent('td').parent('tr').children('td')
    const rno = $(this).parent('td').parent('tr').attr('tr-index')

    $('#erno').val(rno)
    $('#ereplyer').val($(editTD).eq(0).text())
    $('#ereply').val($(editTD).eq(1).text())
    $('#ereplydate').val($(editTD).eq(2).text())
}

function editReply() {
    // 서버로 전송할 payload
    // put => 전체 데이터의 변경, 모든 데이터를 서버로 전송, 값이 없는 경우 기본값 저장
    const payload = {
        bno: bno,  // 위에서 변수로 받아왔음
        rno: $('#erno').val(),
        reply: $('#ereply').val(),
        replyer: $('#ereplyer').val(),
        replydate: $('#ereplydate').val()
    }

    console.log(payload)

    $.ajax({
        url: '/reply/' + payload.rno,
        type: 'put',
        data: JSON.stringify(payload),
        dataType: 'json',
        contentType: 'application/json',
        success: function () {
            const editTD = $('tr[tr-index="' + payload.rno + '"]>td')
            $(editTD).eq(1).text(payload.reply)
            editModal.hide()
        }

    })
}

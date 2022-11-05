document.addEventListener('DOMContentLoaded', () => {
    const idInput = document.querySelector('#userID')
    const pwInput = document.querySelector('#pw')
    const pw2Input = document.querySelector('#repw')
    const nameInput = document.querySelector('#userName')
    const editForm = document.querySelector('#editFormArea')
    const link = document.querySelector('.title_font+div>a')
    const editTable = document.querySelector('#editForm')

    editForm.style.display = 'none'

    idInput.addEventListener('focusout', () => {
        const msg = document.querySelector('#userID+div')
        if (idInput.value == '' || idInput.value == null) {
            msg.textContent = '필수로 입력하는 칸입니다'
        } else if (!/[a-zA-Z0-9]/.test(idInput.value)) {
            msg.textContent = '영문과 숫자만 입력 가능합니다.'
        } else if (/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g.test(idInput.value)) {
            msg.textContent = '영문과 숫자만 입력 가능합니다.'
        } else if (/\s/g.test(idInput.value)) {
            msg.textContent = '공백은 허용하지 않습니다'
        } else { msg.textContent = '' }

    })

    pw2Input.addEventListener('focusout', (e) => {
        const pwInput = document.querySelector('#pw')
        if (e.target.value !== pwInput.value) {
            alert('비밀번호가 일치하지 않습니다')}
    })

    nameInput.addEventListener('focusout', () => {
        const msg = document.querySelector('#userName+div')
        if (nameInput.value == '' || nameInput.value == null) {
            msg.textContent = '필수로 입력하는 칸입니다'
        } else if (/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g.test(nameInput.value)) {
            msg.textContent = '한글과 영문만 입력 가능합니다'
        } else if (/[0-9]/g.test(nameInput.value)) {
            msg.textContent = '숫자는 입력이 불가합니다.'
        } else if (/\s/g.test(nameInput.value)) {
            msg.textContent = '공백은 허용하지 않습니다'
        } else { msg.textContent = '' }
    })

    link.addEventListener('click', (editMemberClose) => {
    })

    const form = document.querySelector('#regForm')
    form.addEventListener('submit', submitHandler)
    form.addEventListener('reset', () => {  // 초기화 버튼
        idInput.value = ''
        pwInput.value = ''
        pw2Input.value = ''
        nameInput.value = ''
        
        const msg = document.querySelector('#userID+div')
        const msg2 = document.querySelector('#userName+div')

        msg.textContent = ''
        msg2.textContent = ''
    })
})

let cnt = 1
////////////////////////////////////////////////
const submitHandler = (event) => {
    event.preventDefault()
    const idInput = document.querySelector('#userID')
    const pwInput = document.querySelector('#pw')
    const pw2Input = document.querySelector('#repw')
    const nameInput = document.querySelector('#userName')
    const memList = document.querySelector('#list')
    
    // 유효성 검사로 return false로 submit 제한 
    if (idInput.value == '' || idInput.value == null) return    
    else if (!/[a-zA-Z0-9]/.test(idInput.value)) return
    else if (/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g.test(idInput.value)) return
    else if (/\s/g.test(idInput.value)) return

    if (pw2Input.value !== pwInput.value) return

    if (nameInput.value == '' || nameInput.value == null) return
    else if (/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g.test(nameInput.value)) return
    else if (/[0-9]/g.test(nameInput.value)) return
    else if (/\s/g.test(nameInput.value)) return

    const newTr = document.createElement('tr')
    const td0 = document.createElement('td')
    const td1 = document.createElement('td')
    const td2 = document.createElement('td')
    const td3 = document.createElement('td')
    const td4 = document.createElement('td')
    const td5 = document.createElement('td')

    
    const key = cnt++

    td0.innerHTML = key
    td1.innerHTML = idInput.value
    td2.innerHTML = pwInput.value
    td3.innerHTML = nameInput.value
    td4.innerHTML = '삭제'
    td5.innerHTML = '수정'


    newTr.append(td0)
    newTr.append(td1)
    newTr.append(td2)
    newTr.append(td3)
    newTr.append(td4)
    newTr.append(td5)



    td4.addEventListener('click', (e) => {  
        e.target.parentNode.remove()    // 삭제의 부모는 tr이 되어서 tr 전체삭제
    })

    td5.addEventListener('click', () => {
        const editForm = document.querySelector('#editFormArea')
        editForm.style.display = 'block'
    })

    memList.appendChild(newTr)

}

const editMemberClose = () => {
    const editForm = document.querySelector('#editFormArea')
    editForm.style.display = 'none'
}

let cnt = 1

document.addEventListener('DOMContentLoaded', () => {
    const idInput = document.querySelector('#userID')
    const pwInput = document.querySelector('#pw')
    const pw2Input = document.querySelector('#repw')
    const nameInput = document.querySelector('#userName')
    const editForm = document.querySelector('#editFormArea')
    const link = document.querySelector('.title_font+div>a')
    const editTable = document.querySelector('#editForm')
    const msg = document.querySelector('#userID+div')
    const msg2 = document.querySelector('#userName+div')

    editForm.style.display = 'none'

    idInput.addEventListener('focusout', () => {
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
            alert('비밀번호가 일치하지 않습니다')
        }
    })

    nameInput.addEventListener('focusout', () => {

        if (nameInput.value == '' || nameInput.value == null) {
            msg2.textContent = '필수로 입력하는 칸입니다'
        } else if (/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g.test(nameInput.value)) {
            msg2.textContent = '한글과 영문만 입력 가능합니다'
        } else if (/[0-9]/g.test(nameInput.value)) {
            msg2.textContent = '숫자는 입력이 불가합니다.'
        } else if (/\s/g.test(nameInput.value)) {
            msg2.textContent = '공백은 허용하지 않습니다'
        } else { msg.textContent = '' }
    })

    link.addEventListener('click', (editMemberClose) => {
    })

    const form = document.querySelector('#regForm')
    form.addEventListener('submit', (event) => {
        event.preventDefault()
        const memList = document.querySelector('#list')
        // 유효성 검사 return false로 submit 제한 
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

        memList.appendChild(newTr)

        td4.addEventListener('click', (e) => {
            e.target.parentNode.remove()    // 삭제의 부모는 tr이 되어서 tr 전체삭제
        })

        // 수정하기 
        td5.addEventListener('click', () => {
            const editForm = document.querySelector('#editFormArea')
            editForm.style.display = 'block'
            editForm.addEventListener('submit', (event) => {
                event.preventDefault()
                const editPw = document.querySelector('#editPw')
                const editRepw = document.querySelector('#editRePw')
                const editName = document.querySelector('#editName')
                if (editPw.value !== editRepw.value) {
                    alert('비밀번호가 일치하지 않습니다')
                    return
                } else {
                    td2.innerHTML = editPw.value
                    td3.innerHTML = editName.value
                }
            })
        })
    })

    form.addEventListener('reset', () => {  // 초기화 버튼
        idInput.value = ''
        pwInput.value = ''
        pw2Input.value = ''
        nameInput.value = ''
        msg.textContent = ''
        msg2.textContent = ''
    })
})

const editMemberClose = () => {
    const editForm = document.querySelector('#editFormArea')
    const editPw = document.querySelector('#editPw')
    const editRepw = document.querySelector('#editRePw')
    const editName = document.querySelector('#editName')
    editPw.value = ''
    editRepw.value = ''
    editName.value = ''
    editForm.style.display = 'none'

}

document.addEventListener('DOMContentLoaded', () => {
    // 문서 객체 생성
    const input = document.querySelector('#newTodo')
    const addBtn = document.querySelector('#addBtn')
    const todolist = document.querySelector('#todoList')

    let cnt = 0

    // 핸들러 함수
    const addTodo = () => {
        // console.log(input.value)
        if(input.value.trim() === ''){
            alert('할일을 입력해주세요!!!')
            return 
        }

        // 동적으로 추가할 엘리먼트 생성
        const newDiv = document.createElement('div')
        const checkbox = document.createElement('input')
        const todo = document.createElement('span')
        const btn = document.createElement('button')

        newDiv.appendChild(checkbox)
        newDiv.appendChild(todo)
        newDiv.appendChild(btn)

        // 속성 설정
        newDiv.style.padding = '10px'

        const key = cnt++

        newDiv.setAttribute('data-key', key) // 내가 임의로 만드는 속성. 삭제할 때 이 번호로 식별해서 지우려고

        checkbox.type = 'checkbox'
        todo.textContent = input.value
        btn.textContent = '할일 삭제'


        // 체크박스에 체크되어있으면 밑줄 긋는 이벤트 적용
        checkbox.addEventListener('change', (event) => {
            todo.style.textDecoration = event.target.checked? 'line-through' : ''
        })
        
        // 삭제 버튼 이벤트
        btn.addEventListener('click', () => {
            removeTodo(key)
        })

        // todolist에 새로운 div를 추가
        todolist.appendChild(newDiv)

        // 할일 추가하면 input에서 사라지게
        input.value = ''
    }

    const removeTodo = function(key){
        const delElement = document.querySelector(`div[data-key="${key}"]`)
        todolist.removeChild(delElement)
    }

    // 이벤트 연결
    addBtn.addEventListener('click', addTodo)
})
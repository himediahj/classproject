import React from "react";
import { useState } from "react";

// 단어를 상태로 관리하는 배열에 추가하는 함수 받아서 처리
function WordInput({addWord}){
    const [text, setText] = useState('')

    const handleAddWord = () => {
        addWord(text)
        setText('')
    }

    return(
        <div>
            <input type='text' value={text} onChange={(event)=>setText(event.target.value)}></input>
            <button onClick={handleAddWord}>ADD</button>
        </div>
    )
}

export default WordInput
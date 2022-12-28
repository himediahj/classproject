import React from "react";
import { useState } from "react";

function SignUp(props){
    const [name, setName] = useState('')
    const [gender, setGender] = useState('남자')

    return(
        <form onSubmit={(event) => {
            event.preventDefault()
            alert(`이름 : ${name}, 성별 : ${gender}`)
            }}>
            <label>
                이름 :
                <input type='text' value={name} onChange={(event) => {setName(event.target.value)}}></input>
            </label>
            <br/>
            <label>
                성별 :
                <select value={gender} onChange={(event) => {setGender(event.target.value)}}>
                    <option value='남자'>남자</option>
                    <option value='여자'>여자</option>
                </select>
            </label>
            <br/>
            <button type="submit">제출</button>
        </form>
    )
}

export default SignUp
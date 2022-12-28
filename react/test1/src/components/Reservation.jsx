import React from "react";
import { useState } from "react";

function Reservation(props){
    const [haveBreakfast, setHaveBreakfast] = useState(true)
    const [guestOfNum, setGuestOfNum] = useState(2)

    const handleSubmit = (event) => {
        event.preventDefault()
        alert(`조식 여부 : ${haveBreakfast}, 방문객 수 : ${guestOfNum}`)
    }

    return(
        <form onSubmit={handleSubmit}>
            <label>
                조식 여부 : 
                <input type='checkbox' checked={haveBreakfast} onChange={(event) => {setHaveBreakfast(event.target.checked)}}></input>
            </label><br/>
            <label>
                방문객 수 : 
                <input type='number' value={guestOfNum} onChange={(event) => {setGuestOfNum(event.target.value)}}></input>
            </label>
            <br/>
            <button type="submit">제출</button>
        </form>
    )
}

export default Reservation;
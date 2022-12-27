import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import useCounter from "./useCounter";

const Max_CAPACITY = 10

function Accomodate(props){
    const [isFull, setIsFull] = useState(false)
    const [count, incrementCount, decrementCount] = useCounter(0)
    /* useEffect(()=>{
        console.log('############');
        console.log('useEffect isFull', isFull);
    }) */

    useEffect(()=>{
        /* console.log('============');
        console.log('useEffect isFull', isFull); */
        /* if(count >= Max_CAPACITY){
            setIsFull(true)
        } else setIsFull(false) */
        setIsFull(count>=Max_CAPACITY)  /* if절이랑 같은 내용 */
        console.log('접속 인원 ', count);
    }, [count]) // count값 변경될 때마다

    return (
        <div style={{padding:16, margin:5}}>
            <p>{`총 ${count}명이 입장했습니다.`}</p>
            <button onClick={incrementCount} disabled={isFull}>입장</button>
            <button onClick={decrementCount}>퇴장</button>
            { isFull && <p style={{color:'red'}}>정원이 가득 찼습니다.</p>}   {/* isFull이 true면 뒤에 p 조건 연산된다 */}
        </div>
    )
}

export default Accomodate;
import React from "react";

function NumberList(props){
    const numbers = [1, 2, 3, 4, 5]

    // 배열의 map(callback 반환하는 값) => 새로운 배열 만듦
    const listItems = numbers.map((number, index) => <li key={index}>{number}</li>)    // [{}, {}, {}, {}, {}]

    return (
        <ul>
            {listItems}
        </ul>
    )
}

export default NumberList;
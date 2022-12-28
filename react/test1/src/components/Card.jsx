import React from "react";

function Card({ title, backgroundcolor, children }){
    // const { title, backgroundcolor, children } = props

    return (
        <div style={{margin: 10, padding: 10, borderRadius: 5, boxShadow: '0px 0px 5px gray', backgroundColor: backgroundcolor || 'white'}}>
            { title && <h1>{title}</h1> }   {/* 타이틀이 있다면 && 뒤가 실행 */}
            {children}
        </div>
    )
}

export default Card
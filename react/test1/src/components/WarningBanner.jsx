import React from "react";

function WarningBanner(props){
    // true => 위험!, false => 화면 출력 X
    if(!props.warning){
        return null
    }

    return (
        <>
        <h1>경고!</h1>
        </>
    )
}

export default WarningBanner;
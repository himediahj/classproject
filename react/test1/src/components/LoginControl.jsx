import React from "react";
import { useState } from "react";

function LoginButton(props){
    return (
        <button onClick={props.onClick}>로그인</button> // props.클릭은 이벤트가 아니라 속성
    )
}

function LogoutButton(props){
    return (
        <button onClick={props.onClick}>로그아웃</button>
    )
}

function LoginControl(props){
    const [isLogin, setIsLogin] = useState(false)
    const handleLoginCheck = () => {
        setIsLogin(true)
    }

    const handleLogoutCheck = () => {
        setIsLogin(false)
    }


    let button

    if(isLogin){
        button = <LogoutButton onClick={handleLogoutCheck}/>
    } else button = <LoginButton onClick={handleLoginCheck}/>
    

    return (
        <>
        {button}
        </>
    )
}

export default LoginControl;